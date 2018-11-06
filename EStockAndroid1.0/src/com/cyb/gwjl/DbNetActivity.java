package com.cyb.gwjl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.cyb.constant.Contanst;
import com.cyb.constant.UrlConstants;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

@TargetApi(Build.VERSION_CODES.GINGERBREAD) public class DbNetActivity extends Activity {
	private  TextView netStr ;
	private  TextView netBoolean ;
	private ImageView image ;
	private final Handler  handler = new Handler();
	private final Runnable getMsgFromNet =  new Runnable() {
		public void run() {
			netStr = (TextView)findViewById(R.id.netStr);
			netBoolean = (TextView)findViewById(R.id.netBoolean);
			image = (ImageView)findViewById(R.id.netImg);
			getJsonMsgFromNetworkImpl();
			getBoolMsgFromNetworkImpl();
			try {
				getImgMsgFromNetworkImpl();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};
	@TargetApi(Build.VERSION_CODES.GINGERBREAD) @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_db_net);
		handler.post(getMsgFromNet);
	}

	@SuppressLint("NewApi") 
	public void getJsonMsgFromNetworkImpl(){
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		StringBuffer msg = new StringBuffer("");
		try {
			String str = 	Contanst.WEBPATH+UrlConstants.TestRetJsondataUrl;
			URL url = new URL(str);
			System.out.println(str);
					try {
					HttpURLConnection conn = (HttpURLConnection)url.openConnection();
					byte[] data = new byte[512];
					int len = conn.getInputStream().read(data);
					if(len>0){
						String temp = new String(data,0,len).trim();
						msg.append(temp);
						netStr.setText("json msg from network is :"+msg.toString()+"\n ");
					}
					conn.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
	}
	
	//get bool value from net test
	@SuppressLint("NewApi") 
	public void getBoolMsgFromNetworkImpl(){
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		try {
				//URL url = new URL("http","192.168.16.211",8080,"/index.jsp");//append params at the last of url
			String str = 	Contanst.WEBPATH+UrlConstants.TestRetBooleanUrl;
			URL url = new URL(str);
			System.out.println(str);
				try {
					HttpURLConnection conn = (HttpURLConnection)url.openConnection();
					byte[] data = new byte[512];
					int len = conn.getInputStream().read(data);
					if(len>0){
						String temp = new String(data,0,len).trim();
						boolean flag = Boolean.parseBoolean(temp);
						netBoolean.setText("boolean msg from network is: "+flag+"\n img msg from network is :");
					}
					conn.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
	}
	
	
	@SuppressLint("NewApi") 
	public void getImgMsgFromNetworkImpl() throws Exception{
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		try {
				String path =Contanst.WEBPATH+UrlConstants.TestRetPicUrl;
				System.out.println(path);
				//String path = "http://192.168.16.211:8080/pic.jpg";
				try {
					byte[] data = this.getUrlData(path);
					Bitmap bm = BitmapFactory.decodeByteArray(data, 0, data.length);
					this.image.setImageBitmap(bm);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
	}
	
	
	public byte[] getUrlData(String path) throws Exception{
		ByteArrayOutputStream bos = null;
		try{
			URL url = new URL(path);
			bos = new ByteArrayOutputStream();
			byte[] data = new byte[1024];
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			InputStream in = con.getInputStream();
			int len = 0;
			while((len = in.read(data))!=-1){
				bos.write(data,0,len);
			}
			return bos.toByteArray();
		}catch(Exception e){
			throw e;
		}
	}
	
	public void httpGetMethodImpl(){
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		String uri =Contanst.WEBPATH+UrlConstants.TestRetJsondataUrl;
//		String uri = "http://192.168.16.211:8080/servlet/getStaticData";//uri
		System.out.println(uri);
		HttpGet httpRequest = new HttpGet(uri);
		netStr = (TextView)findViewById(R.id.netStr);
		try {
			HttpResponse rep = new DefaultHttpClient().execute(httpRequest);
			if(rep.getStatusLine().getStatusCode()==200){
				String str = EntityUtils.toString(rep.getEntity());
				netStr.setText(str);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void httpPostMethodImpl() throws UnsupportedEncodingException{
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		String uri =Contanst.WEBPATH+UrlConstants.TestRetJsondataUrl;
		System.out.println(uri);
//		String uri = "http://192.168.16.211:8080/servlet/getStaticData";
		HttpPost httpRequest = new HttpPost(uri);
		List<NameValuePair> lst = new ArrayList<NameValuePair>();
		lst.add(new BasicNameValuePair("name", "xxxx"));
		lst.add(new BasicNameValuePair("password", "1111"));
		httpRequest.setEntity(new UrlEncodedFormEntity(lst,HTTP.UTF_8));
		netStr = (TextView)findViewById(R.id.netStr);
		try {
			HttpResponse rep = new DefaultHttpClient().execute(httpRequest);
			if(rep.getStatusLine().getStatusCode()!=404){
				String str = EntityUtils.toString(rep.getEntity());
				netStr.setText(str);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.db_net, menu);
		return true;
	}

}
