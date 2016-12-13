package org.wechat.material.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.wechat.common.entity.results.WechatResult;
import org.wechat.material.conn.MeaterConn;
import org.wechat.material.result.CountEntity;
import org.wechat.material.result.MaterMsg;
import org.wechat.material.result.MeterResult;
import org.wechat.material.result.NewsList;
import org.wechat.material.result.OtherList;
import org.wechat.msg.entity.NewsEntity;

/**
 * 测试上传素材接口
 * @author Andy
 *
 */
public class TestMaterialConn {
	private MeaterConn mMeaterConn;
	private String accessToken;
	private String resultStr;
	
	@Before
	public void init(){
		mMeaterConn = new MeaterConn();
		accessToken = "DSYEI0cRJvJL_R5mBGQLvpJhEmsR89XDlUXPILa2nEOq3IZSYIgFj8QEXkPqOf8-9G33Rv2d9M4jupjUtUOESn268QfHH8zIGjET9CgbQdY";
	}
	
	/** (测试通过)
	 * 新增临时素材
	 * [created_at=1427379900, media_id=xKCK9v45nhsJbR50FPm4uLALaMRKjzmdhm3dqhkF5W51SYK5cVQtHXo3gYG9NIPB, type=image]
	 * [created_at=1427382503, media_id=KiTsFei88XhAGYsWl4TsCoekH0vIjimgEGYR_ZhLzrAmPuUV3areSMtDUS1OJlzY, type=image]
	 */
	@Test
	public void testAddTempMeater()throws Exception{
		String mediaType="image";
		String mediaPath ="http://avatar.csdn.net/E/D/6/1_yzh54ak.jpg";
		WechatResult result = mMeaterConn.addTempMeater(accessToken, mediaType, mediaPath);
		if(result.isSuccess()&&result.getType()==1){	//表示成功
			MeterResult materResult = (MeterResult) result.getObj();
			resultStr = materResult.toString();
		}else if(result.isSuccess()&&result.getType()==0){	//对应的错误吗
			MaterMsg msg = (MaterMsg) result.getObj();
			resultStr = msg.toString();
		}else{
			resultStr = result.getObj().toString();
		}
		System.out.println(resultStr);
	}
	
	/**
	 * 获取临时素材
	 * 能够获取 图片/语音消息
	 * (测试通过)
	 */
	@Test
	public void testGetTempMeater(){
		String mediaId = "KiTsFei88XhAGYsWl4TsCoekH0vIjimgEGYR_ZhLzrAmPuUV3areSMtDUS1OJlzY";
		String savePath = "E://test//test//21212.jpg";
		WechatResult result = mMeaterConn.getTempMeater(accessToken,mediaId,savePath);
		System.out.println(result.getObj().toString());
		System.out.println(result.isSuccess());
	}
	
	/**
	 * 新增其他永久素材
	 * {"media_id":"8794800285"}
	 */
	@Test
	public void testAddForverOther(){
		String savePath = "http://www.680.com/images/680.png";
		String result = mMeaterConn.addForverOther(accessToken, savePath);
		System.out.println(result);
	}
	
	/**
	 * 新增永久图文素材
	 * MeterResult [created_at=0, media_id=17384734893, type=null]
	 * MeterResult [created_at=0, media_id=17384735649, type=null]
	 */
	@Test
	public void testAddFOrverNews(){
		String resultStr = "";
		List<NewsEntity> array = new ArrayList<NewsEntity>();
		NewsEntity entity = new NewsEntity();
		entity.setAuthor("author");
		entity.setContent("Contnet");
		entity.setContent_source_url("http://www.baidu.com");
		entity.setDigest("digest");
		entity.setShow_conver_pic(1);
		entity.setThumb_media_id("8794800285");
		entity.setTitle("title");
		array.add(entity);
		WechatResult result = mMeaterConn.addForeverNew(accessToken, array);
		if(result.isSuccess()==true&&result.getType()==1){
			MeterResult meterResult = (MeterResult) result.getObj();
			resultStr = meterResult.toString();
		}else if(result.isSuccess()==true&&result.getType()==0){
			MaterMsg msg = (MaterMsg) result.getObj();
			resultStr = msg.toString();
		}
		System.out.println(resultStr);
	}
	
	/**
	 * 获取永久图文素材
	 * 8794800285(通过测试)
	 */
	@Test
	public void testgetForverNews(){
		String mediaId = "17384734893";
		WechatResult result = mMeaterConn.getForverNews(accessToken, mediaId);
		if(result.isSuccess()==true&&result.getType()==1){
			List<NewsEntity> list = (List<NewsEntity>) result.getObj();
			if(list!=null&&list.size()>0){
				for(NewsEntity entity:list){
					System.out.println(entity.getThumb_media_id());
				}
			}
		}else if(result.isSuccess()==true&&result.getType()==0){
			MaterMsg msg = (MaterMsg) result.getObj();
			System.out.println(msg.toString());
		}
	}
	
	/**
	 * 删除永久素材 (未通过测试)
	 * 包括其他永久素材和图文永久素材
	 * [errcode=0, errmsg=ok]
	 */
	@Test
	public void testDeleteForverNews(){
		String mediaId = "8794799975";
		MaterMsg msg = mMeaterConn.deleteForverNews(accessToken, mediaId);
		System.out.println(msg);
	}
	
	/**
	 * 修改图文消息
	 * {"errcode":47001,"errmsg":"data format error"}
	 * (未通过测试)
	 */
	@Test
	public void testUpdateaForverNews(){
		String mediaId = "17384734893";
		List<NewsEntity> array = new ArrayList<NewsEntity>();
		NewsEntity entity = new NewsEntity();
		entity.setAuthor("author");
		entity.setContent("Contnet");
		entity.setContent_source_url("http://www.baidu.com");
		entity.setDigest("digest");
		entity.setShow_conver_pic(1);
		entity.setThumb_media_id("8794800285");
		entity.setTitle("tit121212le");
		array.add(entity);
		MaterMsg msg = mMeaterConn.updateNewsForver(accessToken, mediaId, 0, array);
		System.out.println(msg);
	}
	
	/**
	 * 统计素材列表 (测试通过)
	 * 测试结果    [image_count=86, news_count=21, video_count=0, voice_count=0]
	 */
	@Test
	public void testGetCountMeterial(){
		String resultStr = "";
		WechatResult result = mMeaterConn.getCountMeterial(accessToken);
		if(result.isSuccess()==true&&result.getType()==1){
			CountEntity entity = (CountEntity) result.getObj();
			resultStr = entity.toString();
		}else if(result.isSuccess()==true&&result.getType()==0){
			MaterMsg msg = (MaterMsg) result.getObj();
			resultStr = msg.toString();
		}
		System.out.println(resultStr);
	}
	
	/**
	 * 获取素材列表 (测试通过)
	 * OtherList [item_count=10, list=[org.wechat.material.result.OtherItem@3e89c3, org.wechat.material.result.OtherItem@1c695a6, org.wechat.material.result.OtherItem@8acf6e, org.wechat.material.result.OtherItem@1386918, org.wechat.material.result.OtherItem@7bb290, org.wechat.material.result.OtherItem@10849bc, org.wechat.material.result.OtherItem@120d62b, org.wechat.material.result.OtherItem@ccc588, org.wechat.material.result.OtherItem@1bc82e7, org.wechat.material.result.OtherItem@1362012], total_count=86]
	 */
	@Test
	public void testGetMeaterList(){
		String resultStr = "";
		String type = "news";
		WechatResult result = mMeaterConn.getMeaterList(accessToken,type,0,10);
		if(result.isSuccess()==true&&result.getType()==0){
			MaterMsg msg = (MaterMsg) result.getObj();
			resultStr = msg.toString();
		}else if(result.isSuccess()==true&&result.getType()==1){
			NewsList list = (NewsList) result.getObj();
			resultStr = list.toString();
		}else if(result.isSuccess()==true&&result.getType()==2){
			OtherList otherList = (OtherList) result.getObj();
			resultStr = otherList.toString();
		}else{
			resultStr = result.getObj().toString();
		}
		System.out.println(resultStr);
	}
}
