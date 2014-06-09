package com.salil.work.apps;

import android.os.Bundle;

import com.salil.R;

public class SMWakanowActivity extends SMBaseAppActivity
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
		this.mActionbar.setTitle("Wakanow Android");
	}

	@Override
	protected void initImageData()
	{
		super.initImageData();

		this.mImageArrayList.add(Integer.valueOf(R.drawable.wakanow1));
		this.mImageArrayList.add(Integer.valueOf(R.drawable.wakanow2));
		this.mImageArrayList.add(Integer.valueOf(R.drawable.wakanow3));
	}

	@Override
	protected void initSlidingDrawerContent()
	{
		this.mAppTitleString = this.getResources().getString(R.string.wakanow);
		this.mAppDescriptionString = this.getResources().getString(
				R.string.wakanow_app_description);
		this.mAppResponsibilitiesString = this.getResources().getString(
				R.string.wakanow_app_responsibilities);

		super.initSlidingDrawerContent();
	}

	@Override
	protected void initStoreButton()
	{
		super.initStoreButton();
		this.mAppLink = this.getResources()
				.getString(R.string.wakanow_app_link);
		this.setStoreButtonToPlay();
	}

}
