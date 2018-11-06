package com.cyb.gwjl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cyb.constant.Contanst;
import com.cyb.constant.UrlConstants;
import com.cyb.utils.UrlUtils;

public class QutoesActivity extends Activity {
    private LayoutInflater mInflater;
    private HVListView mListView;
    private DataAdapter adapter;
    private List<Map<String,Object>> data;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_qutoes);
		init();
		mListView = (HVListView) super.findViewById(android.R.id.list);
        //设置列头
        mListView.mListHead = (LinearLayout) super.findViewById(R.id.head);
        //设置数据
        adapter = new DataAdapter(data);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new OnItemOnclickEvent());
        mInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
	}
	//静态数据测试
	public void init(){
    	String uri = "";
        Map<String,String> params = new HashMap<String,String>();
        params.put("type","A");
       	uri = Contanst.WEBPATH+UrlConstants.HYFL;
        String repsoneText = UrlUtils.sendRequestByUri(uri,params);
        System.out.println("客户端请求："+uri+"\n,repsoneText:"+repsoneText);
        data = new ArrayList<Map<String, Object>>();  
	    try {
			JSONArray stockList = new JSONArray(repsoneText);
			for(int i=0;i<stockList.length();i++){
				HashMap<String, Object> map = new HashMap<String, Object>();  
				JSONObject tmp = stockList.getJSONObject(i);
				String code = tmp.getString("CODE_");
				map.put("code", code);
				map.put("code6", code.substring(2, code.length()));
			    map.put("name", tmp.getString("NAME_"));
			    map.put("price", tmp.getString("PRICE_"));
			    map.put("A", tmp.getString("A").replace("-", ""));
			    map.put("A1", tmp.getString("A1").replace("-", ""));
			    map.put("preclose", tmp.getString("PRECLOSE_"));
			    map.put("open", tmp.getString("OPEN_"));
			    map.put("max", tmp.getString("HIGH_"));
			    map.put("min", tmp.getString("LOW_"));
			    map.put("cj1", tmp.getString("VOLUME"));
			    map.put("cj2", tmp.getString("TURNVOLUME"));
			    data.add(map);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
    }
    private class OnItemOnclickEvent implements OnItemClickListener{
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Map<String, Object> map = (Map<String, Object>) QutoesActivity.this.adapter.getItem(position);
			System.out.println("#"+map);
		}
    }
    private class DataAdapter extends BaseAdapter {
    	
    	private List<Map<String,Object>> data;
    	public DataAdapter(List<Map<String,Object>> data){
    		this.data = data;
    	}
        @Override
        public int getCount() {
            return data.size();//固定显示totalRecords行数据
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.activity_qutoes_moban, null);//列表头布局
            }
            Map<String,Object> item = this.data.get(position);
            TextView code = ((TextView) convertView.findViewById(R.id.code));//获取元素设置值
            TextView name = ((TextView) convertView.findViewById(R.id.name));//获取元素设置值
            TextView price = ((TextView) convertView.findViewById(R.id.price));//获取元素设置值
            TextView A = ((TextView) convertView.findViewById(R.id.A));//获取元素设置值
            TextView A1 = ((TextView) convertView.findViewById(R.id.A1));//获取元素设置值
            TextView preclose = ((TextView) convertView.findViewById(R.id.preclose));//获取元素设置值
            TextView max = ((TextView) convertView.findViewById(R.id.max));//获取元素设置值
            TextView min = ((TextView) convertView.findViewById(R.id.min));//获取元素设置值
            TextView open = ((TextView) convertView.findViewById(R.id.open));//获取元素设置值
            TextView cj1 = ((TextView) convertView.findViewById(R.id.cj1));//获取元素设置值
            TextView cj2 = ((TextView) convertView.findViewById(R.id.cj2));//获取元素设置值
            double a1 = Double.valueOf(item.get("A1").toString());
            double open_ = Double.valueOf(item.get("open").toString());
            double max_ = Double.valueOf(item.get("max").toString());
            double min_ = Double.valueOf(item.get("min").toString());
            double preclose_ = Double.valueOf(item.get("preclose").toString());
            double price_ = Double.valueOf(item.get("price").toString());
            name.setTextColor(Color.GRAY);
            code.setTextColor(Color.GRAY);
            int gray = Color.GRAY;
            int red = Color.RED;
            int green = Color.GREEN;
            if(a1>0){
            	A.setTextColor(red);
                A1.setTextColor(red);
            }else if(a1<0){
            	A.setTextColor(green);
                A1.setTextColor(green);
            }else{
            	A.setTextColor(gray);
                A1.setTextColor(gray);
            }
            if(price_>preclose_){
            	 price.setTextColor(red);
            }else if(price_<preclose_){
            	 price.setTextColor(green);
            }else{
            	 price.setTextColor(gray);
            }
            preclose.setTextColor(gray);
            if(max_>preclose_){
           	 max.setTextColor(red);
           }else if(price_<preclose_){
           	 max.setTextColor(green);
           }else{
           	 max.setTextColor(gray);
           }
            if(min_>preclose_){
              	 max.setTextColor(red);
          }else if(price_<preclose_){
          	 min.setTextColor(green);
          }else{
          	 min.setTextColor(gray);
          }
          if(open_>preclose_){
              	 open.setTextColor(red);
          }else if(price_<preclose_){
          	 open.setTextColor(green);
          }else{
          	 open.setTextColor(gray);
          }
            price.setText(item.get("price").toString());
            A.setText(item.get("A").toString());
            A1.setText(item.get("A1").toString());
            preclose.setText(item.get("preclose").toString());
            max.setText(item.get("max").toString());
            min.setText(item.get("min").toString());
            open.setText(item.get("open").toString());
            name.setText(item.get("name").toString());
            code.setText(item.get("code6").toString());
            cj1.setText(item.get("cj1").toString());
            cj2.setText(item.get("cj2").toString());
            //校正（处理同时上下和左右滚动出现错位情况）
            View child = ((ViewGroup) convertView).getChildAt(1);
            int head = mListView.getHeadScrollX();
            if (child.getScrollX() != head) {
                child.scrollTo(mListView.getHeadScrollX(), 0);
            }
            return convertView;
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.qutoes, menu);
		return true;
	}

}
