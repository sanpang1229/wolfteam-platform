package com.wolfteam.controller.wx;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.wechat.abbs.callutils.dispatcher.InstructionObject;
import org.wechat.abbs.callutils.dto.RequestDTO;
import org.wechat.abbs.callutils.dto.ResponseDTO;
import org.wechat.abbs.callutils.thread.AutoExpandExcutor;
import org.wechat.abbs.callutils.thread.Processor;
import org.wechat.abbs.callutils.thread.ResponseCallable;
import org.wechat.abbs.callutils.xml2obj.JaxbMapper;
import org.wechat.common.utils.EncryptUtils;



/**
 *
 * @ClassName: WxEntranceController
 * @Description: 支持 微信公众号入口;
 * @author 作者 E-mail <a href="mailto:158291434@qq.com">三胖</a>
 * @version 创建时间：2016年11月28日 下午4:26:04
 *
 * @version 1.0 
 *  
 */
@Controller
@RequestMapping("/wxEntrance")
public class WxEntranceController {
    protected static final Logger logger = LoggerFactory.getLogger(WxEntranceController.class);


    @RequestMapping(value = "/index")
    public void proceed(HttpServletRequest request, HttpServletResponse response, @RequestParam("v") String v)
            throws IOException {

        logger.info("手动安装应用,回调信息 参数v:" ,v);
        // 入口判断是哪种请求 get 则是校验URL 绑定开发者模式 post 是处理核心业务入口
        boolean isGet = request.getMethod().toLowerCase().equals("get");
        if (isGet) {  // get 请求   就是对接微信公众号平台 第一次 对接平台的时候调用
            // 微信加密签名
            String signature = request.getParameter("signature");
            // 时间戳
            String timestamp = request.getParameter("timestamp");
            // 随机数
            String nonce = request.getParameter("nonce");
            // 随机字符串
            String echostr = request.getParameter("echostr");
            String token ="wolfTeamToken";
            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
            boolean ispass = EncryptUtils.EncryptSHA1(timestamp,token ,nonce,signature );
            logger.info("通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  :" + ispass + "参数signature>>"
                    + signature + ">timestamp>" + timestamp + ">nonce>" + nonce + ">echostr>" + echostr);
            if (ispass) {
                response(response, echostr);
            }
        } else {   // (微信开发者API 消息接收;事件接收;地理信息接收;扫描等事件进入);  

            //  将 reques 请求信息 和 reponse  封装 根据具体的请求类型 进行匹配对应的处理事件
            InstructionObject _io = process(request, System.currentTimeMillis());
            if (_io == null) {
                response(response, "");
                return;
            }
            //基于 Jaxb2.0  实现的XML ---> Object 
            String sRespData = JaxbMapper.toXml(_io.getResponse());

            response(response, sRespData);
        }
    }

    private InstructionObject process(HttpServletRequest request, long startTimeStamp) throws IOException {
        InputStream inStream =null;
        try {
            byte[] buffer = new byte[1024 * 1024];
            inStream = request.getInputStream();
            int length = inStream.read(buffer);
            if (length < 0) {
                inStream.close();
                return null;
            }
            String requestXml = new String(buffer, 0, length, "UTF-8");
            System.out.println(requestXml);
            RequestDTO requestDTO = JaxbMapper.fromXml(requestXml, RequestDTO.class);
            ResponseDTO response = new ResponseDTO(requestDTO);
            //构造指令
            InstructionObject io = new InstructionObject(requestDTO, response);
            //匹配对应的 事件处理类 
            Processor<InstructionObject> processor = InstructionMatcher.match(io);
            
             
            FutureTask<InstructionObject> ft = new FutureTask<InstructionObject>(new ResponseCallable(io,
                    processor, startTimeStamp));
            AutoExpandExcutor.execute(ft);
            io = ft.get(4800, TimeUnit.MILLISECONDS);
            return io;
        } catch (Exception e) {
            logger.error("xxxx",e);
            return null;
        }finally{
            if(inStream!=null)
                inStream.close();
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
