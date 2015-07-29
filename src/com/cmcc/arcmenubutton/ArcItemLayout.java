package com.cmcc.arcmenubutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.view.View.MeasureSpec;

import com.cmcc.hfuikit.DisplayUtil;
import com.cmcc.hfuikit.R;

public class ArcItemLayout extends ViewGroup
{
	/**
	 * children will be set the same size.
	 */
	private int mChildSize;
	private Context context;

	private int mLayoutPadding = 10;

	public ArcItemLayout(Context context)
	{
		super(context);
		this.context = context;
	}

	public int getChildSize()
	{
		return mChildSize;
	}

	public void setChildSize(int childSize)
	{
		this.mChildSize = childSize;
	}

	public ArcItemLayout(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		this.context = context;
		if (attrs != null)
		{
			TypedArray a = getContext().obtainStyledAttributes(attrs,
					R.styleable.ArcItemLayout, 0, 0);
			mChildSize = (int) Math.max(
					a.getDimension(R.styleable.ArcItemLayout_childSize, 50f),
					0f);
			a.recycle();
		}
	}

//	@Override
//	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
//	{
//		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//
//		final int count = getChildCount();
//
//		for (int i = 0; i < count; i++)
//		{
//			getChildAt(i)
//					.measure(
//							MeasureSpec.makeMeasureSpec(mChildSize,
//									MeasureSpec.EXACTLY),
//							MeasureSpec.makeMeasureSpec(mChildSize,
//									MeasureSpec.EXACTLY));
//		}
//	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b)
	{

		final int childCount = getChildCount();

		for (int i = 0; i < childCount; i++)
		{
			int size = DisplayUtil.dip2px(context, mChildSize);
			/*
			 * getChildAt(i).layout(mLayoutPadding, mLayoutPadding + size,
			 * mLayoutPadding, mLayoutPadding + size);
			 */
			getChildAt(i).layout(l, t, r, b);
			Log.d("TEST", "l= " + l + "t= " + t + "r= " + r + "b= " + b);
			int[] s = DisplayUtil.getScreenSize(context);
			Log.d("TEST", "w= " + s[0] + "h= " + s[1]);
		}
	}
}
