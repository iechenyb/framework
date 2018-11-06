package com.cyb.gwjl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.cyb.constant.Contanst;
import com.cyb.constant.UrlConstants;
import com.cyb.utils.UrlUtils;

public class SearchActivity extends Activity {
	 SimpleAdapter adapter ;
	 ListView lstView ;
	 public Button search;
	 public EditText condition ;
	 String uri = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		search = (Button) super.findViewById(R.id.search);
		condition = (EditText) super.findViewById(R.id.condition);
		Intent intent=getIntent();
	    String condition = intent.getStringExtra("condition");
	    if(condition!=null&&!"".equals(condition)){
	    	setList(condition);
	    }
	    search.setOnClickListener(new OnclickEvent());
		
	}
	 private class OnItemOnclickEvent implements OnItemClickListener{
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				HashMap<String, Object> map = (HashMap<String, Object>) SearchActivity.this.adapter.getItem(position);
				String code = (String) map.get("code");
				Intent intent = new Intent();
		    	intent.putExtra("code", code);
		    	intent.setClass(SearchActivity.this, ExploreActivity.class);
		        startActivity(intent);
			}
	 }
	 
	 
	private class OnclickEvent implements OnClickListener{
		@Override
		public void onClick(View v) {
			String condition = SearchActivity.this.condition.getText().toString().trim();
			/*Intent intent = new Intent();
	    	intent.putExtra("condition", condition);
	    	intent.setClass(SearchActivity.this, SearchActivity.class);
	        startActivity(intent);*/
			setList(condition);
		}
		
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}
	public void setList(String condition){
        Map<String,String> params = new HashMap<String,String>();
        params.put("condition",condition);
       	uri = Contanst.WEBPATH+UrlConstants.SEARCH;
        String repsoneText = UrlUtils.sendRequestByUri(uri,params);
        System.out.println("客户端请求："+uri+"\n,repsoneText:"+repsoneText);
        ArrayList<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>(); 
        
		try {
				JSONArray dataArr = new JSONArray(repsoneText);
				JSONObject stockObj = dataArr.getJSONObject(0);
				JSONArray stockList = stockObj.getJSONArray("lst");
				for(int i=0;i<stockList.length();i++){
					HashMap<String, Object> map = new HashMap<String, Object>();  
					JSONObject tmp = stockList.getJSONObject(i);
					String code = tmp.getString("code");
					map.put("code", code);
					map.put("code6", code.substring(2, code.length()));
				    map.put("name", tmp.getString("name"));
				    data.add(map);
				}
	     } catch (JSONException e) {
				e.printStackTrace();
		}
	      lstView = (ListView) super.findViewById(R.id.stocklst);
	      adapter = new SimpleAdapter(this, //没什么解释  
                 data,//数据来源   
                 R.layout.stock_qutoes_list,
                 //动态数组与ImageItem对应的子项          
                 new String[] {"code","code6","name"},   
                 //ImageItem的XML文件里面的一个ImageView,两个TextView ID  
                 new int[] {R.id.codeHidden,R.id.codeId,R.id.codeName});  
	     lstView.setAdapter(adapter);
	     lstView.setOnItemClickListener(new OnItemOnclickEvent());
	  }
}
