package com.salil.work.apps;

import android.os.Bundle;

import com.salil.R;

public class SMPathmappActivity extends SMBaseAppActivity
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
		this.mActionbar.setTitle("Pathmapp");
	}

	@Override
	protected void initImageData()
	{
		super.initImageData();

		this.mImageArrayList.add(Integer.valueOf(R.drawable.pathmapp1));
		this.mImageArrayList.add(Integer.valueOf(R.drawable.pathmapp2));
		this.mImageArrayList.add(Integer.valueOf(R.drawable.pathmapp3));
	}

	@Override
	protected void initSlidingDrawerContent()
	{
		this.mAppTitleString = this.getResources().getString(R.string.pathmapp);
		this.mAppDescriptionString = this.getResources().getString(
				R.string.pathmapp_app_description);
		this.mAppResponsibilitiesString = this.getResources().getString(
				R.string.pathmapp_app_responsibilities);
		super.initSlidingDrawerContent();
	}

	@Override
	protected void initStoreButton()
	{
		super.initStoreButton();
		this.hideStoreButton();
	}

}
