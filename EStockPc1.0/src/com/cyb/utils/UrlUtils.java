package com.cyb.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.security.SecureRandom;
import java.security.cert.CertificateException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class UrlUtils {
	private static final String METHOD_POST = "POST";  
    private static final String DEFAULT_CHARSET = "utf-8";  
    public static  String downJsonStrFromHttpsUrl(String url){
		HttpsURLConnection conn = null;  
	    OutputStream out = null;  
	    String content = "";
	    try {  
	        try{  
	            SSLContext ctx = SSLContext.getInstance("TLS");  
	            ctx.init(new KeyManager[0], new TrustManager[] {new DefaultTrustManager()}, new SecureRandom());  
	            SSLContext.setDefault(ctx);  
	            conn = getConnection(new URL(url), METHOD_POST, "");   
	            conn.setHostnameVerifier(new HostnameVerifier() {  
	                public boolean verify(String hostname, SSLSession session) {  
	                    return true;  
	                }  
	            });  
	            conn.setConnectTimeout(1000*10);  
	            conn.setReadTimeout(1000*10);  
	        }catch(Exception e){  
	            System.out.println("GET_CONNECTOIN_ERROR, URL = "+ e);  
	        }  
	        try{  
	        	BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        	content = reader.readLine();
	        	/*JSONArray data = JSONArray.fromObject("["+content+"]");
	        	Boolean canLogin = (Boolean) data.getJSONObject(0).get("ifLogin");
	        	System.out.println(content+":"+canLogin);*/
	        }catch(IOException e){  
	            System.out.println("REQUEST_RESPONSE_ERROR");
	        }  
	    }finally {  
	        if (out != null) {  
	            try {
					out.close();
				} catch (IOException e) {
					System.out.println("CLOSE CONNECTION FAILED!");
				}  
	        }  
	        if (conn != null) {  
	            conn.disconnect();  
	        }  
	    }  
	    return content;
	}
	public static  HttpsURLConnection getConnection(URL url,String method,String ctype){  
	    HttpsURLConnection conn = null;
		try {
			conn = (HttpsURLConnection) url.openConnection();  
			conn.setRequestMethod(method);  
			conn.setDoInput(true);  
			conn.setDoOutput(true);  
			conn.setRequestProperty("Accept", "text/xml,text/javascript,text/html");  
			conn.setRequestProperty("User-Agent", "stargate");  
			conn.setRequestProperty("Content-Type", ctype);
		} catch (ProtocolException e) {
			System.out.println("ProtocolException "+e.toString());
		} catch (IOException e) {
			System.out.println("IOException "+e.toString());
		}  
	    return conn;  
	}  
	   /**
     * Method: saveHtml 
     * Description: save String to file
     * @param filepath
     * file path which need to be saved
     * @param str
     * string saved
     */
    public static String downJsonStrFromHttpUrl(String url_){
        String content="";
        long t1 = System.currentTimeMillis();
        try {
            /*@SuppressWarnings("resource")
            FileWriter fw = new FileWriter(filepath);
            fw.write(str);
            fw.flush();*/
        	URL url = null;
            url = new URL(url_);
            int sec_cont = 1000;
            URLConnection url_con = url.openConnection();
            url_con.setDoOutput(true);
            url_con.setConnectTimeout(Integer.valueOf(ConfigUtils.get("connectimeout"))*sec_cont);
            url_con.setReadTimeout(Integer.valueOf(ConfigUtils.get("readtimeout")) * sec_cont);
            url_con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");
            InputStream htm_in = url_con.getInputStream();
            content = InputStream2String(htm_in,DEFAULT_CHARSET);
            /*OutputStreamWriter outs = new OutputStreamWriter(new FileOutputStream(filepath, true), "utf-8");
            outs.write(str);
            System.out.print(str);
            outs.close();*/
            long t2 = System.currentTimeMillis();
            System.out.println("use time is "+(t2-t1)/1000+"s");
        } catch (IOException e) {
			e.printStackTrace();
			long t2 = System.currentTimeMillis();
	        System.out.println("use time is "+(t2-t1)/1000+"s");
            System.out.println("Error at get data from "+url_);
           return "[]";
        }
        return content;
    }
    /**
     * Method: InputStream2String 
     * Description: make InputStream to String
     * @param in_st
     * inputstream which need to be converted
     * @param charset
     * encoder of value
     * @throws IOException
     * if an error occurred 
     */
    public static String InputStream2String(InputStream in_st,String charset) throws IOException{
        BufferedReader buff = new BufferedReader(new InputStreamReader(in_st, charset));
        StringBuffer res = new StringBuffer();
        String line = "";
        while((line = buff.readLine()) != null){
            res.append(line+"\n");
        }
        return res.toString();
    }
    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        
        int sec_cont = 1000;
        try {
            URLConnection url_con = url.openConnection();
            url_con.setDoOutput(true);
            url_con.setReadTimeout(10 * sec_cont);
            url_con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");
            InputStream htm_in = url_con.getInputStream();
            String htm_str = InputStream2String(htm_in,"");
            //saveHtml("",htm_str);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


class DefaultTrustManager implements X509TrustManager {  
	public void checkClientTrusted(java.security.cert.X509Certificate[] chain,
			String authType) throws CertificateException {
	}
	public void checkServerTrusted(java.security.cert.X509Certificate[] chain,
			String authType) throws CertificateException {
	}
	public java.security.cert.X509Certificate[] getAcceptedIssuers() {
		return null;
	}
}
