package com.zhao.util;

import android.content.Context;
import android.graphics.Point;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

public class VDHLayout extends LinearLayout {
	private ViewDragHelper mDragger;

	private View mDragView;
	private View mAutoBackView;
	private View mEdgeTrackerView;

	private Point mAutoBackOriginPos = new Point();

	public VDHLayout(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		mDragger = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback()
		{
			@Override
			public boolean tryCaptureView(View child, int pointerId)
			{
				//mEdgeTrackerView禁止直接移动
				return child == mDragView || child == mAutoBackView;
			}

			@Override
			public int clampViewPositionHorizontal(View child, int left, int dx)
			{
				final int leftBound = getPaddingLeft();
				final int rightBound = getWidth() - mDragView.getWidth() - leftBound;

				final int newLeft = Math.min(Math.max(left, leftBound), rightBound);

				return newLeft;
			}

			@Override
			public int clampViewPositionVertical(View child, int top, int dy)
			{
				return top;
			}

			//手指释放的时候回调
			@Override
			public void onViewReleased(View releasedChild, float xvel, float yvel) {
				///mAutoBackView手指释放时可以自动回去
				if (releasedChild == mAutoBackView)
				{
					mDragger.settleCapturedViewAt(mAutoBackOriginPos.x, mAutoBackOriginPos.y);
					invalidate();
				}
			}
		});
	}

	@Override
	public boolean onInterceptTouchEvent(MotionEvent event)
	{
		return mDragger.shouldInterceptTouchEvent(event);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event)
	{
		mDragger.processTouchEvent(event);
		return true;
	}
}
