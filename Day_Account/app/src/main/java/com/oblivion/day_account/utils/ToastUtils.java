package com.oblivion.day_account.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * author:Created by Oblivion on 2017/1/19.
 * 功能描述:自定义Toast工具类
 */

public class ToastUtils {

    private static Toast toast;

    public static void makeText(Context context, String msg) {
        if (toast == null) {
            toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
        }
        toast.setText(msg);
        toast.show();
    }
}
