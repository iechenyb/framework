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

public class MyConcernActivity extends Activity {
private LayoutInflater mInflater;
private HVListView mListView;
private DataAdapter adapter;
private List<Map<String,Object>> data;
private Intent it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_qutoes);
        Intent intent=getIntent();
        setList(intent);
        it = intent;
        mListView = (HVListView) super.findViewById(android.R.id.list);
        //������ͷ
        mListView.mListHead = (LinearLayout) super.findViewById(R.id.head);
        //��������
        adapter = new DataAdapter(data);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new OnItemOnclickEvent());
        mInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        /*String type = intent.getStringExtra("type");
        if("myConcern".equals(type)){
        	ne111dfgdfg12311231231w Thread(new PushThread()).start();
        }*/
	    /* datalist = (ListView) super.findViewById(R.id.stockqutoeslst);
	     adapter = new SimpleAdapter(this, //ûʲô����  
                 data,//������Դ   
                 R.layout.stock_qutoes_list,
                 //��̬������ImageItem��Ӧ������          
                 new String[] {"code","code6","name","price","A","A1","preclose","open","high","low","cj1","cj2"},   
                 //ImageItem��XML�ļ������һ��ImageView,����TextView ID  
                 new int[] {R.id.codeHidden,R.id.codeId,R.id.codeName,R.id.newPrice,R.id.A,R.id.A1,R.id.PRECLOSE,R.id.OPEN,R.id.HIGH,R.id.LOW,R.id.CJ1,R.id.CJ2});  
	     datalist.setAdapter(adapter);
	     datalist.setOnItemClickListener(new OnItemOnclickEvent());*/
    }
    private class PushThread implements Runnable{
		@Override
		public void run() {
			while(true){
				try {
					Thread.sleep(5*1000);
					System.out.println("pushmyconcern...");
					setList(it);
			        adapter = new DataAdapter(data);
			        mListView.setAdapter(adapter);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}
    	
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
    public void setList(Intent intent){
    	String type = intent.getStringExtra("type");
        String uri = "[]";
        Map<String,String> params = new HashMap<String,String>();
        if("myConcern".equals(type)){
        	this.setTitle("��ѡ��");
        	 params.put("username", Contanst.USERNAME); 
        	 uri = Contanst.WEBPATH+UrlConstants.MYCONCERNS;
        }else if("zhzs".equals(type)){
        	this.setTitle("����ָ��");
        	 uri = Contanst.WEBPATH+UrlConstants.ZHZS;
        }else {
        	if("sz".equals(type)){
        		this.setTitle("���ǰ�");
        	}else if("xd".equals(type)){
        		this.setTitle("�µ���");
        	}else if("zt".equals(type)){
        		this.setTitle("��ͣ��");
        	}else if("dt".equals(type)){
        		this.setTitle("��ͣ��");
        	}else if("tp".equals(type)){
        		this.setTitle("ͣ�ư�");
        	}
        	 params.put("type", type); 
       	  	 uri = Contanst.WEBPATH+UrlConstants.ZDFX;
	    } 
        String repsoneText = UrlUtils.sendRequestByUri(uri,params);
        System.out.println("�ͻ�������"+uri+"\n,repsoneText:"+repsoneText);
        data = new ArrayList<Map<String, Object>>();  
	    try {
			JSONArray stockList = new JSONArray(repsoneText);
			for(int i=0;i<stockList.length();i++){
				HashMap<String, Object> map = new HashMap<String, Object>();  
				JSONObject tmp = stockList.getJSONObject(i);
				String code = tmp.getString("CODE_");
				map.put("code6", code.substring(2, code.length()));
				map.put("code", code);
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
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_concern, menu);
        return true;
    } 
    private class OnItemOnclickEvent implements OnItemClickListener{
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			HashMap<String, Object> map = (HashMap<String, Object>) MyConcernActivity.this.adapter.getItem(position);
			String code = (String) map.get("code");
			Intent intent = new Intent();
	    	intent.putExtra("code", code);
	    	intent.setClass(MyConcernActivity.this, ExploreActivity.class);
	        startActivity(intent);
		}
    }
}
