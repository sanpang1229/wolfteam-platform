package org.wechat.menu.test;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wechat.common.entity.results.JsonResult;
import org.wechat.menu.entity.BasicMenu;
import org.wechat.menu.entity.ClickMenu;
import org.wechat.menu.entity.GroupButton;
import org.wechat.menu.entity.Menu;
import org.wechat.menu.entity.ReturnMenu;
import org.wechat.menu.entity.ViewMenu;
import org.wechat.menu.entity.WaitMsg;
import org.wechat.menu.utils.MenuConnection;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 创建菜单
 * @author Andy
 *
 */
public class TestMenuConnection {
	private MenuConnection menuConn;

	@Before
	public void init(){
		menuConn = new MenuConnection();
	}
	/**
	 * 测试创建自定义菜单
	 * (测试成功)
	 */
	@Test
	public void testCustomMenu(){
	
		ClickMenu click01 = new ClickMenu();
		click01.setName("2B江南");
		click01.setKey("key02");
		
		ViewMenu viewMenu = new ViewMenu();
		viewMenu.setName("3B半年");
		viewMenu.setUrl("http://www.baidu.com");
		
		GroupButton group = new GroupButton();
		group.setName("测试第二个");
		group.setSub_button(new BasicMenu[]{click01,viewMenu});
		
		ClickMenu click03 = new ClickMenu();
		click03.setName("呆b小二");
		click03.setKey("key02");
		
		ViewMenu viewMenu1 = new ViewMenu();
		viewMenu1.setName("牛B三胖");
		viewMenu1.setUrl("http://www.baidu.com");
		
		GroupButton group1 = new GroupButton();
		group1.setName("全是B");
		group1.setSub_button(new BasicMenu[]{click03,viewMenu1});
		
		org.wechat.menu.entity.Menu menu = new org.wechat.menu.entity.Menu();
		menu.setButton(new BasicMenu[]{group1,group});	//自定义菜单
		
		JsonResult result=menuConn.createMenu(menu, "aVHjNgY_KoMapMMwkb6GANoFMZSPwMEwqnwwHM7L9S473irXfEJIyaTLuEDSdj63FfAsypzLrBShemwFgIPMR6JkxxdcQHXxAfn38-IFJjufYO8KslDukjdXiTEpnNDTFOLaACAZIF");
		Assert.assertNotNull(result);
		System.out.println("errorCode-->"+result.getErrcode());
		System.out.println("errorMsg-->"+result.getErrmsg());
	}
	
	@Test
	public void createMenu() {
		MenuConnection conn = new MenuConnection();
		String token = "aVHjNgY_KoMapMMwkb6GANoFMZSPwMEwqnwwHM7L9S473irXfEJIyaTLuEDSdj63FfAsypzLrBShemwFgIPMR6JkxxdcQHXxAfn38-IFJjufYO8KslDukjdXiTEpnNDTFOLaACAZIF";
		TreeMap<String, String> map = new TreeMap<String, String>();
		map.put("access_token", token);
		String jsonData = "{'button':[{'name':'超值预定','sub_button':[{'key':'rselfmenu_1_2','name':'查询订单','type':'pic_sysphoto'},{'name':'消息','type':'url','url':'http://www.baidu.com'}]},{'name':'点我有礼','sub_button':[{'key':'优惠劵','name':'我的优惠劵','type':'click'},{'key':'游记推荐1','name':'游记推荐','type':'click'}]}]}";
		String result = conn.HttpsDefaultExecute("POST", "https://api.weixin.qq.com/cgi-bin/menu/create", map, jsonData);
		System.out.println(result);
	}
	
	
	/**
	 * 测试获取自定义菜单
	 */
	@Test
	public void testGetMenu(){
		String jsonReuslt = menuConn.getMenu("3qwJbEIIywJzYHZc7ry-xNIm2jVx4v_gVMFrcYtqfgilBlSZ5RHYL2LKOXJa3rXRJPbfFut261vOhPA2QLuunSASuasqlOueY7CJA0HvObd8_ffA8-ys0XhpYu6GmJe_RUPfAEACFA");
		Menu menu = new Menu();
	    List<ReturnMenu> list = new ArrayList<ReturnMenu>();
		if(jsonReuslt!=null&&!"".equals(jsonReuslt)){
			JSONObject object = JSONObject.parseObject(jsonReuslt);
			JSONArray array  = object.getJSONObject("menu").getJSONArray("button");
			for(int i=0;i<array.size();i++){
				ReturnMenu group = new ReturnMenu();
				group = array.getObject(i, ReturnMenu.class);
				list.add(group);
			}
		}
		System.out.println(list.toString());
	}
	
	/**
	 * 测试创建菜单
	 */
	@Test
	public void testMenu(){
		WaitMsg msg = new WaitMsg();
		msg.setName("");
		msg.setKey("");
		String result = JSONObject.toJSON(msg).toString();
		System.out.println(result);
	}
	
	/**
	 * 获取自定义菜单
	 */
	@Test
	public void getCustomMenu(){
		String result = menuConn.getMenu("3qwJbEIIywJzYHZc7ry-xNIm2jVx4v_gVMFrcYtqfgilBlSZ5RHYL2LKOXJa3rXRJPbfFut261vOhPA2QLuunSASuasqlOueY7CJA0HvObd8_ffA8-ys0XhpYu6GmJe_RUPfAEACFA");
		assertNotNull(result);
		System.out.println(result);
	}
	
	/**
	 * 测试连接查询数据库
	 */
	@Test
	public void testConnjdbc(){
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1:3306/mall";
			String user = "root";
			String password = "root";
			String sql = "";
			try {
				Class.forName(driver);
				Connection conn = DriverManager.getConnection(url, user, password);
				if(!conn.isClosed()){
					PreparedStatement statement = conn.prepareStatement(sql);
					ResultSet set = statement.executeQuery();
					while(set.next()){
						System.out.println(set.getString(""));
					}
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
