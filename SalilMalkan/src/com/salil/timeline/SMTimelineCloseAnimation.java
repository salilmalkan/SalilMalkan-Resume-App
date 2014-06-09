package com.salil.timeline;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;

import com.salil.SMGlobalHelper;


public class SMTimelineCloseAnimation extends Animation
{
	private final Context mContext;
	private final View mView;
	private final int mTargetX;

	public SMTimelineCloseAnimation(Context context, View view)
	{
		this.mContext = context;
		this.mView = view;

		int screenWidth = SMGlobalHelper.getScreenWidth(this.mContext);
		this.mTargetX = (int) (screenWidth * .5);
		this.setDuration(750);
	}

	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t)
	{
		RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mView
				.getLayoutParams();

		layoutParams.rightMargin = this.mTargetX;
	}

	@Override
	public boolean willChangeBounds()
	{
		return true;
	}
}
