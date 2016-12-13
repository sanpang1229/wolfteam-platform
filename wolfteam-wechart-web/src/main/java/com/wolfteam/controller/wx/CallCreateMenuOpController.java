package com.wolfteam.controller.wx;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wechat.common.entity.results.JsonResult;
import org.wechat.menu.entity.BasicMenu;
import org.wechat.menu.entity.ClickMenu;
import org.wechat.menu.entity.GroupButton;
import org.wechat.menu.entity.ViewMenu;
import org.wechat.menu.utils.MenuConnection;

import com.wolfteam.common.vo.TaotaoResult;

/**
 *
 * @ClassName: CallCreateMenuOpController
 * @Description: 创建微信菜单接口
 * @author 作者 E-mail <a href="mailto:158291434@qq.com">三胖</a>
 * @version 创建时间：2016年11月29日   下午4:26:42
 *
 * @version 1.0 
 *  
 */
@Controller
@RequestMapping("/menu")
public class CallCreateMenuOpController {
    protected static final Logger logger = LoggerFactory.getLogger(WxEntranceController.class);


    @RequestMapping(value = "/create")
    @ResponseBody
    public TaotaoResult proceed(HttpServletRequest request, HttpServletResponse response, @RequestParam("v") String v)
            throws IOException {
        
        MenuConnection menuConn = new MenuConnection();
        
        ClickMenu click01 = new ClickMenu();
        click01.setName("名称"+v);
        click01.setKey("key02");
        
        ViewMenu viewMenu = new ViewMenu();
        viewMenu.setName("3B半年"+v);
        viewMenu.setUrl("http://www.baidu.com");
        
        GroupButton group = new GroupButton();
        group.setName("测试第二个"+v);
        group.setSub_button(new BasicMenu[]{click01,viewMenu});
        
        ClickMenu click03 = new ClickMenu();
        click03.setName("呆b小二"+v);
        click03.setKey("key02");
        
        ViewMenu viewMenu1 = new ViewMenu();
        viewMenu1.setName("牛B三胖"+v);
        viewMenu1.setUrl("http://www.baidu.com");
        
        GroupButton group1 = new GroupButton();
        group1.setName("全是B"+v);
        group1.setSub_button(new BasicMenu[]{click03,viewMenu1});
        
        org.wechat.menu.entity.Menu menu = new org.wechat.menu.entity.Menu();
        menu.setButton(new BasicMenu[]{group1,group});  //自定义菜单
        
        JsonResult result=menuConn.createMenu(menu, "aVHjNgY_KoMapMMwkb6GANoFMZSPwMEwqnwwHM7L9S473irXfEJIyaTLuEDSdj63FfAsypzLrBShemwFgIPMR6JkxxdcQHXxAfn38-IFJjufYO8KslDukjdXiTEpnNDTFOLaACAZIF");
        Assert.assertNotNull(result);
        System.out.println("errorCode-->"+result.getErrcode());
        System.out.println("errorMsg-->"+result.getErrmsg());
        TaotaoResult bb = new TaotaoResult();
        bb.setMsg("errorMsg-->"+result.getErrmsg());
        bb.setStatus(result.getErrcode());
        return bb;
        
    }
    

}
