package com.taotao.store.order.util;

/**
 * 操作符
 * 
 * @author 传智播客 张志君
 * 
 * @date 2014年10月16日
 * 
 * @version V1.0
 */
public enum OperaterEnum {

	EQUAL("="), GREATER(">"), LESS("<"), GREATER_EQUAL(">="), LESS_EQUAL("<="), NOT_EQUAL("<>");

	private String operater;

	private OperaterEnum(String operater) {
		this.operater = operater;
	}

	@Override
	public String toString() {
		return this.operater;
	}
}
