package com.cyb.gwjl;

import java.util.ArrayList;
import java.util.HashMap;

import com.cyb.constant.Contanst;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class MenusActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);
		GridView gridview = (GridView) findViewById(R.id.menugridview);  
	      //生成动态数组，并且转入数据  
	     ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();  
	     for(int i=1;i<=Contanst.menus.keySet().size();i++)  
	      {  
	        HashMap<String, Object> map = new HashMap<String, Object>();  
	        map.put("ID", i);
	        map.put("PIC", R.drawable.cat1);//添加图像资源的ID  
	        map.put("NAME", Contanst.menus.get(i));//按序号做ItemText  
	        lstImageItem.add(map);  
	      }  
	      //生成适配器的ImageItem <====> 动态数组的元素，两者一一对应  
	      SimpleAdapter saImageItems = new SimpleAdapter(this, //没什么解释  
	                                                lstImageItem,//数据来源   
	                                                R.layout.activity_menu_item,//night_item的XML实现  
	                                                //动态数组与ImageItem对应的子项          
	                                                new String[] {"ID","PIC","NAME"},   
	                                                //ImageItem的XML文件里面的一个ImageView,两个TextView ID  
	                                                new int[] {R.id.menuID,R.id.menuImage,R.id.menuText});  
	      //添加并且显示  
	      gridview.setAdapter(saImageItems);  
	      //添加消息处理  
	      gridview.setOnItemClickListener(new ItemClickListener());  
	     }
      //当AdapterView被单击(触摸屏或者键盘)，则返回的Item单击事件  
	  class  ItemClickListener implements OnItemClickListener  
	  {  
		public void onItemClick(AdapterView<?> arg0,//The AdapterView where the click happened   
		                                  View arg1,//The view within the AdapterView that was clicked  
		                                  int arg2,//The position of the view in the adapter  
		                                  long arg3//The row id of the item that was clicked  
		                                  ) {  
		    //在本例中arg2=arg3  
		    HashMap<String, Object> item=(HashMap<String, Object>) arg0.getItemAtPosition(arg2);  
		    //显示所选Item的ItemText  
		    setTitle((String)item.get("NAME"));  
		   int id = (Integer)item.get("ID");
		   System.out.println("选择菜单："+Contanst.menus.get(id));
		   if(id==2){
		    	Intent intent = new Intent();
		    	intent.putExtra("type", "myConcern");
		    	intent.setClass(MenusActivity.this, MyConcernActivity.class);
		        startActivity(intent);
		    }else if(id==3) {
		    	Intent intent = new Intent();
		    	intent.putExtra("type", "sz");
		    	intent.setClass(MenusActivity.this, MyConcernActivity.class);
		        startActivity(intent);
		    }else if(id==4) {
		    	Intent intent = new Intent();
		    	intent.putExtra("type", "xd");
		    	intent.setClass(MenusActivity.this, MyConcernActivity.class);
		        startActivity(intent);
		    }else if(id==5) {
		    	Intent intent = new Intent();
		    	intent.putExtra("type", "1");
		    	intent.setClass(MenusActivity.this, MyConcernActivity.class);
		        startActivity(intent);
		    }else if(id==6) {
		    	Intent intent = new Intent();
		    	intent.putExtra("type", "2");
		    	intent.setClass(MenusActivity.this, MyConcernActivity.class);
		        startActivity(intent);
		    }else if(id==7) {
		    	Intent intent = new Intent();
		    	intent.putExtra("type", "tp");
		    	intent.setClass(MenusActivity.this, MyConcernActivity.class);
		        startActivity(intent);
		    }else if(id==8) {
		    	Intent intent = new Intent();
		    	intent.putExtra("type", "A");
		    	intent.setClass(MenusActivity.this, IndustryActivity.class);
		        startActivity(intent);
		    }else if(id==1) {
		    	Intent intent = new Intent();
		    	intent.putExtra("condition", "");
		    	intent.setClass(MenusActivity.this, SearchActivity.class);
		        startActivity(intent);
		    }else if(id==9) {
		    	Intent intent = new Intent();
		    	intent.putExtra("type", "zhzs");
		    	intent.setClass(MenusActivity.this, MyConcernActivity.class);
		        startActivity(intent);
		    }else if(id==10) {
		    	Intent intent = new Intent();
		    	intent.setClass(MenusActivity.this, QutoesActivity.class);
		        startActivity(intent);
		    }else if(id==13) {
		    	Intent intent = new Intent();
		    	intent.setClass(MenusActivity.this, TodayZdActivity.class);
		        startActivity(intent);
		    } else if(id==14) {
		    	Intent intent = new Intent();
		    	intent.putExtra("id", "14");
		    	intent.setClass(MenusActivity.this, LineTestActivity.class);
		        startActivity(intent);
		    }else if(id==15) {
		    	Intent intent = new Intent();
		    	intent.putExtra("id", "15");
		    	intent.setClass(MenusActivity.this, LineTestActivity.class);
		        startActivity(intent);
		    }else if(id==16) {
		    	Intent intent = new Intent();
		    	intent.putExtra("id", "16");
		    	intent.setClass(MenusActivity.this, LineTestActivity.class);
		        startActivity(intent);
		    }
		    else {
		    	System.out.println("菜单有误！");
		    }
		} 
	 }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menus, menu);
        return true;
    }
    
}
