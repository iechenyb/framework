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
            //ʵ��������
            SimpleAdapter chat = new SimpleAdapter(this, list, R.layout.activity_data_list,
                            new String[] {"chatportrait","chatinfo"}, new int[] {R.id.imgPortraitA,R.id.txvInfo});
            itemlist.setAdapter(chat);
            itemlist.setSelection(0);
    }
    
    //����ʵ�����б������ĺ���
    private List<Map<String, Object>> buildListForSimpleAdapter() {
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>(2);
            ImageView  imgA=(ImageView)findViewById(R.id.imgPortraitA);
            //���б�������������ݣ�ÿ���а���һ��ͷ���������Ϣ��
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "��~");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "��~\n��ã�");
            list.add(map);

            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "��~\n��ã�");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "��~\n��ã�\n��������~");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "��~\n��ã�\n����������~");
            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "��~\n��ã�");
            list.add(map);

            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "��~\n��ã�");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "��~\n��ã�\n��������~");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "��~\n��ã�\n����������~");
            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "��~\n��ã�");
            list.add(map);

            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "��~\n��ã�");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "��~\n��ã�\n��������~");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "��~\n��ã�\n����������~");
            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "��~\n��ã�");
            list.add(map);

            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "��~\n��ã�");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "��~\n��ã�\n��������~");
            list.add(map);
            
            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "��~\n��ã�\n����������~");
            
            map = new HashMap<String, Object>();
            map.put("chatportrait",imgA);
            map.put("chatinfo", "��Ů���й�������ҪҲ���������զ�뷨�������׷����������Ϲ�������.");
            
            list.add(map);            
            return list;
    }
}
