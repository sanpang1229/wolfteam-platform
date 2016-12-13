package org.wechat.device.response;


/**
 * 当申请个数大于500时结果类型
 * @author Andy
 * 
 */
public class Apply implements java.io.Serializable {
	private int apply_id; // 申请的批次ID，可用在“查询设备列表”接口按批次查询本次申请成功的设备ID。
	private int audit_status; // 审核状态。0：审核未通过、1：审核中、2：审核已通过；审核会在三个工作日内完成
	private String audit_comment;// 审核备注，包括审核不通过的原因

	public int getApply_id() {
		return apply_id;
	}

	public void setApply_id(int applyId) {
		apply_id = applyId;
	}

	public int getAudit_status() {
		return audit_status;
	}

	public void setAudit_status(int auditStatus) {
		audit_status = auditStatus;
	}

	public String getAudit_comment() {
		return audit_comment;
	}

	public void setAudit_comment(String auditComment) {
		audit_comment = auditComment;
	}
}
