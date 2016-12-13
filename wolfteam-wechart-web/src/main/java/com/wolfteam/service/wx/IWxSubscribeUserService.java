package com.wolfteam.service.wx;

public interface IWxSubscribeUserService {

	void bindSubScribeUserInofByFromUserName(String fromUserName, String string) throws Exception;

	void ProcessWxSubScribeBussniess(String fromUserName, String platformUserName) throws Exception;

	void ProcessUnSubScribeBussniess(String fromUserName);

}
