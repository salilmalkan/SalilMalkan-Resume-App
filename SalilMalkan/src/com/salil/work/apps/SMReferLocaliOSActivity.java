package com.salil.work.apps;

import android.os.Bundle;

import com.salil.R;

public class SMReferLocaliOSActivity extends SMBaseAppActivity
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
		this.mActionbar.setTitle("ReferLocal iOS");
	}

	@Override
	protected void initImageData()
	{
		super.initImageData();

		this.mImageArrayList.add(Integer.valueOf(R.drawable.referlocalios1));
		this.mImageArrayList.add(Integer.valueOf(R.drawable.referlocalios2));
		this.mImageArrayList.add(Integer.valueOf(R.drawable.referlocalios3));
	}

	@Override
	protected void initSlidingDrawerContent()
	{
		this.mAppTitleString = this.getResources().getString(
				R.string.referlocalios);
		this.mAppDescriptionString = this.getResources().getString(
				R.string.referlocalios_app_description);
		this.mAppResponsibilitiesString = this.getResources().getString(
				R.string.referlocalios_app_responsibilities);
		super.initSlidingDrawerContent();
	}

	@Override
	protected void initStoreButton()
	{
		super.initStoreButton();
		this.mAppLink = this.getResources().getString(
				R.string.referlocalios_app_link);
		this.setStoreButtonToiOS();
	}

}
