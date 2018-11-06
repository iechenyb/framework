package com.cyb.gwjl;

import java.util.ArrayList; 
import java.util.List; 
import java.util.Random; 
                         
import android.content.Context; 
import android.graphics.Canvas; 
import android.graphics.Color; 
import android.graphics.Paint; 
import android.graphics.Path; 
import android.os.Handler; 
import android.os.Message; 
import android.util.AttributeSet; 
import android.view.View; 
                         
/**
 * 
 * @author ����Сǿ http://blog.csdn.net/dawanganban
 * 
 */ 
public class LineView2 extends View { 
	private int XPoint = 60; 
    private int YPoint = 660; 
    private int XScale = 8;  //�̶ȳ��� 
    private int YScale = 40; 
    private int XLength = 650; 
    private int YLength = YScale*10; 
                         
    private int MaxDataSize = XLength / XScale; 
                         
    private List<Integer> data = new ArrayList<Integer>(); 
                         
    private String[] YLabel = new String[YLength / YScale]; 
                         
    private Handler handler = new Handler() { 
        public void handleMessage(Message msg) { 
            if (msg.what == 0x1234) { 
                LineView2.this.invalidate(); 
            } 
        }; 
    }; 
                         
    public LineView2(Context context, AttributeSet attrs) { 
        super(context, attrs); 
        for (int i = 0; i < YLabel.length; i++) { 
            YLabel[i] = (i + 1) + "M/s"; 
        } 
                         
        new Thread(new Runnable() { 
                         
            @Override 
            public void run() { 
                while (true) { 
                    try { 
                        Thread.sleep(1000); 
                    } catch (InterruptedException e) { 
                        e.printStackTrace(); 
                    } 
                    if (data.size() >= MaxDataSize) { 
                        data.remove(0); 
                    } 
                    data.add(new Random().nextInt(7) + 1); 
                    handler.sendEmptyMessage(0x1234); 
                } 
            } 
        }).start(); 
    } 
                         
    @Override 
    protected void onDraw(Canvas canvas) { 
        super.onDraw(canvas); 
        Paint paint = new Paint(); 
        paint.setStyle(Paint.Style.STROKE); 
        paint.setAntiAlias(true); // ȥ��� 
        paint.setColor(Color.BLACK); 
                         
        // ��Y�� 
        canvas.drawLine(XPoint, YPoint - YLength, XPoint, YPoint, paint); 
                         
        // Y���ͷ 
        canvas.drawLine(XPoint, YPoint - YLength, XPoint - 3, YPoint - YLength 
                + 6, paint); // ��ͷ 
        canvas.drawLine(XPoint, YPoint - YLength, XPoint + 3, YPoint - YLength 
                + 6, paint); 
                         
        // ��ӿ̶Ⱥ����� 
        for (int i = 0; i * YScale < YLength; i++) { 
            canvas.drawLine(XPoint, YPoint - i * YScale, XPoint + 5, YPoint - i 
                    * YScale, paint); // �̶� 
                         
            canvas.drawText(YLabel[i], XPoint - 50, YPoint - i * YScale, paint);// ���� 
        } 
                         
        // ��X�� 
        canvas.drawLine(XPoint, YPoint, XPoint + XLength, YPoint, paint); 
                         
        // ������ 
        /*
         * if(data.size() > 1){ for(int i=1; i<data.size(); i++){
         * canvas.drawLine(XPoint + (i-1) * XScale, YPoint - data.get(i-1) *
         * YScale, XPoint + i * XScale, YPoint - data.get(i) * YScale, paint); }
         * }
         */ 
        paint.setColor(Color.RED); 
        paint.setStrokeWidth(5); 
                         
        Paint paint2 = new Paint(); 
        paint2.setColor(Color.BLUE); 
        paint2.setStyle(Paint.Style.FILL); 
        if (data.size() > 1) { 
            Path path = new Path(); 
            Path path2 = new Path(); 
            path.moveTo(XPoint, YPoint - data.get(0) * YScale); 
            path2.moveTo(XPoint, YPoint); 
            for (int i = 0; i < data.size(); i++) { 
                path.lineTo(XPoint + i * XScale, YPoint - data.get(i) * YScale); 
                path2.lineTo(XPoint + i * XScale, YPoint - data.get(i) * YScale); 
            } 
            path2.lineTo(XPoint + (data.size() - 1) * XScale, YPoint); 
            canvas.drawPath(path, paint); 
            canvas.drawPath(path2, paint2); 
        } 
    } 
}
