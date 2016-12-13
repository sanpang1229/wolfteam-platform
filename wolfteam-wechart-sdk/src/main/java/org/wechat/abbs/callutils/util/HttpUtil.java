package org.wechat.abbs.callutils.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONObject;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.wechat.abbs.callutils.xml2obj.MyX509TrustManager;
import org.wechat.abbs.callutils.xml2obj.StringUtil;


public class HttpUtil {
	/**
	 * http请求
	 * 
	 * @param url
	 *            请求地址
	 * @param charset
	 *            字符编码
	 * @param params 传递参数
	 * @return 網頁源代碼
	 */
	public static Object post(String url,String charset,Map params) {
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(url);
		//设置参数
		if (params != null) {
			Iterator it = params.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry entry = (Map.Entry) it.next();
				String _n =  entry.getKey().toString();
				String _v = entry.getValue().toString();
				method.addParameter(_n, _v);
			}
		}
		method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, charset);
		method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));
		try {
			int statusCode = client.executeMethod(method);
			method.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, charset);
			if (statusCode != HttpStatus.SC_OK && statusCode != HttpStatus.SC_MOVED_TEMPORARILY) {
			}
			byte[] responseBody = method.getResponseBody();
			return new String(responseBody, charset);
		} catch (HttpException e) {
		} catch (IOException e) {
		} finally {
			method.releaseConnection();
		}
		return null;
	}
	
	public static String get(String url) { 
		String sCurrentLine = ""; 
		String sTotalString = "";
		try { 
		URL l_url = new URL(url); 
		HttpURLConnection l_connection = (HttpURLConnection) l_url.openConnection(); 
		/*l_connection.setRequestProperty("x-up-calling-line-id", "18958003200");
		l_connection.setRequestProperty("HTTP_X_UP_BEAR_TYPE", "gprs");
		l_connection.setRequestProperty("Accept", "vnd.wap.wml");*/
		l_connection.connect(); 
		InputStream l_urlStream; 
		l_urlStream = l_connection.getInputStream(); 
		BufferedReader l_reader = new BufferedReader(new InputStreamReader(l_urlStream,"utf-8")); 
		//sCurrentLine = l_reader.readLine(); 
		while ((sCurrentLine = l_reader.readLine()) != null) 
		{ 
			sTotalString += sCurrentLine+"\r\n"; 
		}
		} catch (IOException e) { 
			e.printStackTrace(); 
		} 
		return sTotalString; 
		}
	
	
	//在在在
	public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputContent)
	  {
	    System.setProperty("https.protocols", "TLSv1");
	    JSONObject jsonObject = null;
	    StringBuffer buffer = new StringBuffer();
	    try
	    {
	      TrustManager[] tm = { new MyX509TrustManager() };
	      SSLContext sslContext = SSLContext.getInstance("SSL");
	      sslContext.init(null, tm, new SecureRandom());
	      SSLSocketFactory ssf = sslContext.getSocketFactory();
	      URL url = new URL(requestUrl);
	      HttpsURLConnection httpUrlConn = (HttpsURLConnection)url.openConnection();
	      httpUrlConn.setSSLSocketFactory(ssf);
	      httpUrlConn.setDoOutput(true);
	      httpUrlConn.setDoInput(true);
	      httpUrlConn.setUseCaches(false);
	      httpUrlConn.setRequestMethod(requestMethod);
	      httpUrlConn.connect();
	      if (StringUtil.isNotEmpty(outputContent)) {
	        OutputStream outputStream = httpUrlConn.getOutputStream();
	        outputStream.write(outputContent.getBytes("UTF-8"));
	        outputStream.close();
	      }
	      InputStream inputStream = httpUrlConn.getInputStream();
	      InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
	      BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
	      String str = null;
	      while ((str = bufferedReader.readLine()) != null) {
	        buffer.append(str);
	      }
	      bufferedReader.close();
	      inputStreamReader.close();
	      inputStream.close();
	      inputStream = null;
	      httpUrlConn.disconnect();
	      jsonObject = JSONObject.fromObject(buffer.toString());
	    } catch (ConnectException ce) {
	      ce.printStackTrace();
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return jsonObject;
	  }
//	private static String APPSECRET="5ea108bad776c0ff024d14fb3fed3505";
//	private static String APPID="wxabc0f1f7ff05cfe8";
//	private static final String WEIXIN_ACCESSTOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+APPID+"&secret="+APPSECRET;
//	public static void main(String[] args) {
//		String url = "https://qyapi.weixin.qq.com/cgi-bin/service/get_agent?suite_access_token=Ad9MaTNvXWTaWjL5AEM5dkEntWm9mhtq8vpGnn02oeRLR_rV0wLbl4x7ENEkZTiS";
//		StringBuffer data  = new StringBuffer();
//		data.append("{");
//		data.append("\"suite_id\":\"").append("tj369a681625246bff").append("\",");
//		data.append("\"auth_corpid\":\"").append("wx2ae3559c083822f4").append("\",");
//		data.append("\"permanent_code\":\"").append("VVXxwRwD_5DuWAPTWCn9BhaR18ZpR613yA2Yk3kWenJe1a61ex4hoIq8mKbAyvej").append("\",");
//		data.append("\"agentid\":\"").append("103").append("\"}");
//		
//	 
//	
//		System.out.println(httpsRequest(url, "GET", data.toString()).toString());
//	}
}
