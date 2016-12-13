package org.wechat.pay.handler;

import java.io.IOException;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;

import org.wechat.common.utils.XStreamFactory;
import org.wechat.pay.request.UnifiedOrderRequest;
import org.wechat.pay.response.UnifiedOrderResponse;
import org.wechat.pay.utils.XMLParser;
import org.xml.sax.SAXException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XmlFriendlyNameCoder;

/**
 * 支付接口中的转换处理类
 * 
 * @author Andy
 * 
 */
public class PayHandler {

	/**
	 * 微信统一支付处理接口
	 * 
	 * @param request
	 * @return
	 */
	public static String unifiedorder(UnifiedOrderRequest request) {
		String result = "";
		if (request != null) {
			XStream xStreamForRequestPostData = new XStream(new DomDriver(
					"UTF-8", new XmlFriendlyNameCoder("-_", "_")));
			xStreamForRequestPostData.alias("xml", UnifiedOrderRequest.class);
			result = xStreamForRequestPostData.toXML(request);
		}
		return result;
	}

	/**
	 * xml格式的字符串
	 * 
	 * @param xmlResult
	 * @return
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	public static UnifiedOrderResponse unifiedOrderResponse(
			String xmlResult) {
		/*XStream xstream = new XStream(new DomDriver("UTF-8",
				new XmlFriendlyNameCoder("-_", "_")));*/
		XStream xstream = XStreamFactory.init(true);
		xstream.alias("xml", UnifiedOrderResponse.class);
		UnifiedOrderResponse orderResult = null;
		try {
			orderResult = (UnifiedOrderResponse) xstream.fromXML(xmlResult);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return orderResult;
	}
}