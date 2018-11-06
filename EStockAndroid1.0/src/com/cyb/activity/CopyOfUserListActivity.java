package com.cyb.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.cyb.gwjl.R;

public class CopyOfUserListActivity extends Activity {
    ListView itemlist = null;
    List<Map<String, Object>> list;

    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_user_list);//R.layout.activity_chat
           itemlist = (ListView) findViewById(R.id.listView);
            refreshListItems();           
    }
    private void refreshListItems() {
            list = buildListForSimpleAdapter();
            //实例适配器
            SimpleAdapter chat = new SimpleAdapter(this, list, R.layout.activity_data_list,
                            new String[] {"chatportrait","chatinfo"}, new int[] {R.id.imgPortraitA,R.id.txvInfo});
            itemlist.setAdapter(chat);
            itemlist.setSelection(0);
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
}
