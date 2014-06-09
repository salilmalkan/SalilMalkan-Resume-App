package com.salil.work.apps;

import android.os.Bundle;

import com.salil.R;

public class SMReferLocalAndroidActivity extends SMBaseAppActivity
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
		this.mActionbar.setTitle("ReferLocal Android");
	}

	@Override
	protected void initImageData()
	{
		super.initImageData();

		this.mImageArrayList.add(Integer.valueOf(R.drawable.referlocalandroid1));
		this.mImageArrayList.add(Integer.valueOf(R.drawable.referlocalandroid2));
		this.mImageArrayList.add(Integer.valueOf(R.drawable.referlocalandroid3));
		this.mImageArrayList.add(Integer.valueOf(R.drawable.referlocalandroid4));
		this.mImageArrayList.add(Integer.valueOf(R.drawable.referlocalandroid5));
	}

	@Override
	protected void initSlidingDrawerContent()
	{
		this.mAppTitleString = this.getResources().getString(
				R.string.referlocalandroid);
		this.mAppDescriptionString = this.getResources().getString(
				R.string.referlocalandroid_app_description);
		this.mAppResponsibilitiesString = this.getResources().getString(
				R.string.referlocalandroid_app_responsibilities);
		super.initSlidingDrawerContent();
	}

	@Override
	protected void initStoreButton()
	{
		super.initStoreButton();
		this.mAppLink = this.getResources().getString(
				R.string.referlocalandroid_app_link);
		this.setStoreButtonToPlay();
	}

}
