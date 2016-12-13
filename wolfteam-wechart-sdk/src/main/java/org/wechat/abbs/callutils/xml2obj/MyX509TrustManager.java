package org.wechat.abbs.callutils.xml2obj;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;
        


public class MyX509TrustManager implements X509TrustManager

{
public void checkClientTrusted(X509Certificate[] chain, String authType)
  throws CertificateException
{
}

public void checkServerTrusted(X509Certificate[] chain, String authType)
  throws CertificateException
{
}

public X509Certificate[] getAcceptedIssuers()
{
  return null;
}

//private static String APPID="wxabc0f1f7ff05cfe8";
//	private static String APPSECRET="5ea108bad776c0ff024d14fb3fed3505";
//	private static final String WEIXIN_ACCESSTOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+APPID+"&secret="+APPSECRET;
//   public static void main(String[] args) throws Exception {
//	   System.setProperty("https.protocols", "TLSv1");
//   	// 创建SSLContext对象，并使用我们指定的信任管理器初始化
//       TrustManager[] tm = { new MyX509TrustManager() };
//       SSLContext sslContext = SSLContext.getInstance("SSL");
//       sslContext.init(null, tm, new java.security.SecureRandom());
//       // 从上述SSLContext对象中得到SSLSocketFactory对象
//       SSLSocketFactory ssf = sslContext.getSocketFactory();
//       // 创建URL对象
//       URL myURL = new URL(WEIXIN_ACCESSTOKEN_URL);
//       // 创建HttpsURLConnection对象，并设置其SSLSocketFactory对象
//       HttpsURLConnection httpsConn = (HttpsURLConnection) myURL.openConnection();
//       httpsConn.setSSLSocketFactory(ssf);
//       // 取得该连接的输入流，以读取响应内容
//       InputStreamReader insr = new InputStreamReader(httpsConn.getInputStream());
//       // 读取服务器的响应内容并显示
//       int respInt = insr.read();
//       String s = "";
//       while (respInt != -1) {
//       	 s += (char) respInt;
//           respInt = insr.read();
//       }
//       JSONObject jsonobject = JSONObject.fromObject(s);
//       System.out.println(jsonobject.toString());
//	}
}
