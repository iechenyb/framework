package com.cyb.gwjl;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.cyb.constant.Contanst;

public class NinghtMenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ninght_menu);
		GridView gridview = (GridView) findViewById(R.id.gridview);  
	      //生成动态数组，并且转入数据  
	      ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();  
	      for(int i=1;i<=11;i++)  
	      {  
	        HashMap<String, Object> map = new HashMap<String, Object>();  
	        map.put("ItemId", i);
	        map.put("ItemImage", R.drawable.cat1);//添加图像资源的ID  
	        map.put("ItemText", Contanst.map.get(i));//按序号做ItemText  
	        lstImageItem.add(map);  
	      }  
	      //生成适配器的ImageItem <====> 动态数组的元素，两者一一对应  
	      SimpleAdapter saImageItems = new SimpleAdapter(this, //没什么解释  
	                                                lstImageItem,//数据来源   
	                                                R.layout.activity_night_item,//night_item的XML实现  
	                                                  
	                                                //动态数组与ImageItem对应的子项          
	                                                new String[] {"ItemId","ItemImage","ItemText"},   
	                                                  
	                                                //ImageItem的XML文件里面的一个ImageView,两个TextView ID  
	                                                new int[] {R.id.menuId,R.id.ItemImage,R.id.ItemText});  
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
		    setTitle((String)item.get("ItemText"));  
//		    String menu = (String)item.get("ItemText");
		    Integer id = (Integer)item.get("ItemId");
		   if(id==1){
		    	Intent intent = new Intent();
		    	intent.setClass(NinghtMenuActivity.this, MenusActivity.class);
		        startActivity(intent);
		    }else if(id==2){
		    	Intent intent = new Intent();
		    	intent.setClass(NinghtMenuActivity.this, SocketActivity.class);
		        startActivity(intent);
		    }else  if(id==3){
		    	Intent intent = new Intent();
		    	intent.putExtra("code", "sh600868");
		    	intent.setClass(NinghtMenuActivity.this, ExploreActivity.class);
		        startActivity(intent);
		    }else if(id==4){
		    	Intent intent = new Intent();
		    	intent.setClass(NinghtMenuActivity.this, DbNetActivity.class);
		        startActivity(intent);
		    }else  if(id==5){
		    	Intent intent = new Intent();
		    	intent.setClass(NinghtMenuActivity.this, UploadFileActivity.class);
		        startActivity(intent);
		    }else if(id==6){
		    	Intent intent = new Intent();
		    	intent.setClass(NinghtMenuActivity.this, DbNetActivity.class);
		        startActivity(intent);
		    }else  if(id==7){
		    	Intent intent = new Intent();
		    	intent.setClass(NinghtMenuActivity.this, UploadFileActivity.class);
		        startActivity(intent);
		    }else if(id==8){
		    	Intent intent = new Intent();
		    	intent.setClass(NinghtMenuActivity.this, DbNetActivity.class);
		        startActivity(intent);
		    }else  if(id==9){
		    	Intent intent = new Intent();
		    	intent.setClass(NinghtMenuActivity.this, UploadFileActivity.class);
		        startActivity(intent);
		    }else if(id==10){
		    	Intent intent = new Intent();
		    	intent.setClass(NinghtMenuActivity.this, DbNetActivity.class);
		        startActivity(intent);
		    }else if(id==11){
		    	Intent intent = new Intent();
		    	intent.setClass(NinghtMenuActivity.this, FixHeaderActivity.class);
		        startActivity(intent);
		    }else {
		    	System.out.println("菜单有误！");
		    }
		}  
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ninght_menu, menu);
		return true;
	}
	   public void setListViewHeightBasedOnChildren(ListView listView) {   
	        // 获取ListView对应的Adapter   
	        ListAdapter listAdapter = listView.getAdapter();   
	        if (listAdapter == null) {   
	            return;   
	        }   
	   
	        int totalHeight = 0;   
	        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {   
	            // listAdapter.getCount()返回数据项的数目   
	            View listItem = listAdapter.getView(i, null, listView);   
	            // 计算子项View 的宽高   
	            listItem.measure(0, 0);    
	            // 统计所有子项的总高度   
	            totalHeight += listItem.getMeasuredHeight();    
	        }   
	   
	        ViewGroup.LayoutParams params = listView.getLayoutParams();   
	        params.height = totalHeight+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));   
	        // listView.getDividerHeight()获取子项间分隔符占用的高度   
	        // params.height最后得到整个ListView完整显示需要的高度   
	        listView.setLayoutParams(params);   
	    }  
}
