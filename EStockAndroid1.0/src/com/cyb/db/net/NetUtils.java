package com.cyb.db.net;

import java.util.List;

import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

public class NetUtils {
	//�ж����������Ƿ���� 
	public static boolean isNetworkAvailable(Context context) {   
        ConnectivityManager cm = (ConnectivityManager) context   
                .getSystemService(Context.CONNECTIVITY_SERVICE);   
        if (cm == null) {   
        } else { 
        	//��������������ж���������,�����ʹ�� cm.getActiveNetworkInfo().isAvailable(); 
            NetworkInfo[] info = cm.getAllNetworkInfo();   
            if (info != null) {   
                for (int i = 0; i < info.length; i++) {   
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {   
                        return true;   
                    }   
                }   
            }   
        }   
        return false;   
    }
	
	//GPS�Ƿ��
	public static boolean isGpsEnabled(Context context) {   
        LocationManager lm = ((LocationManager) context   
                .getSystemService(Context.LOCATION_SERVICE));   
        List<String> accessibleProviders = lm.getProviders(true);   
        return accessibleProviders != null && accessibleProviders.size() > 0;   
    } 
	//wifi�Ƿ��
	public static boolean isWifiEnabled(Context context) {   
        ConnectivityManager mgrConn = (ConnectivityManager) context   
                .getSystemService(Context.CONNECTIVITY_SERVICE);   
        TelephonyManager mgrTel = (TelephonyManager) context   
                .getSystemService(Context.TELEPHONY_SERVICE);   
        return ((mgrConn.getActiveNetworkInfo() != null && mgrConn   
                .getActiveNetworkInfo().getState() == NetworkInfo.State.CONNECTED) || mgrTel   
                .getNetworkType() == TelephonyManager.NETWORK_TYPE_UMTS);   
    }
	
	//�Ƿ���3g����
	public static boolean is3g(Context context) {   
        ConnectivityManager cm = (ConnectivityManager) context   
                .getSystemService(Context.CONNECTIVITY_SERVICE);   
        NetworkInfo networkINfo = cm.getActiveNetworkInfo();   
        if (networkINfo != null   
                && networkINfo.getType() == ConnectivityManager.TYPE_MOBILE) {   
            return true;   
        }   
        return false;   
    }
	//�ж��Ƿ���wifi����
	public static boolean isWifi(Context context) {   
        ConnectivityManager cm = (ConnectivityManager) context   
                .getSystemService(Context.CONNECTIVITY_SERVICE);   
        NetworkInfo networkINfo = cm.getActiveNetworkInfo();   
        if (networkINfo != null   
                && networkINfo.getType() == ConnectivityManager.TYPE_WIFI) {   
            return true;   
        }   
        return false;   
    }
}
