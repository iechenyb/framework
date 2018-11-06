package com.cyb.gwjl;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.cyb.upload.UploadFile;

public class UploadFileActivity extends Activity {
	private Button btn ;
	private TextView infor;
	private Handler hanlder = new Handler(){

		@Override
		public void handleMessage(Message msg) {

			switch(msg.what){
			case 0:
				String rs = msg.obj.toString();
				if(rs.equals("true")){
					UploadFileActivity.this.infor.setText("upload success!");
				}else{
					UploadFileActivity.this.infor.setText("upload failed!");
				}
				break;
			}
		}
		
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_upload_file);
		btn = (Button)findViewById(R.id.btnUpload);
		infor = (TextView)findViewById(R.id.inforUpload);
		this.btn.setOnClickListener(new SendEvent());
	}
	class SendEvent implements OnClickListener{
		@SuppressLint("NewApi")
		@Override
		public void onClick(View v) {
			try {
				StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
				StrictMode.setThreadPolicy(policy);
				final Socket client = new Socket("192.168.16.211",8888);
				PrintStream out = new PrintStream(client.getOutputStream());
				final BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
							UploadFile myFile = SendEvent.this.getUploadFile();
							oos.writeObject(myFile);
							String str = buf.readLine();
							oos.close();
							Message msg  = UploadFileActivity.this.hanlder.obtainMessage(0,str);
							UploadFileActivity.this.hanlder.sendMessage(msg);
							buf.close();
							client.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}).start();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public UploadFile getUploadFile(){
			UploadFile file = new UploadFile();
			file.setTitle("title");
			file.setMimeType("image/jpeg");
			///mnt/sdcard
			File f = new File(Environment.getExternalStorageDirectory().toString()+File.separator+"logo.jpg");
			InputStream input = null;
			try {
				input = new FileInputStream(f);
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				byte[] data = new byte[1024];
				int len = 0; 
				while ((len=input.read(data))!=-1){
					bos.write(data,0,len);
				}
				file.setContentData(bos.toByteArray());
				file.setContentLength(f.length());
				file.setExt("jpg");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return file;
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.upload_file, menu);
		return true;
	}

}
