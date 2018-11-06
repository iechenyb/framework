package com.cyb.gwjl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
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

public class IndustryActivity extends Activity {
	public Map<Integer,String> hy2Number = null;
	public Map<String,String> hyA2Hanzi = null;
	private LayoutInflater mInflater;
	private HVListView mListView;
	private DataAdapter adapter;
	private List<Map<String,Object>> data;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.activity_qutoes);
		init();
		Intent intent=getIntent();
	    String type = intent.getStringExtra("type");
		this.setTitle(hyA2Hanzi.get(type));
		setList(type);
		mListView = (HVListView) super.findViewById(android.R.id.list);
        //������ͷ
        mListView.mListHead = (LinearLayout) super.findViewById(R.id.head);
        //��������
        adapter = new DataAdapter(data);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new OnItemOnclickEvent());
        mInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
	}
	public void setList(String type){
		    String uri = "";
	        Map<String,String> params = new HashMap<String,String>();
	        params.put("type",type);
	       	uri = Contanst.WEBPATH+UrlConstants.HYFL;
	        String repsoneText = UrlUtils.sendRequestByUri(uri,params);
	        System.out.println("�ͻ�������"+uri+"\n,repsoneText:"+repsoneText);
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
				    map.put("A", tmp.getString("A"));
				    map.put("A1", tmp.getString("A1"));
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
		      /*lstView = (ListView) super.findViewById(R.id.stockqutoeslst);
		      adapter = new SimpleAdapter(this, //ûʲô����  
	                 data,//������Դ   
	                 R.layout.stock_qutoes_list,
	                 //��̬������ImageItem��Ӧ������          
	                 new String[] {"code","code6","name","price","A","A1","preclose","open","high","low","cj1","cj2"},   
	                 //ImageItem��XML�ļ������һ��ImageView,����TextView ID  
	                 new int[] {R.id.codeHidden,R.id.codeId,R.id.codeName,R.id.newPrice,R.id.A,R.id.A1,R.id.PRECLOSE,R.id.OPEN,R.id.HIGH,R.id.LOW,R.id.CJ1,R.id.CJ2});  
		     lstView.setAdapter(adapter);
		     lstView.setOnItemClickListener(new OnItemOnclickEvent());*/
	}
private class DataAdapter extends BaseAdapter {
    	
    	private List<Map<String,Object>> data;
    	public DataAdapter(List<Map<String,Object>> data){
    		this.data = data;
    	}
        @Override
        public int getCount() {
            return data.size();//�̶���ʾtotalRecords������
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.activity_qutoes_moban, null);//�б�ͷ����
            }
            Map<String,Object> item = this.data.get(position);
            TextView code = ((TextView) convertView.findViewById(R.id.code));//��ȡԪ������ֵ
            TextView name = ((TextView) convertView.findViewById(R.id.name));//��ȡԪ������ֵ
            TextView price = ((TextView) convertView.findViewById(R.id.price));//��ȡԪ������ֵ
            TextView A = ((TextView) convertView.findViewById(R.id.A));//��ȡԪ������ֵ
            TextView A1 = ((TextView) convertView.findViewById(R.id.A1));//��ȡԪ������ֵ
            TextView preclose = ((TextView) convertView.findViewById(R.id.preclose));//��ȡԪ������ֵ
            TextView max = ((TextView) convertView.findViewById(R.id.max));//��ȡԪ������ֵ
            TextView min = ((TextView) convertView.findViewById(R.id.min));//��ȡԪ������ֵ
            TextView open = ((TextView) convertView.findViewById(R.id.open));//��ȡԪ������ֵ
            TextView cj1 = ((TextView) convertView.findViewById(R.id.cj1));//��ȡԪ������ֵ
            TextView cj2 = ((TextView) convertView.findViewById(R.id.cj2));//��ȡԪ������ֵ
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
            A.setText(item.get("A").toString().replace("-", ""));
            A1.setText(item.get("A1").toString().replace("-", ""));
            preclose.setText(item.get("preclose").toString());
            max.setText(item.get("max").toString());
            min.setText(item.get("min").toString());
            open.setText(item.get("open").toString());
            name.setText(item.get("name").toString());
            code.setText(item.get("code6").toString());
            cj1.setText(item.get("cj1").toString());
            cj2.setText(item.get("cj2").toString());
            //У��������ͬʱ���º����ҹ������ִ�λ�����
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
		 String[] hangyearr =  Contanst.hangyestr.split(",");
		 for(int i=0;i<hangyearr.length;i++){
			  hy2Number.put(i+1, hangyearr[i].split("#")[0]);
			  menu.add(Menu.NONE, Menu.FIRST+i, i,hangyearr[i].split("#")[1]).setIcon(R.drawable.ic_launcher);
		  }
		return true;
	}
	public void init(){
		hy2Number =new HashMap<Integer, String>();
		hyA2Hanzi =new HashMap<String, String>();
		String[] hangyearr =  Contanst.hangyestr.split(",");
		 for(int i=0;i<hangyearr.length;i++){
			  hy2Number.put(i+1, hangyearr[i].split("#")[0]);
			  hyA2Hanzi.put(hangyearr[i].split("#")[0], hangyearr[i].split("#")[1]);
		  }
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		 Intent intent = new Intent();
		 intent.putExtra("type", hy2Number.get(item.getItemId()));
   	 	 intent.setClass(this, IndustryActivity.class);
   	 	 startActivity(intent);
		return super.onOptionsItemSelected(item);
	}
	 private class OnItemOnclickEvent implements OnItemClickListener{
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				HashMap<String, Object> map = (HashMap<String, Object>) IndustryActivity.this.adapter.getItem(position);
				String code = (String) map.get("code");
				Intent intent = new Intent();
		    	intent.putExtra("code", code);
		    	intent.setClass(IndustryActivity.this, ExploreActivity.class);
		        startActivity(intent);
			}
   }
}
