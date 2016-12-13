package com.wolfteam.po;
import java.io.Serializable;


/**
 * 
 * 
 * 
 **/
@SuppressWarnings("serial")
public class SubscribeUser2 implements Serializable {

	/**主键**/
	private Integer id;

	/**微信加密后**/
	private String openId;

	/**是否关注**/
	private String isSubscribe;

	/**昵称**/
	private String nickName;

	/**性别**/
	private Integer sex;

	/**用户所在城市**/
	private String city;

	/**用户所在国家**/
	private String country;

	/**用户所在省份**/
	private String province;

	/**用户的语言，简体中文为zh_CN**/
	private String language;

	/**用户头像**/
	private String headImgUrl;

	/**用户关注时间**/
	private java.util.Date subscribeTime;

	/**只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段**/
	private String unionId;

	/**公众号运营者对粉丝的备注**/
	private String remark;

	/**用户所在的分组ID（兼容旧的用户分组接口）**/
	private String groupId;

	/**用户被打上的标签ID列表**/
	private String tagIdList;

	/**公众号平台**/
	private String platformName;

	/**系统创建时间**/
	private java.util.Date createTime;

	/**系统修改时间**/
	private java.util.Date updateTime;

	/**删除标志**/
	private Integer deleteFlag;



	public SubscribeUser2 setId(Integer id){
		this.id = id;
		return this;
	}

	public Integer getId(){
		return this.id;
	}

	public SubscribeUser2 setOpenId(String openId){
		this.openId = openId;
		return this;
	}

	public String getOpenId(){
		return this.openId;
	}

	public SubscribeUser2 setIsSubscribe(String isSubscribe){
		this.isSubscribe = isSubscribe;
		return this;
	}

	public String getIsSubscribe(){
		return this.isSubscribe;
	}

	public SubscribeUser2 setNickName(String nickName){
		this.nickName = nickName;
		return this;
	}

	public String getNickName(){
		return this.nickName;
	}

	public SubscribeUser2 setSex(Integer sex){
		this.sex = sex;
		return this;
	}

	public Integer getSex(){
		return this.sex;
	}

	public SubscribeUser2 setCity(String city){
		this.city = city;
		return this;
	}

	public String getCity(){
		return this.city;
	}

	public SubscribeUser2 setCountry(String country){
		this.country = country;
		return this;
	}

	public String getCountry(){
		return this.country;
	}

	public SubscribeUser2 setProvince(String province){
		this.province = province;
		return this;
	}

	public String getProvince(){
		return this.province;
	}

	public SubscribeUser2 setLanguage(String language){
		this.language = language;
		return this;
	}

	public String getLanguage(){
		return this.language;
	}

	public SubscribeUser2 setHeadImgUrl(String headImgUrl){
		this.headImgUrl = headImgUrl;
		return this;
	}

	public String getHeadImgUrl(){
		return this.headImgUrl;
	}

	public SubscribeUser2 setSubscribeTime(java.util.Date subscribeTime){
		this.subscribeTime = subscribeTime;
		return this;
	}

	public java.util.Date getSubscribeTime(){
		return this.subscribeTime;
	}

	public SubscribeUser2 setUnionId(String unionId){
		this.unionId = unionId;
		return this;
	}

	public String getUnionId(){
		return this.unionId;
	}

	public SubscribeUser2 setRemark(String remark){
		this.remark = remark;
		return this;
	}

	public String getRemark(){
		return this.remark;
	}

	public SubscribeUser2 setGroupId(String groupId){
		this.groupId = groupId;
		return this;
	}

	public String getGroupId(){
		return this.groupId;
	}

	public SubscribeUser2 setTagIdList(String tagIdList){
		this.tagIdList = tagIdList;
		return this;
	}

	public String getTagIdList(){
		return this.tagIdList;
	}

	public SubscribeUser2 setPlatformName(String platformName){
		this.platformName = platformName;
		return this;
	}

	public String getPlatformName(){
		return this.platformName;
	}

	public SubscribeUser2 setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
		return this;
	}

	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	public SubscribeUser2 setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
		return this;
	}

	public java.util.Date getUpdateTime(){
		return this.updateTime;
	}

	public SubscribeUser2 setDeleteFlag(Integer deleteFlag){
		this.deleteFlag = deleteFlag;
		return this;
	}

	public Integer getDeleteFlag(){
		return this.deleteFlag;
	}

	@Override
	public String toString() {
		return "SubscribeUser [id=" + id + ", openId=" + openId + ", isSubscribe=" + isSubscribe + ", nickName="
				+ nickName + ", sex=" + sex + ", city=" + city + ", country=" + country + ", province=" + province
				+ ", language=" + language + ", headImgUrl=" + headImgUrl + ", subscribeTime=" + subscribeTime
				+ ", unionId=" + unionId + ", remark=" + remark + ", groupId=" + groupId + ", tagIdList=" + tagIdList
				+ ", platformName=" + platformName + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", deleteFlag=" + deleteFlag + "]";
	}
	

}
