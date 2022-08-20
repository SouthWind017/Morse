package com.symboljoyful.morse.ui.utils;

import android.content.Context;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.symboljoyful.morse.R;

public class ToastUtil {
    private static Toast mToast;
    private static final Handler mHandler = new Handler();
    private static final Runnable runnable = new Runnable() {
        public void run() {
            if(mToast != null)
                mToast.cancel();
            //toast隐藏后，将其置为null
            mToast = null;
        }
    };

    public static void centerToast(Context context, String message) {
        if(mToast != null)
            mToast.cancel();
        //toast隐藏后，将其置为null
        mToast = null;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //自定义布局
        View view = inflater.inflate(R.layout.custom_toast, null );
        TextView text = view.findViewById(R.id.toast_message);
        //显示的提示文字
        text.setText(message);
        mHandler.removeCallbacks(runnable);
        //只有mToast==null时才重新创建，否则只需更改提示文字
        if (mToast == null){
            mToast = new Toast(context);
            mToast.setGravity(Gravity.CENTER,0,0);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.setView(view);
        mToast.show();
    }
}