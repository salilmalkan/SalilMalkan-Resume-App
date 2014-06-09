package com.salil.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;

import com.salil.R;


public class SMSimpleButton extends RelativeLayout
{
	private final ImageView mImageView;

	private Drawable mNormalDrawable;
	private Drawable mPressedDrawable;

	public SMSimpleButton(Context context)
	{
		super(context);
		this.mImageView = new ImageView(this.getContext());
		this.addView(this.mImageView);
		this.init();
	}

	public SMSimpleButton(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		this.mImageView = new ImageView(this.getContext());
		this.addView(this.mImageView);
		this.setUpAttr(attrs);
		this.init();
	}

	public SMSimpleButton(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		this.mImageView = new ImageView(this.getContext());
		this.addView(this.mImageView);
		this.setUpAttr(attrs);
		this.init();
	}

	private void setUpAttr(AttributeSet attrs)
	{
		TypedArray a = this.getContext().obtainStyledAttributes(attrs,
				R.styleable.SMSimpleButton);

		final int N = a.getIndexCount();
		for (int i = 0; i < N; i++)
		{
			int attr = a.getIndex(i);
			switch (attr)
			{

			case R.styleable.SMSimpleButton_img:
				this.mPressedDrawable = a.getDrawable(attr);
				this.mNormalDrawable = a.getDrawable(attr);
				if (this.mNormalDrawable != null)
				{
					this.mImageView.setImageDrawable(this.mNormalDrawable);
				}
				break;
			case R.styleable.SMSimpleButton_fitxy:
				boolean fit = a.getBoolean(attr, false);
				if (fit)
				{
					this.mImageView.setScaleType(ScaleType.FIT_XY);
				}
			}
		}

		a.recycle();
	}

	public void init()
	{

		this.setOnTouchListener(this.mTouchListener);
		this.makeDrawables();
		this.setClickable(true);
	}

	private void makeDrawables()
	{
		if (this.mPressedDrawable != null)
		{
			this.mPressedDrawable.mutate().setColorFilter(Color.GRAY,
					Mode.MULTIPLY);
		}
	}

	public OnTouchListener mTouchListener = new OnTouchListener()
	{

		@Override
		public boolean onTouch(View v, MotionEvent event)
		{
			if (event.getAction() == MotionEvent.ACTION_DOWN)
			{
				SMSimpleButton.this.mImageView
						.setImageDrawable(SMSimpleButton.this.mPressedDrawable);
			} else if (event.getAction() != MotionEvent.ACTION_MOVE)
			{
				SMSimpleButton.this.mImageView
						.setImageDrawable(SMSimpleButton.this.mNormalDrawable);
			}
			return false;
		}
	};

	public void setImageResource(int resource)
	{
		this.mPressedDrawable = this.getContext().getResources()
				.getDrawable(resource);
		this.mNormalDrawable = this.getContext().getResources()
				.getDrawable(resource);
		this.makeDrawables();
		if (this.mNormalDrawable != null)
		{
			this.mImageView.setImageDrawable(this.mNormalDrawable);
		}
	}

	public void setScaleType(ScaleType scaleType)
	{
		this.mImageView.setScaleType(scaleType);
	}
}