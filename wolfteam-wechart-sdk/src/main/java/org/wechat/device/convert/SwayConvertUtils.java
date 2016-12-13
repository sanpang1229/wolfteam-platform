package org.wechat.device.convert;

import org.wechat.common.entity.results.WechatResult;
import org.wechat.common.entity.results.ResultState;
import org.wechat.common.utils.ConvertJsonUtils;
import org.wechat.device.response.ApplyResult;
import org.wechat.device.response.BeaconInfoResponse;
import org.wechat.device.response.CountDataResponse;
import org.wechat.device.response.Less500Result;
import org.wechat.device.response.PagerResponse;
import org.wechat.device.response.QueryResponse;
import org.wechat.device.response.SearchResult;


/**
 * 转换工具类
 * @author Andy
 *
 */
public class SwayConvertUtils {
	
	/**
	 * 当单次申请此时超过500次时的操作
	 * @param jsonData	json格式的字符串
	 * Result.success==true  Result.obj = ApplyResult
	 * Result.success==false result.obj = toString
	 */
	public static WechatResult SizeOver500(String jsonData){
		WechatResult result = new WechatResult();
		if(jsonData!=null&&!"".equals(jsonData)){
			ApplyResult applyResult = ConvertJsonUtils.jsonToJavaObject(jsonData,ApplyResult.class);
			result.setMsg(jsonData);
			result.setObj(applyResult);
			result.setSuccess(true);
		}else{
			result.setObj("response json data is null!");
			result.setMsg(jsonData);
		}
		return result;
	}
	
	
	/**
	 * 当单词申请小于500次时返回的结果
	 * @param jsonData	json格式的字符串
	 * @return
	 */
	public static WechatResult SizeLess500(String jsonData){
		WechatResult result = new WechatResult();
		if(jsonData!=null&&!"".equals(jsonData)){
			Less500Result less = ConvertJsonUtils.jsonToJavaObject(jsonData,Less500Result.class);
			result.setMsg(jsonData);
			result.setObj(less);
			result.setSuccess(true);
		}else{
			result.setObj("response json data is null!");
			result.setMsg(jsonData);
		}
		return result;
	}
	
	/**
	 * 将jsonData转换为json格式的字符串
	 * @param jsonData	待转换的json格式字符串
	 * @return
	 * Result.succss==true 则Result.obj = ResultState
	 * Result.succss==false 则Result.obj = error info
	 */
	public static WechatResult bindlocation(String jsonData){
		WechatResult result = new WechatResult();
		if(jsonData!=null&&!"".equals(jsonData)){
			ResultState state = ConvertJsonUtils.jsonToJavaObject(jsonData,ResultState.class);
			result.setObj(state);
			result.setSuccess(true);
			result.setMsg(jsonData);
		}else{
			result.setObj("response json data is null!");
			result.setMsg(jsonData);
		}
		return result;
	}
	
	/**
	 * 搜索设备返回的结果
	 * @param jsonData	带转换的json格式字符串
	 * @return 
	 */
	public static WechatResult SearchDevice(String jsonData){
		WechatResult result = new WechatResult();
		if(jsonData!=null&&!"".equals(jsonData)){
			SearchResult searchResult = ConvertJsonUtils.jsonToJavaObject(jsonData,SearchResult.class);
			result.setObj(searchResult);
			result.setSuccess(true);
			result.setMsg(jsonData);
		}else{
			result.setObj("response json data is null!");
			result.setMsg(jsonData);
		}
		return result;
	}
	
	/**
	 * 摇一摇新增页面
	 * @param jsonData 待转换的json格式的字符串
	 * @return	
	 */
	public static WechatResult Pager(String jsonData){
		WechatResult result = new WechatResult();
		if(jsonData!=null&&!"".equals(jsonData)){
			PagerResponse response = ConvertJsonUtils.jsonToJavaObject(jsonData,PagerResponse.class);
			result.setSuccess(true);
			result.setObj(response);
		}else{
			result.setObj("response json data is null!");
		}
		return result;
	}
	
	/**
	 * 查询页面列表
	 * @param jsonData
	 * @return
	 */
	public static WechatResult QueryPagerResult(String jsonData){
		WechatResult result = new WechatResult();
		if(jsonData!=null&&!"".equals(jsonData)){
			QueryResponse response = ConvertJsonUtils.jsonToJavaObject(jsonData,QueryResponse.class);
			result.setSuccess(true);
			result.setObj(response);
		}else{
			result.setObj("response json data is null!");
		}
		return result;
	}
	
	/**
	 * 转换页面关联
	 * @param jsonData	json格式的字符串
	 * @return
	 * Result.success = true 表示用result.obj = state
	 * Result.success = false 表示用 result.object = error tips info
	 */
	public static WechatResult ConvertConfigurePageConn(String jsonData){
		WechatResult result = new WechatResult();
		if(jsonData!=null&&!"".equals(jsonData)){
			ResultState state = ConvertJsonUtils.jsonToJavaObject(jsonData,ResultState.class);
			result.setSuccess(true);
			result.setObj(state);
		}else{
			result.setObj("response json data is null!");
		}
		return result;
	}
	
	/**
	 * 将json格式的字符串转换为结果对象
	 * @param jsonData	待转换的json格式字符串
	 * Result.success = true 表示用result.obj = BeaconInfoResponse
	 * Result.success = false 表示用 result.object = error tips info
	 */
	public static WechatResult ConvertGetSharkeinfo(String jsonData){
		WechatResult result = new WechatResult();
		if(jsonData!=null&&!"".equals(jsonData)){
			BeaconInfoResponse response = ConvertJsonUtils.jsonToJavaObject(jsonData,BeaconInfoResponse.class);
			result.setSuccess(true);
			result.setObj(response);
		}else{
			result.setObj("response json data is null!");
		}
		return result;
	}
	
	/**
	 * 以设备为维度的数据统计接口
	 * @param jsonData
	 * @return
	 */
	public static WechatResult ConvertDeviceCount(String jsonData){
		WechatResult result = new WechatResult();
		if(jsonData!=null&&!"".equals(jsonData)){
			CountDataResponse response = ConvertJsonUtils.jsonToJavaObject(jsonData,CountDataResponse.class);
			result.setSuccess(true);
			result.setObj(response);
		}else{
			result.setObj("response json data is null!");
		}
		return result;
	}
}
	
	
