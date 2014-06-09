package com.salil.work.apps;

import android.os.Bundle;

import com.salil.R;

public class SMMinigripActivity extends SMBaseAppActivity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
	}

	@Override
	protected void initViews()
	{
		super.initViews();
		this.mActionbar.setTitle("Minigrip Android");
	}

	@Override
	protected void initImageData()
	{
		super.initImageData();

		this.mImageArrayList.add(Integer.valueOf(R.drawable.minigrip1));
		this.mImageArrayList.add(Integer.valueOf(R.drawable.minigrip2));
		this.mImageArrayList.add(Integer.valueOf(R.drawable.minigrip3));
		this.mImageArrayList.add(Integer.valueOf(R.drawable.minigrip4));
	}

	@Override
	protected void initSlidingDrawerContent()
	{
		this.mAppTitleString = this.getResources().getString(R.string.minigrip);
		this.mAppDescriptionString = this.getResources().getString(
				R.string.minigrip_app_description);
		this.mAppResponsibilitiesString = this.getResources().getString(
				R.string.minigrip_app_responsibilities);
		super.initSlidingDrawerContent();
	}

	@Override
	protected void initStoreButton()
	{
		super.initStoreButton();
		this.mAppLink = this.getResources().getString(
				R.string.minigrip_app_link);
		this.setStoreButtonToPlay();
	}

}
