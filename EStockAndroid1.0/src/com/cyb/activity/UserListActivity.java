package com.cyb.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.cyb.gwjl.R;

public class UserListActivity extends Activity {
    ListView itemlist = null;
    List<Map<String, Object>> list;

    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_user_list);//R.layout.activity_chat
            itemlist = (ListView) findViewById(R.id.listView);
//            LinearLayout layout =(LinearLayout)findViewById(R.id.myLinearLayout);
//            LinearLayout.LayoutParams parasm = new LinearLayout.LayoutParams(
//            		ViewGroup.LayoutParams.FILL_PARENT,
//            		ViewGroup.LayoutParams.WRAP_CONTENT
//            		);
//            
            //itemlist = new ListView(this);
            refreshListItems();      
           //layout.addView(itemlist);
    }
    private void refreshListItems() {
            list = buildListForSimpleAdapter();
            //实例适配器
            SimpleAdapter chat = new SimpleAdapter(this, list, R.layout.activity_data_list,
                            new String[] {"chatportrait","chatinfo"}, new int[] {R.id.imgPortraitA,R.id.txvInfo});
            itemlist.setAdapter(chat);
            itemlist.setSelection(0);
            setListViewHeightBasedOnChildren(itemlist);
    }
    
    //用来实例化列表容器的函数
    private List<Map<String, Object>> buildListForSimpleAdapter() {
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(2);
            ImageView  imgA=(ImageView)findViewById(R.id.imgPortraitA);
            //向列表容器中添加数据（每列中包括一个头像和聊天信息）
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "嗨~");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "嗨~\n你好！");
            list.add(map);

            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "嗨~\n你好！");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "嗨~\n你好！\n我是张三~");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "嗨~\n你好！\n我是张三啊~");
            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "嗨~\n你好！");
            list.add(map);

            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "嗨~\n你好！");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "嗨~\n你好！\n我是张三~");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "嗨~\n你好！\n我是张三啊~");
            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "嗨~\n你好！");
            list.add(map);

            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "嗨~\n你好！");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "嗨~\n你好！\n我是张三~");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "嗨~\n你好！\n我是张三啊~");
            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "嗨~\n你好！");
            list.add(map);

            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "嗨~\n你好！");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "嗨~\n你好！\n我是张三~");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "嗨~\n你好！\n我是张三啊~");
            
            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "我女友有公积金，我要也办个公积金咋想法能买到两套房还都能用上公积金里.");
            
            list.add(map);            
            return list;
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
