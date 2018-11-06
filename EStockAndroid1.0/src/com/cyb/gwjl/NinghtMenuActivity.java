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
	      //���ɶ�̬���飬����ת������  
	      ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();  
	      for(int i=1;i<=11;i++)  
	      {  
	        HashMap<String, Object> map = new HashMap<String, Object>();  
	        map.put("ItemId", i);
	        map.put("ItemImage", R.drawable.cat1);//���ͼ����Դ��ID  
	        map.put("ItemText", Contanst.map.get(i));//�������ItemText  
	        lstImageItem.add(map);  
	      }  
	      //������������ImageItem <====> ��̬�����Ԫ�أ�����һһ��Ӧ  
	      SimpleAdapter saImageItems = new SimpleAdapter(this, //ûʲô����  
	                                                lstImageItem,//������Դ   
	                                                R.layout.activity_night_item,//night_item��XMLʵ��  
	                                                  
	                                                //��̬������ImageItem��Ӧ������          
	                                                new String[] {"ItemId","ItemImage","ItemText"},   
	                                                  
	                                                //ImageItem��XML�ļ������һ��ImageView,����TextView ID  
	                                                new int[] {R.id.menuId,R.id.ItemImage,R.id.ItemText});  
	      //��Ӳ�����ʾ  
	      gridview.setAdapter(saImageItems);  
	      //�����Ϣ����  
	      gridview.setOnItemClickListener(new ItemClickListener());  
	  }  
	    
	  //��AdapterView������(���������߼���)���򷵻ص�Item�����¼�  
	  class  ItemClickListener implements OnItemClickListener  
	  {  
		public void onItemClick(AdapterView<?> arg0,//The AdapterView where the click happened   
		                                  View arg1,//The view within the AdapterView that was clicked  
		                                  int arg2,//The position of the view in the adapter  
		                                  long arg3//The row id of the item that was clicked  
		                                  ) {  
		    //�ڱ�����arg2=arg3  
		    HashMap<String, Object> item=(HashMap<String, Object>) arg0.getItemAtPosition(arg2);  
		    //��ʾ��ѡItem��ItemText  
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
		    	System.out.println("�˵�����");
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
	        // ��ȡListView��Ӧ��Adapter   
	        ListAdapter listAdapter = listView.getAdapter();   
	        if (listAdapter == null) {   
	            return;   
	        }   
	   
	        int totalHeight = 0;   
	        for (int i = 0, len = listAdapter.getCount(); i < len; i++) {   
	            // listAdapter.getCount()�������������Ŀ   
	            View listItem = listAdapter.getView(i, null, listView);   
	            // ��������View �Ŀ��   
	            listItem.measure(0, 0);    
	            // ͳ������������ܸ߶�   
	            totalHeight += listItem.getMeasuredHeight();    
	        }   
	   
	        ViewGroup.LayoutParams params = listView.getLayoutParams();   
	        params.height = totalHeight+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));   
	        // listView.getDividerHeight()��ȡ�����ָ���ռ�õĸ߶�   
	        // params.height���õ�����ListView������ʾ��Ҫ�ĸ߶�   
	        listView.setLayoutParams(params);   
	    }  
}
