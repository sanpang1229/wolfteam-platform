package org.wechat.abbs.callutils.dispatcher;

import org.wechat.abbs.callutils.dto.RequestDTO;
import org.wechat.abbs.callutils.dto.ResponseDTO;


/**
 *
 * @ClassName: InstructionObject
 * @Description: 微信命令泛型  封装了 HTTPREQUEST,HTTPRESPONSE 
 * @author 作者 E-mail <a href="mailto:158291434@qq.com">三胖</a>
 * @version 创建时间：2016年11月28日   下午5:01:57
 *
 * @version 1.0 
 *  
 */
public class InstructionObject {

    private RequestDTO request;
    private ResponseDTO response;
    
    
    public InstructionObject(RequestDTO request, ResponseDTO response) {
            this.request = request;
            this.response = response;
    }
    
    public InstructionObject(RequestDTO request) {
            this(request, new ResponseDTO(request));
    }

    public RequestDTO getRequest() {
            return request;
    }
    public void setRequest(RequestDTO request) {
            this.request = request;
    }
    public ResponseDTO getResponse() {
            return response;
    }
    public void setResponse(ResponseDTO response) {
            this.response = response;
    }
    


}
