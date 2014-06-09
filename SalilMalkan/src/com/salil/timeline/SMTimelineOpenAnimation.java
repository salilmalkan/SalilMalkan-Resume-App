package com.salil.timeline;

import android.content.Context;
import android.util.FloatMath;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;

import com.salil.SMGlobalHelper;


public class SMTimelineOpenAnimation extends Animation
{
	private final Context mContext;
	private final View mView;
	private final int mTargetX;

	public SMTimelineOpenAnimation(Context context, View view)
	{
		this.mContext = context;
		this.mView = view;

		int screenWidth = SMGlobalHelper.getScreenWidth(this.mContext);
		this.mTargetX = (int) (screenWidth * .8);
		this.setDuration(750);

	}

	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t)
	{
		RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mView
				.getLayoutParams();

		layoutParams.leftMargin = -(int) FloatMath.ceil(this.mTargetX
				* interpolatedTime);
		this.mView.setLayoutParams(layoutParams);
		this.mView.requestLayout();
	}

	@Override
	public boolean willChangeBounds()
	{
		return true;
	}
}