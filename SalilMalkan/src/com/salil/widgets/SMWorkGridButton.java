package com.salil.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageButton;

import com.salil.SMGlobalHelper;


public class SMWorkGridButton extends ImageButton
{
	private Boolean mSizeIsSet = false;

	public SMWorkGridButton(Context context)
	{
		super(context);
	}

	public SMWorkGridButton(Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}

	public SMWorkGridButton(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
	}

	private void initSize()
	{
		int displayWidth = SMGlobalHelper.getScreenWidth(this.getContext());
		int sideSize = displayWidth / 2;
		sideSize -= TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15,
				this.getContext().getResources().getDisplayMetrics());

		this.getLayoutParams().width = sideSize;
		this.getLayoutParams().height = sideSize;

		this.mSizeIsSet = true;

		this.requestLayout();
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh)
	{
		super.onSizeChanged(w, h, oldw, oldh);

		if ( !this.mSizeIsSet)
		{
			this.initSize();
		}
	}

}
