package com.cyb.gwjl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.cyb.constant.Contanst;
import com.cyb.constant.UrlConstants;
import com.cyb.utils.UrlUtils;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
//http://www.cnblogs.com/over140/archive/2011/12/07/2275207.html
public class FixHeaderActivity extends Activity {
    private int totalRecords=50;
    private LayoutInflater mInflater;
    private HVListView mListView;
    private DataAdapter adapter;
    private List<Map<String,Object>> data;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	init();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mListView = (HVListView) findViewById(android.R.id.list);
        //设置列头
        mListView.mListHead = (LinearLayout) findViewById(R.id.head);
        //设置数据
        data = new ArrayList<Map<String,Object>>();
        adapter = new DataAdapter(data);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new OnItemOnclickEvent());
        mInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
    }
    
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
			    map.put("high", tmp.getString("HIGH_"));
			    map.put("low", tmp.getString("LOW_"));
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
			Map<String, Object> map = (Map<String, Object>) FixHeaderActivity.this.adapter.getItem(position);
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
            return totalRecords;//固定显示totalRecords行数据
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.item, null);//列表头布局
            }
            System.out.println("position:"+position);
            for (int i = 0; i < 8; i++) {
            	String zb = position+"#"+(i + 2);
            	TextView tv = ((TextView) convertView.findViewById(R.id.item2 + i));//获取元素设置值
                //item.setText("数据" + position + "行" + (i + 2) + "列");
                SpannableStringBuilder builder = new SpannableStringBuilder("数据" + position + "行" + (i + 2) + "列");  
                //ForegroundColorSpan 为文字前景色，BackgroundColorSpan为文字背景色  
                ForegroundColorSpan redSpan = new ForegroundColorSpan(Color.RED);  
                ForegroundColorSpan whiteSpan = new ForegroundColorSpan(Color.WHITE);  
                ForegroundColorSpan blueSpan = new ForegroundColorSpan(Color.BLUE);  
                ForegroundColorSpan greenSpan = new ForegroundColorSpan(Color.GREEN);  
                ForegroundColorSpan yellowSpan = new ForegroundColorSpan(Color.YELLOW);  
                builder.setSpan(redSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);  
                builder.setSpan(whiteSpan, 1, 2, Spannable.SPAN_INCLUSIVE_INCLUSIVE);  
                builder.setSpan(blueSpan, 2, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);  
                builder.setSpan(greenSpan, 3, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);  
                builder.setSpan(yellowSpan, 4,5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); 
                tv.setText(builder);  
                //item.put(zb, tv.getText().toString());
            }
            //data.set(position, item);
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
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }
    }
}