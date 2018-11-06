package com.cyb.activity;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

import com.cyb.gwjl.R;

public class DateOperActivity extends Activity {
    private EditText dateEt=null;
    private EditText timeEt=null;
  
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_oper);
        dateEt=(EditText)findViewById(R.id.dateEt);
        timeEt=(EditText)findViewById(R.id.timeEt);
        DatePicker datePicker=(DatePicker)findViewById(R.id.datePicker);
        TimePicker timePicker=(TimePicker)findViewById(R.id.timePicker);
        
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int monthOfYear=calendar.get(Calendar.MONTH);
        int dayOfMonth=calendar.get(Calendar.DAY_OF_MONTH);
        datePicker.init(year, monthOfYear, dayOfMonth, new OnDateChangedListener(){

            public void onDateChanged(DatePicker view, int year,
                    int monthOfYear, int dayOfMonth) {
                dateEt.setText("��ѡ��������ǣ�"+year+"��"+(monthOfYear+1)+"��"+dayOfMonth+"�ա�");
            }
            
        });
        
        timePicker.setOnTimeChangedListener(new OnTimeChangedListener(){

            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                timeEt.setText("��ѡ���ʱ���ǣ�"+hourOfDay+"ʱ"+minute+"�֡�");
            }
            
        });
    }
}