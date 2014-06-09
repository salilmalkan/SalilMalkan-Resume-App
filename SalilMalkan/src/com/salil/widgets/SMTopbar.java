package com.salil.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.salil.R;
import com.salil.SMGlobalHelper;


public class SMTopbar extends LinearLayout
{
	private View mPinkView;
	private View mBlueView;
	private View mGreenView;

	public SMTopbar(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		this.init();
	}

	public SMTopbar(Context context)
	{
		super(context);
		this.init();
	}

	private void init()
	{
		LayoutInflater inflater = (LayoutInflater) this.getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.topbar, this);

		this.mPinkView = this.findViewById(R.id.topbar_pink_view);
		this.mBlueView = this.findViewById(R.id.topbar_blue_view);
		this.mGreenView = this.findViewById(R.id.topbar_green_view);

		this.setViewWidthsEqual();
	}

	public void setViewWidthsEqual()
	{
		int displayWidth = SMGlobalHelper.getScreenWidth(this.getContext());

		int viewWidth = displayWidth / 3;

		this.mPinkView.getLayoutParams().width = viewWidth;
		this.mBlueView.getLayoutParams().width = viewWidth;
		this.mGreenView.getLayoutParams().width = viewWidth;

		this.requestLayout();
	}

	public void setTopbarPink()
	{
		Drawable color = this.getResources().getDrawable(R.drawable.pink);
		this.mPinkView.setBackgroundDrawable(color);
		this.mBlueView.setBackgroundDrawable(color);
		this.mGreenView.setBackgroundDrawable(color);

		this.animateFadeInSequentially(0);
	}

	public void setTopbarBlue()
	{
		Drawable color = this.getResources().getDrawable(R.drawable.blue);
		this.mPinkView.setBackgroundDrawable(color);
		this.mBlueView.setBackgroundDrawable(color);
		this.mGreenView.setBackgroundDrawable(color);

		this.animateFadeInSequentially(0);
	}

	public void setTopbarGreen()
	{
		Drawable color = this.getResources().getDrawable(R.drawable.green);
		this.mPinkView.setBackgroundDrawable(color);
		this.mBlueView.setBackgroundDrawable(color);
		this.mGreenView.setBackgroundDrawable(color);

		this.animateFadeInSequentially(0);
	}

	public void animateFadeInSequentially(int offset)
	{
		Animation pinkViewAnimation = AnimationUtils.loadAnimation(
				this.getContext(), R.anim.anim_fade_in);
		pinkViewAnimation.setDuration(500);
		pinkViewAnimation.setStartOffset(0 + offset);

		Animation blueViewAnimation = AnimationUtils.loadAnimation(
				this.getContext(), R.anim.anim_fade_in);
		blueViewAnimation.setDuration(500);
		blueViewAnimation.setStartOffset(250 + offset);

		Animation greenViewAnimation = AnimationUtils.loadAnimation(
				this.getContext(), R.anim.anim_fade_in);
		greenViewAnimation.setDuration(500);
		greenViewAnimation.setStartOffset(500 + offset);

		Animation orangeViewAnimation = AnimationUtils.loadAnimation(
				this.getContext(), R.anim.anim_fade_in);
		orangeViewAnimation.setDuration(500);
		orangeViewAnimation.setStartOffset(750 + offset);

		this.mPinkView.startAnimation(pinkViewAnimation);
		this.mBlueView.startAnimation(blueViewAnimation);
		this.mGreenView.startAnimation(greenViewAnimation);
	}

}
