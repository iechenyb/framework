package com.cyb.gwjl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.cyb.server.SocketServer;

public class SocketActivity extends Activity {
   private Button btn ;
   private Button btn2 ;
   private Button btn3 ;
   private Button btnStart ;
   private Button btnStop ;
   private TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_socket);
		btn = (Button)findViewById(R.id.btnSocket);
		btn2 = (Button)findViewById(R.id.btnSocket2);
		btn3 = (Button)findViewById(R.id.btnSocket3);
		btnStart = (Button)findViewById(R.id.btnStart);
		btnStop = (Button)findViewById(R.id.btnStop);
		tv = (TextView)findViewById(R.id.inforSocket);
		this.btn.setOnClickListener(new SendEvent());
		this.btn2.setOnClickListener(new SendEvent2());
		this.btn3.setOnClickListener(new SendEvent3());
		this.btnStart.setOnClickListener(new ServerStart());
		this.btnStop.setOnClickListener(new ServerStop());
	}	
	
	class SendEvent implements OnClickListener{
		@SuppressLint("NewApi")
		@Override
		public void onClick(View v) {
			try {
				StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
				StrictMode.setThreadPolicy(policy);
				Socket client = new Socket("192.168.16.211",8888);
				client.setSoTimeout(2000);
				PrintStream out = new PrintStream(client.getOutputStream());
				BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
				out.println("the msg from client1:zhengzhou university colleage school");
				String str = buf.readLine();
				System.out.println("client1:"+str);
				SocketActivity.this.tv.setText(str);
				out.close();
				buf.close();
				client.close();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	class SendEvent2 implements OnClickListener{
		@SuppressLint("NewApi")
		@Override
		public void onClick(View v) {
			try {
				StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
				StrictMode.setThreadPolicy(policy);
				Socket client = new Socket("192.168.16.211",8888);
				client.setSoTimeout(2000);
				PrintStream out = new PrintStream(client.getOutputStream());
				BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
				out.println("the msg from client2:zhengzhou university colleage school");
				String str = buf.readLine();
				System.out.println("client2:"+str);
				SocketActivity.this.tv.setText(str);
				out.close();
				buf.close();
				client.close();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	class SendEvent3 implements OnClickListener{
		@SuppressLint("NewApi")
		@Override
		public void onClick(View v) {
			try {
				StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
				StrictMode.setThreadPolicy(policy);
				Socket client = new Socket("192.168.16.211",8888);
				client.setSoTimeout(2000);
				PrintStream out = new PrintStream(client.getOutputStream());
				BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
				out.println("the msg from client3:zhengzhou university colleage school ");
				String str = buf.readLine();
				System.out.println("client3:"+str);
				SocketActivity.this.tv.setText(str);
				out.close();
				buf.close();
				client.close();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	class ServerStart implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			SocketServer.start();
		}
		
	}
	class ServerStop implements OnClickListener{

		@Override
		public void onClick(View v) {
			SocketServer.stop();			
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.socket, menu);
		return true;
	}

}
