package com.salil.work.apps;

import android.os.Bundle;

import com.salil.R;

public class SMVYTLActivity extends SMBaseAppActivity
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
		this.mActionbar.setTitle("VYTL Android");
	}

	@Override
	protected void initImageData()
	{
		super.initImageData();

		this.mImageArrayList.add(Integer.valueOf(R.drawable.vytl1));
		this.mImageArrayList.add(Integer.valueOf(R.drawable.vytl2));
		this.mImageArrayList.add(Integer.valueOf(R.drawable.vytl3));
	}

	@Override
	protected void initSlidingDrawerContent()
	{
		this.mAppTitleString = this.getResources().getString(R.string.vytl);
		this.mAppDescriptionString = this.getResources().getString(
				R.string.vytl_app_description);
		this.mAppResponsibilitiesString = this.getResources().getString(
				R.string.vytl_app_responsibilities);
		super.initSlidingDrawerContent();
	}

	@Override
	protected void initStoreButton()
	{
		super.initStoreButton();
		this.mAppLink = this.getResources().getString(R.string.vytl_app_link);
		this.setStoreButtonToPlay();
	}

}
