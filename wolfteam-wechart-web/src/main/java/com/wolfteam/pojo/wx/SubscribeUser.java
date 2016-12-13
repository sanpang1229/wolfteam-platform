package com.wolfteam.pojo.wx;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 *
 * @ClassName: SubscribeUser
 * @Description: 微信关注用户信息
 * @author 作者 E-mail <a href="mailto:158291434@qq.com">三胖</a>
 * @version 创建时间：2016年12月7日   下午3:17:03
 *
 * @version 1.0 
 *  
 */
@SuppressWarnings("serial")
public class SubscribeUser implements Serializable {

	/**主键**/
	private Integer id;

	/**微信加密后**/
	private String openid;

	/**是否关注**/
	private String subscribe;

	/**昵称**/
	private String nickname;

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
	private String headimgurl;

	/**用户关注时间**/
	private java.util.Date subscribeTime;

	/**只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段**/
	private String unionid;

	/**公众号运营者对粉丝的备注**/
	private String remark;

	/**用户所在的分组ID（兼容旧的用户分组接口）**/
	private String groupid;

	/**用户被打上的标签ID列表**/
	private String tagidList;

	/**公众号平台**/
	private String platformname;

	/**系统创建时间**/
	private java.util.Date createTime;

	/**系统修改时间**/
	private java.util.Date updateTime;

	/**删除标志**/
	private Integer deleteFlag;

		


	public SubscribeUser(Integer id, String openid, String subscribe, String nickname, Integer sex, String city,
			String country, String province, String language, String headimgurl, Date subscribeTime, String unionid,
			String remark, String groupid,  String tagidList,String platformname, Date createTime,
			Date updateTime, Integer deleteFlag ) {
		super();
		this.id = id;
		this.openid = openid;
		this.subscribe = subscribe;
		this.nickname = nickname;
		this.sex = sex;
		this.city = city;
		this.country = country;
		this.province = province;
		this.language = language;
		this.headimgurl = headimgurl;
		this.subscribeTime = subscribeTime;
		this.unionid = unionid;
		this.remark = remark;
		this.groupid = groupid;
		this.tagidList = tagidList;
		this.platformname = platformname;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.deleteFlag = deleteFlag;
	}

	public SubscribeUser() {
		// TODO Auto-generated constructor stub
	}

	public SubscribeUser setId(Integer id){
		this.id = id;
		return this;
	}

	public Integer getId(){
		return this.id;
	}

	public SubscribeUser setOpenid(String openid){
		this.openid = openid;
		return this;
	}

	public String getOpenid(){
		return this.openid;
	}

	public SubscribeUser setSubscribe(String subscribe){
		this.subscribe = subscribe;
		return this;
	}

	public String getSubscribe(){
		return this.subscribe;
	}

	public SubscribeUser setNickname(String nickname){
		this.nickname = nickname;
		return this;
	}

	public String getNickname(){
		return this.nickname;
	}

	public SubscribeUser setSex(Integer sex){
		this.sex = sex;
		return this;
	}

	public Integer getSex(){
		return this.sex;
	}

	public SubscribeUser setCity(String city){
		this.city = city;
		return this;
	}

	public String getCity(){
		return this.city;
	}

	public SubscribeUser setCountry(String country){
		this.country = country;
		return this;
	}

	public String getCountry(){
		return this.country;
	}

	public SubscribeUser setProvince(String province){
		this.province = province;
		return this;
	}

	public String getProvince(){
		return this.province;
	}

	public SubscribeUser setLanguage(String language){
		this.language = language;
		return this;
	}

	public String getLanguage(){
		return this.language;
	}

	public SubscribeUser setHeadimgurl(String headimgurl){
		this.headimgurl = headimgurl;
		return this;
	}

	public String getHeadimgurl(){
		return this.headimgurl;
	}

	public SubscribeUser setSubscribeTime(java.util.Date subscribeTime){
		this.subscribeTime = subscribeTime;
		return this;
	}

	public java.util.Date getSubscribeTime(){
		return this.subscribeTime;
	}

	public SubscribeUser setUnionid(String unionid){
		this.unionid = unionid;
		return this;
	}

	public String getUnionid(){
		return this.unionid;
	}

	public SubscribeUser setRemark(String remark){
		this.remark = remark;
		return this;
	}

	public String getRemark(){
		return this.remark;
	}

	public SubscribeUser setGroupid(String groupid){
		this.groupid = groupid;
		return this;
	}

	public String getGroupid(){
		return this.groupid;
	}



	


	public String getTagidList() {
		return tagidList;
	}

	public void setTagidList(String tagidList) {
		this.tagidList = tagidList;
	}

	public SubscribeUser setPlatformname(String platformname){
		this.platformname = platformname;
		return this;
	}

	public String getPlatformname(){
		return this.platformname;
	}

	public SubscribeUser setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
		return this;
	}

	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	public SubscribeUser setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
		return this;
	}

	public java.util.Date getUpdateTime(){
		return this.updateTime;
	}

	public SubscribeUser setDeleteFlag(Integer deleteFlag){
		this.deleteFlag = deleteFlag;
		return this;
	}

	public Integer getDeleteFlag(){
		return this.deleteFlag;
	}

	@Override
	public String toString() {
		return "SubscribeUser [id=" + id + ", openid=" + openid + ", subscribe=" + subscribe + ", nickname=" + nickname
				+ ", sex=" + sex + ", city=" + city + ", country=" + country + ", province=" + province + ", language="
				+ language + ", headimgurl=" + headimgurl + ", subscribeTime=" + subscribeTime + ", unionid=" + unionid
				+ ", remark=" + remark + ", groupid=" + groupid + ", tagid_list=" + tagidList + ", platformname="
				+ platformname + ", createTime=" + createTime + ", updateTime=" + updateTime + ", deleteFlag="
				+ deleteFlag + "]";
	}

	

}
