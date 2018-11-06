package com.cyb.activity;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.cyb.Test;
import com.cyb.constant.Contanst;
import com.cyb.constant.UrlConstants;
import com.cyb.db.bean.Person;
import com.cyb.db.net.NetActivity;
import com.cyb.db.utils.DbUtil;
import com.cyb.gwjl.AnimationActivity;
import com.cyb.gwjl.NinghtMenuActivity;
import com.cyb.gwjl.R;
import com.cyb.gwjl.TabHostActivity;
import com.cyb.utils.UrlUtils;
//主类，进入登陆页面
public class MainActivity extends Activity {
    public Button login;
    public Button register;
    public EditText name ;
    public EditText password;
    private SharedPreferences sp ;
    public CheckBox isRemenber ;
    
    public ProgressDialog myDialog = null;
    DbUtil dbUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        login = (Button)findViewById(R.id.signin_button);
        register = (Button)findViewById(R.id.register_button);
        isRemenber = (CheckBox)findViewById(R.id.cb_auto);
        name  = (EditText)findViewById(R.id.username_edit);
        password  = (EditText)findViewById(R.id.password_edit);
        sp = this.getSharedPreferences("userInfo", Context.MODE_WORLD_READABLE); 
        boolean checked = sp.getBoolean("checked",false);
        String nameInfor = sp.getString("name","");
        String passInfor = sp.getString("password","");
        name.setText(nameInfor);
        password.setText(passInfor);
        login.setOnClickListener( new LoginListener());
        register.setOnClickListener(new RegisterListener());  
        isRemenber.setChecked(checked);
        dbUtil = new DbUtil(this,Contanst.DB_NAME,null,Contanst.DB_VERSION);
    }

    class LoginListener implements OnClickListener{
		@Override
		public void onClick(View v) {
			MainActivity.this.sp = MainActivity.this.getSharedPreferences("userInfo", Context.MODE_WORLD_READABLE);  
            Intent msg = new Intent();
            name  = (EditText)findViewById(R.id.username_edit);
            password  = (EditText)findViewById(R.id.password_edit);
            String nameInfor = name.getText().toString();
            String passInfor = password.getText().toString();      
            Person p = new Person();
            p.setName(nameInfor);
            p.setPassword(passInfor);
            if(nameInfor.equals("")||passInfor.equals("")){
            	Toast.makeText(MainActivity.this, "用户名和密码不能为空！", Toast.LENGTH_LONG).show();
            	return ;
            }
            //dbUtil.getPersonByNameAndPassword(p)
            String uri =Contanst.WEBPATH+UrlConstants.LOGIN;
            System.out.println("客户端请求："+uri);
            //http://localhost:8888/EStock/user/loginphone.zc?username=1&password=1&cmd=login
            boolean canLogin = false;
            Map<String,String> params = new HashMap<String,String>();
            try {
            	 params.put("username", name.getText().toString()); 
            	 params.put("password", password.getText().toString()); 
				 String data = UrlUtils.sendRequestByUri(uri,params);
				 System.out.println( data );
				 //将字符串转换成jsonObject对象
//				 JSONObject obj = new JSONObject(data);
				 JSONArray objArr = new JSONArray(data);
				 //获取对应的值
				 canLogin = objArr.getJSONObject(0).getBoolean("canLogin");
			} catch (Exception e1) {
				e1.printStackTrace();
				canLogin  = false;
			}
            if(canLogin){
            	Contanst.USERNAME = name.getText().toString();
            	Toast.makeText(MainActivity.this, "信息核对正确，正在登陆...", Toast.LENGTH_LONG).show();
            	myDialog = ProgressDialog.show(MainActivity.this, "提示", "正在登陆",true);
            	msg.putExtra("name", nameInfor);
            	msg.putExtra("password", passInfor);
            	msg.setClass(MainActivity.this, NinghtMenuActivity.class);
            	startActivity(msg);   
            	   	Editor editor = sp.edit();
            	if(MainActivity.this.isRemenber.isChecked()){
	            	editor.putString("name", nameInfor);
	            	editor.putString("password", passInfor);
	            	editor.putBoolean("checked", true);
	            	editor.commit();
            	}else{
            		editor.putString("name", "");
	            	editor.putString("password", "");
	            	editor.putBoolean("checked", false);
	            	editor.commit();
            	}
            	new Thread(){
    				public void run(){
    					try {
    						sleep(3000);
    					} catch (InterruptedException e) {
    						myDialog.dismiss();
    						e.printStackTrace();
    					}
    				}
    			}.start();
            	myDialog.dismiss();
            }else{
            	Toast.makeText(MainActivity.this, "信息核对失败，请重新输入", Toast.LENGTH_LONG).show();
            }
			System.out.println(name.getText()+"#"+password.getText());
			dbUtil.displayPerson();
		}		
    }

    public boolean checkRegister(String n,String p){
    	MainActivity.this.sp = MainActivity.this.getSharedPreferences("userInfo", Context.MODE_WORLD_READABLE);  
    	String nameInfor = sp.getString("name","");
        String passInfor = sp.getString("password","");
        dbUtil.displayPerson();
        if(nameInfor.equals(n)&&passInfor.equals(p)){
        	return true;
        }else{
        	return true;
        }
        
    }
    
    class RegisterListener implements OnClickListener{
		@Override
		public void onClick(View v) {
			name  = (EditText)findViewById(R.id.username_edit);
            password  = (EditText)findViewById(R.id.password_edit);
            String nameInfor = name.getText().toString();
            String passInfor = password.getText().toString();      
            if(nameInfor.equals("")||passInfor.equals("")){
            	Toast.makeText(MainActivity.this, "用户名和密码不能为空！", Toast.LENGTH_LONG).show();
            	return ;
            }
            Person p = new Person();
            p.setName(nameInfor);
            p.setPassword(passInfor);
            if(dbUtil.getPersonByNameAndPassword(p)){
            	Toast.makeText(MainActivity.this, "您已经注册，请直接登陆！", Toast.LENGTH_LONG).show();
            }else{
            	dbUtil.addPerson(p);
            	Toast.makeText(MainActivity.this, "已经注册成功！", Toast.LENGTH_LONG).show();
            }
		}   	
    }
    
    
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
    if (keyCode == KeyEvent.KEYCODE_BACK) { // 如果是手机上的返回键
    	MainActivity.this.finish();
    }
    	return super.onKeyDown(keyCode, event);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	menu.add(Menu.NONE, Menu.FIRST+1, 5, "首页").setIcon(R.drawable.ic_launcher);
    	menu.add(Menu.NONE, Menu.FIRST+2, 2, "退出应用");
    	menu.add(Menu.NONE, Menu.FIRST+3, 6, "网络检查");
    	menu.add(Menu.NONE, Menu.FIRST+4, 1, "时间控件");
    	menu.add(Menu.NONE, Menu.FIRST+5, 3, "选择列表");
    	menu.add(Menu.NONE, Menu.FIRST+6, 4, "动画展示").setIcon(R.drawable.ic_launcher);
    	menu.add(Menu.NONE, Menu.FIRST+7, 7, "信息列表");
    	menu.add(Menu.NONE, Menu.FIRST+8, 8, "九宫格");
    	menu.add(Menu.NONE, Menu.FIRST+9, 9, "tab任务栏");
    	menu.add(Menu.NONE, Menu.FIRST+10, 10, "菜单10");
        return true;
    }
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent = new Intent();
		switch(item.getItemId()){
		case Menu.FIRST+1:
			Toast.makeText(this, "选择菜单"+item.getItemId(), Toast.LENGTH_LONG).show();
		   break;
		case Menu.FIRST+2:
			Toast.makeText(this, "选择菜单"+item.getItemId(), Toast.LENGTH_LONG).show();
			new AlertDialog.Builder(MainActivity.this).setTitle("helloworld")
			.setMessage("是否退出helloworld程序！")
			.setPositiveButton("确定", 
    			new android.content.DialogInterface.OnClickListener(){
					@Override
					public void onClick(DialogInterface dialog, int which) {
						finish();			
					}}
    			)
    			.setNegativeButton("取消", new android.content.DialogInterface.OnClickListener(){
					@Override
					public void onClick(DialogInterface dialog, int which) {
												
					}})
    			
    			.show();
		   break;
		case Menu.FIRST+3:
			 intent = new Intent();
	    	 intent.setClass(this, NetActivity.class);
	    	 startActivity(intent);
			Toast.makeText(this, "选择菜单"+item.getItemId(), Toast.LENGTH_LONG).show();
		   break;
		case Menu.FIRST+4:
			 intent.setClass(this, DateOperActivity.class);
			 startActivity(intent);
			 Toast.makeText(this, "选择菜单"+item.getItemId(), Toast.LENGTH_LONG).show();
		   break;
		case Menu.FIRST+5:
			
		    new AlertDialog.Builder(MainActivity.this)
		    .setTitle("city").setItems(R.array.city_list, 
    		new android.content.DialogInterface.OnClickListener(){
				@Override
				public void onClick(DialogInterface dialog, int which) {
					String[] list = getResources().getStringArray(R.array.city_list);
					Toast.makeText(MainActivity.this, "选择内容:"+list[which], Toast.LENGTH_LONG).show();
				}
    		  }
    		).show();
		   break;
		case Menu.FIRST+6:
			 intent.setClass(this,AnimationActivity .class);
			 startActivity(intent);
		   break;
		case Menu.FIRST+7:
			 intent = new Intent();
	    	 intent.setClass(this, UserListActivity.class);
	    	 startActivity(intent);
		   break;
		case Menu.FIRST+8:
			 intent = new Intent();
		   	 intent.setClass(this, NinghtMenuActivity.class);
		   	 startActivity(intent);
		   break;
		case Menu.FIRST+9:
			 intent = new Intent();
	   	 	 intent.setClass(this, TabHostActivity.class);
	   	 	 startActivity(intent);
		   break;
		case Menu.FIRST+10:
			Toast.makeText(this, "选择菜单"+item.getItemId(), Toast.LENGTH_LONG).show();
		   break;
		}
		return super.onOptionsItemSelected(item);
	}  
	
}
