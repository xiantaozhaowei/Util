package com.zhao.util.util;

/**
 * 作者：赵炜
 * 创建日期：2016/10/14
 * 邮箱：zhaowei0920@thundersoft.com
 * 描述：//TODO
 */

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zhao.util.R;


//Toast的封装，以免重复弹出提示
public class ToastUtil {
	private static Toast mToast;
	private static Context mContext;
	private static ImageView mStatusImage;
	private static TextView mMessageTextView;

	/**
	 * discription:ToastAlone的初始化
	 *
	 * @param context 使用getApplicationContext,以免内存泄漏
	 */
	public static void init(Context context) {
		mContext = context;
	}

	public static void showString(String content) {
		if (mContext == null) {
			return;
		}
		if (mToast == null) {
			mToast = createToast();
		}
		mMessageTextView.setText(content);
		mToast.show();
	}

	public static void showString(int resId) {
		if (mToast == null) {
			mToast = createToast();
		}
		mMessageTextView.setText(resId);
		mToast.show();
	}

	public static void showString(int resId,String msg) {
		if (mToast == null) {
			mToast = createToast();
		}
		mStatusImage.setImageResource(resId);
		mMessageTextView.setText(msg);
		mToast.show();
	}


	public static void showString(int resId,int msg) {
		if (mToast == null) {
			mToast = createToast();
		}
		mStatusImage.setImageResource(resId);
		mMessageTextView.setText(msg);
		mToast.show();
	}


	private static Toast createToast() {
		Toast toast = new Toast(mContext);
		View view = LayoutInflater.from(mContext).inflate(R.layout.toast_view, null);
		mStatusImage = (ImageView) view.findViewById(R.id.status_image);
		mMessageTextView = (TextView) view.findViewById(R.id.status_msg);
		toast.setView(view);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.setDuration(Toast.LENGTH_SHORT);
		return toast;
	}
}

