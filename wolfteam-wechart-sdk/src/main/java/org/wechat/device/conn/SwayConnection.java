package org.wechat.device.conn;

import java.util.TreeMap;

import org.wechat.common.conn.Connection;
import org.wechat.common.entity.results.WechatResult;
import org.wechat.common.entity.results.ResultState;
import org.wechat.common.utils.ConvertJsonUtils;
import org.wechat.device.convert.SwayConvertUtils;
import org.wechat.device.request.DeviceIdentifier;
import org.wechat.device.request.EditPagerRequest;
import org.wechat.device.request.PageRequest;

/**
 * 摇一摇功能的连接工具类
 * @author Andy
 *
 */
public class SwayConnection extends Connection{

	/**
	 * 添加设备id的path
	 */
	private static final String ADDDEVICE="https://api.weixin.qq.com/shakearound/device/applyid";
	//更新设备
	private static final String EDITDEVICE="https://api.weixin.qq.com/shakearound/device/update";
	//配置绑定设置
	private static final String BINDLOCATION="https://api.weixin.qq.com/shakearound/device/bindlocation";
	//查询设备列表
	private static final String SEACH="https://api.weixin.qq.com/shakearound/device/search";
	//新增页面
	private static final String ADDPAGE="https://api.weixin.qq.com/shakearound/page/add";
	//摇一摇修改页面
	private static final String UPDATEPAGE="https://api.weixin.qq.com/shakearound/page/update";
	//查询页面
	private static final String QUERYPAGE="https://api.weixin.qq.com/shakearound/page/search";
	//删除页面
	private static final String DELETEPAGE="https://api.weixin.qq.com/shakearound/page/delete";
	//配置设备与页面的关联 
	private static final String CONFIGURE="https://api.weixin.qq.com/shakearound/device/bindpage";
	//获取周边设备信息
	private static final String GETSHAKEINFO="https://api.weixin.qq.com/shakearound/user/getshakeinfo";
	//以设备为维度的统计接口
	private static final String DEVICECOUNT="https://api.weixin.qq.com/shakearound/statistics/device";
	//以页面为维度的统计接口
	private static final String PAGECOUNT="https://api.weixin.qq.com/shakearound/statistics/page";
	//
	private static final int SIZE=500;			//
	
	
	/**
	 * 以设备为维度的数据统计接口
	 * @param accessToken	授权token
	 * @param entifier		 指定页面的设备ID
	 * @param begin_date	起始日期时间戳，最长时间跨度为30天
	 * @param end_date		结束日期时间戳，最长时间跨度为30天
	 * @return
	 */
	public WechatResult deviceCount(String accessToken,DeviceIdentifier entifier,long begin_date,long end_date){
		WechatResult result = null;
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("access_token",accessToken);
		//post data
		TreeMap<String,Object> dataParams = new TreeMap<String,Object>();
		dataParams.put("device_identifier", entifier);
		dataParams.put("begin_date",begin_date);
		dataParams.put("end_date", end_date);
		String data = ConvertJsonUtils.toJsonString(dataParams);
		String resultObj =  HttpDefaultExecute("POST", DEVICECOUNT, params, data);
		result = SwayConvertUtils.ConvertDeviceCount(resultObj);
		return result;
	}
	
	/**
	 * 以页面为维度的数据统计接口
	 * @param accessToken	授权token
	 * @param entifier		 指定页面的设备ID
	 * @param begin_date	起始日期时间戳，最长时间跨度为30天
	 * @param end_date		结束日期时间戳，最长时间跨度为30天
	 * @return
	 */
	public WechatResult PageCount(String accessToken,long page_id,long begin_date,long end_date){
		WechatResult result = null;
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("access_token",accessToken);
		//post data
		TreeMap<String,Long> dataParams = new TreeMap<String,Long>();
		dataParams.put("page_id", page_id);
		dataParams.put("begin_date",begin_date);
		dataParams.put("end_date", end_date);
		String data = ConvertJsonUtils.toJsonString(dataParams);
		String resultObj =  HttpDefaultExecute("POST", PAGECOUNT, params, data);
		result = SwayConvertUtils.ConvertDeviceCount(resultObj);
		return result;
	}
	
	
	/**
	 * 获取摇周边的设备及用户信息
	 * @param accessToken	授权token
	 * @param ticket		摇周边业务的ticket，可在摇到的URL中得到，ticket生效时间为30分钟
	 * @return
	 * Result.success = true 表示用result.obj = BeaconInfoResponse
	 * Result.success = false 表示用 result.object = error tips info
	 */
	public WechatResult getSharkeinfo(String accessToken,String ticket){
		WechatResult result = null;
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("access_token", accessToken);
		//post submit data
		TreeMap<String,String> postParams = new TreeMap<String,String>();
		postParams.put("ticket", ticket);
		String data = ConvertJsonUtils.toJsonString(postParams);
		String resultObj = HttpDefaultExecute("POST", GETSHAKEINFO, params, data);
		result = SwayConvertUtils.ConvertGetSharkeinfo(resultObj);
		return result;
	}
	/**
	 * 配置与页面的关联
	 * @param accessToken	授权token
	 * @param identifier	指定页面的设备ID
	 * @param array			待关联的页面列表
	 * @param bind			关联操作标志位， 0为解除关联关系，1为建立关联关系
	 * @param append		新增操作标志位， 0为覆盖，1为新增
	 * @return	
	 * Result.success = true 表示用result.obj = state 
	 * Result.success = false 表示用 result.object = error tips info
	 */
	public WechatResult configurePageConn(String accessToken,DeviceIdentifier identifier,int[] array,int bind,int append){
		WechatResult result = null;
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("access_token",accessToken);
		//post data
		TreeMap<String,Object> dataParams = new TreeMap<String,Object>();
		dataParams.put("device_identifier",identifier);
		dataParams.put("page_ids",array);
		dataParams.put("bind",bind);
		dataParams.put("append",append);
		String data = ConvertJsonUtils.toJsonString(dataParams);
		String dataResult = HttpDefaultExecute("POST", CONFIGURE, params, data);
		result = SwayConvertUtils.ConvertConfigurePageConn(dataResult);
		return result;
	}
	/***
	 * 需要查询指定页面时
	 * @param accessToken
	 * @param array
	 * @return
	 */
	public WechatResult SearchPagerByPageId(String accessToken,Integer[] array){
		WechatResult result = null;
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("access_token",accessToken);
		//post data
		TreeMap<String,Integer[]> postParams = new TreeMap<String,Integer[]>();
		postParams.put("page_ids",array);
		String data = ConvertJsonUtils.toJsonString(postParams);
		String dataReslt = HttpDefaultExecute("POST", QUERYPAGE, params, data);
		result = SwayConvertUtils.QueryPagerResult(dataReslt);
		return result;
	}
	
	/***
	 * 需要分页查询或者指定范围内的页面时：
	 * @param accessToken
	 * @param array
	 * @return
	 */
	public WechatResult SearchPagerByPageId(String accessToken,int begin,int count){
		WechatResult result = null;
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("access_token",accessToken);
		//post data
		TreeMap<String,Integer> postParams = new TreeMap<String,Integer>();
		postParams.put("begin",begin);
		postParams.put("count",count);
		String data = ConvertJsonUtils.toJsonString(postParams);
		String dataReslt = HttpDefaultExecute("POST", QUERYPAGE, params, data);
		result = SwayConvertUtils.QueryPagerResult(dataReslt);
		return result;
	}
	
	
	/**
	 * 添加设备
	 * @param accessToken 授权token
	 * @param quantity	申请的设备ID的数量，单次新增设备超过500个，需走人工审核流程
	 * @param apply_reason 申请理由，不超过100个字
	 * @param comment	备注，不超过15个汉字或30个英文字母
	 * @param poi_id  设备关联的门店ID
	 */
	public WechatResult addDeviceId(String accessToken,int quantity,String apply_reason,String comment,long poi_id){
		WechatResult result = new WechatResult();
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("access_token", accessToken);
		//
		TreeMap<String,String> dataParams = new TreeMap<String,String>();
		dataParams.put("quantity",String.valueOf(quantity));
		dataParams.put("apply_reason", apply_reason);
		dataParams.put("comment",comment);
		dataParams.put("poi_id",String.valueOf(poi_id));
		String data = ConvertJsonUtils.toJsonString(dataParams);
		String dataReslt = HttpDefaultExecute("POST", ADDDEVICE, params, data);
		if(quantity<=SIZE){
			result = SwayConvertUtils.SizeLess500(dataReslt);
			result.setType(1);
		}else{
			result = SwayConvertUtils.SizeLess500(dataReslt);
			result.setType(2);
		}
		return result;
	}
	
	/**
	 * 编辑设备信息
	 * @param accessToken	授权token
	 * @param identifier	device_identifier 实体对象
	 * @param comment		设备的备注
	 * @return
	 * Result.success==true 则Result.obj = ResultState
	 * Result.success==false 则Result.obj = 错误提示信息
	 */
	public WechatResult EditDeviceInfo(String accessToken,DeviceIdentifier identifier,String comment){
		WechatResult resultObj = new WechatResult();
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("access_token",accessToken);
		//post data Params
		TreeMap<String,Object> postParams = new TreeMap<String,Object>();
		postParams.put("device_identifier",identifier);
		postParams.put("comment",comment);
		String  postData = ConvertJsonUtils.toJsonString(postParams);
		String result = HttpDefaultExecute("POST", EDITDEVICE, params, postData);
		if(result!=null&&!"".equals(result)){
			ResultState state = ConvertJsonUtils.jsonToJavaObject(result, ResultState.class);
			resultObj.setSuccess(true);
			resultObj.setObj(state);
		}else{
			resultObj.setMsg(result);
			resultObj.setObj("response result is null");
		}
		return resultObj;
	}
	
	/**
	 * 配置设备与门店的关联关系
	 * @param accessToken	授权token
	 * @param identifier	门店关联的请求信息
	 * @param poiId			待关联的门店ID
	 * @return
	 *  Result.succss==true 则Result.obj = ResultState
	 * Result.succss==false 则Result.obj = error info
	 */
	public WechatResult configureBindlocation(String accessToken,DeviceIdentifier identifier,long poiId){
		WechatResult resultObj = new WechatResult();
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("access_token",accessToken);
		//post request data
		TreeMap<String,Object> postParams = new TreeMap<String,Object>();
		postParams.put("device_identifier",identifier);
		postParams.put("poi_id", poiId);
		String data = ConvertJsonUtils.toJsonString(postParams);
		String result = HttpDefaultExecute("POST", BINDLOCATION, params, data);
		resultObj =SwayConvertUtils.bindlocation(result);
		return resultObj;
	}
	
	/**
	 * 查询指定设备	
	 * @param accessToken  授权token
	 * @param identifier	通过
	 * @return	
	 */
	public WechatResult searchByDevice(String accessToken,DeviceIdentifier identifier){
		WechatResult result = new WechatResult();
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("access_token",accessToken);
		//post data
		TreeMap<String,DeviceIdentifier> postParams = new TreeMap<String,DeviceIdentifier>();
		postParams.put("device_identifiers",identifier);
		String data = ConvertJsonUtils.toJsonString(postParams);
		String responseResult = HttpDefaultExecute("POST", SEACH, params, data);
		result = SwayConvertUtils.SearchDevice(responseResult);
		return result;
	}
	
	/**
	 * 需要分页查询或者指定范围内的设备时：
	 * @param accessToken	授权token
	 * @param begin			开始标识
	 * @param count			获取数量
	 * @return
	 */
	public WechatResult searchByPage(String accessToken,int begin,int count){
		WechatResult result = new WechatResult();
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("access_token",accessToken);
		//post data
		TreeMap<String,Integer> postParams = new TreeMap<String,Integer>();
		postParams.put("begin",begin);
		postParams.put("count",count);
		String data = ConvertJsonUtils.toJsonString(postParams);
		String responseResult = HttpDefaultExecute("POST", SEACH, params, data);
		result = SwayConvertUtils.SearchDevice(responseResult);
		return result;
	}
	
	/**
	 * 需要分页查询或者指定范围内的设备时：
	 * @param accessToken	授权token
	 * @param begin			开始标识
	 * @param count			获取数量
	 * @return
	 */
	public WechatResult searchById(String accessToken,int apply_id,int begin,int count){
		WechatResult result = new WechatResult();
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("access_token",accessToken);
		//post data
		TreeMap<String,Integer> postParams = new TreeMap<String,Integer>();
		postParams.put("begin",begin);
		postParams.put("count",count);
		postParams.put("apply_id",apply_id);
		String data = ConvertJsonUtils.toJsonString(postParams);
		String responseResult = HttpDefaultExecute("POST", SEACH, params, data);
		result = SwayConvertUtils.SearchDevice(responseResult);
		return result;
	}
	
	/**
	 * 摇一摇添加页面
	 * @param accessToken	 授权token
	 * @param request		请求参数
	 * @return
	 * Reuslt.success==true 则 Result.data=PagerResponse
	 * Reuslt.success==false 则 Result.data=error tips info
	 */
	public WechatResult addPager(String accessToken,PageRequest request){
		WechatResult result = null;
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("access_token", accessToken);
		//post data
		String data = ConvertJsonUtils.toJsonString(request);
		String dataReslt = HttpDefaultExecute("POST", ADDPAGE, params, data);
		result = SwayConvertUtils.Pager(dataReslt);
		return result;
	}
	

	/**
	 * 删除页面
	 * @param accessToken	授权token 
	 * @param array			指定页面的id列表 (待删除的id列表)
	 * @return
	 */
	public WechatResult DeletePager(String accessToken,String[] array){
		WechatResult result = null;
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("access_token", accessToken);
		TreeMap<String,String[]> postParams = new TreeMap<String,String[]>();
		postParams.put("page_ids",array);
		String data = ConvertJsonUtils.toJsonString(postParams);
		String dataResult = HttpDefaultExecute("POST", DELETEPAGE, params, data);
		result = SwayConvertUtils.Pager(dataResult);
		return result;
	}
	
	/**
	 * 编辑页面
	 * @param accessToken	授权token
	 * @param request		请求参数对象
	 * @return
	 */
	public WechatResult EditPager(String accessToken,EditPagerRequest request){
		WechatResult result = null;
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("access_token", accessToken);
		//post data
		String data = ConvertJsonUtils.toJsonString(request);
		String dataResult = HttpDefaultExecute("POST", UPDATEPAGE, params, data);
		result = SwayConvertUtils.Pager(dataResult);
		return result;
	}
	
}
