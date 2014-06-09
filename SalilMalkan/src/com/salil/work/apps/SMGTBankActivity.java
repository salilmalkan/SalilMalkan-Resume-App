package com.salil.work.apps;

import android.os.Bundle;

import com.salil.R;

public class SMGTBankActivity extends SMBaseAppActivity
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
		this.mActionbar.setTitle("GTBank iOS");
	}

	@Override
	protected void initImageData()
	{
		super.initImageData();

		this.mImageArrayList.add(Integer.valueOf(R.drawable.gtbank1));
		this.mImageArrayList.add(Integer.valueOf(R.drawable.gtbank2));
		this.mImageArrayList.add(Integer.valueOf(R.drawable.gtbank3));
		this.mImageArrayList.add(Integer.valueOf(R.drawable.gtbank4));
	}

	@Override
	protected void initSlidingDrawerContent()
	{
		this.mAppTitleString = this.getResources().getString(R.string.gtbank);
		this.mAppDescriptionString = this.getResources().getString(
				R.string.gtbank_app_description);
		this.mAppResponsibilitiesString = this.getResources().getString(
				R.string.gtbank_app_responsibilities);
		super.initSlidingDrawerContent();
	}

	@Override
	protected void initStoreButton()
	{
		super.initStoreButton();
		this.hideStoreButton();
	}

}
