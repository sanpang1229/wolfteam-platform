package com.wolfteam.controller.wx;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.box.tei.thread.AutoExpandExcutor;
import com.box.tei.thread.ResponseCallable;
import com.wolfteam.conmon.JaxbMapper;
import com.wolfteam.conmon.wx.WxSignUtil;
import com.wolfteam.dto.InstructionObject;
import com.wolfteam.dto.RequestDTO;
import com.wolfteam.dto.ResponseDTO;
import com.wolfteam.service.process.Processor;

/**
 * @author 作者 E-mail <a href="mailto:158291434@qq.com">三胖</a>
 * @version 创建时间：2016年8月26日 下午6:02:26 类说明 支持 微信公众号入口;
 *
 * @version 1.0
 * 
 */
@Controller
@RequestMapping("/wxEntrance")
public class WxEntranceController {

    private static Log log = LogFactory.getLog(WxEntranceController.class);

    @RequestMapping(value = "/index")
    public void proceed(HttpServletRequest request, HttpServletResponse response, @RequestParam("v") String v)
            throws IOException {

        log.info("手动安装应用,回调信息 参数v:" + v);
        // 入口判断是哪种请求 get 则是校验URL 绑定开发者模式 post 是处理核心业务入口
        boolean isGet = request.getMethod().toLowerCase().equals("get");
        if (isGet) {
            // 微信加密签名
            String signature = request.getParameter("signature");
            // 时间戳
            String timestamp = request.getParameter("timestamp");
            // 随机数
            String nonce = request.getParameter("nonce");
            // 随机字符串
            String echostr = request.getParameter("echostr");

            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
            boolean ispass = WxSignUtil.checkSignature(signature, timestamp, nonce);
            log.info("通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  :" + ispass + "参数signature>>"
                    + signature + ">timestamp>" + timestamp + ">nonce>" + nonce + ">echostr>" + echostr);
            if (ispass) {
                response(response, echostr);
            }
        } else {
            InstructionObject _io = process(request, System.currentTimeMillis());
            if (_io == null) {
                response(response, "");
                return;
            }
            String sRespData = JaxbMapper.toXml(_io.getResponse());

            response(response, sRespData);
        }
    }

    private InstructionObject process(HttpServletRequest request, long startTimeStamp) throws IOException {
        byte[] buffer = new byte[1024 * 1024];
        InputStream inStream = request.getInputStream();
        int length = inStream.read(buffer);
        if (length < 0) {
            inStream.close();
            return null;
        }
        String requestXml = new String(buffer, 0, length, "UTF-8");
        System.out.println(requestXml);
        inStream.close();
        inStream.close();
        try {
            RequestDTO requestDTO = JaxbMapper.fromXml(requestXml, RequestDTO.class);
            ResponseDTO response = new ResponseDTO(requestDTO);
            InstructionObject io = new InstructionObject(requestDTO, response);
            Processor<InstructionObject> processor = InstructionMatcher.match(io);
            FutureTask<InstructionObject> ft = new FutureTask<InstructionObject>(new ResponseCallable(io,
                    processor, startTimeStamp));
            AutoExpandExcutor.execute(ft);
            io = ft.get(4800, TimeUnit.MILLISECONDS);
            return io;
        } catch (Exception e) {
            log.error(e);
            return null;
        }
    }

    public void response(HttpServletResponse response, String respText) {
        PrintWriter out;
        response.setCharacterEncoding("utf-8");
        try {
            out = response.getWriter();
            System.out.println("返回信息：");
            System.out.println(respText);
            out.print(respText);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
