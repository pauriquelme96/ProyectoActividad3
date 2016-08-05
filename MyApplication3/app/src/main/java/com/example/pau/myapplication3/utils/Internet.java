package com.example.pau.myapplication3.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Pau on 04/08/2016.
 */
public class Internet {
    public static boolean isNetworkAvailable(Context context){

        boolean br = false;

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        br = (null != activeNetworkInfo && activeNetworkInfo.isConnected());

        return br;
    }

    public static boolean isWifiAvailable (Context context) {
        boolean bdev = false;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        bdev = ((null != activeNetwork)&& (activeNetwork.isConnected()) && (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI));

        return bdev;
    }
}
