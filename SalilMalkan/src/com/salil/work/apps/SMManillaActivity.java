package com.salil.work.apps;

import android.os.Bundle;

import com.salil.R;

public class SMManillaActivity extends SMBaseAppActivity
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
		this.mActionbar.setTitle("Manilla Android");
	}

	@Override
	protected void initImageData()
	{
		super.initImageData();

		this.mImageArrayList.add(Integer.valueOf(R.drawable.manillaicon));
		this.mImageArrayList.add(Integer.valueOf(R.drawable.manilla1));
		this.mImageArrayList.add(Integer.valueOf(R.drawable.manilla2));
		this.mImageArrayList.add(Integer.valueOf(R.drawable.manilla3));
	}

	@Override
	protected void initSlidingDrawerContent()
	{
		this.mAppTitleString = this.getResources().getString(R.string.manilla);
		this.mAppDescriptionString = this.getResources().getString(
				R.string.manilla_app_description);
		this.mAppResponsibilitiesString = this.getResources().getString(
				R.string.manilla_app_responsibilities);

		super.initSlidingDrawerContent();
	}

	@Override
	protected void initStoreButton()
	{
		super.initStoreButton();
		this.mAppLink = this.getResources()
				.getString(R.string.manilla);
		this.setStoreButtonToPlay();
	}

}
