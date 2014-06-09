package com.salil.work.apps;

import android.os.Bundle;

import com.salil.R;

public class SMRowRowRowActivity extends SMBaseAppActivity
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
		this.mActionbar.setTitle("Row Row Row Remote");
	}

	@Override
	protected void initImageData()
	{
		super.initImageData();

		this.mImageArrayList.add(Integer.valueOf(R.drawable.rowrowrow1));
		this.mImageArrayList.add(Integer.valueOf(R.drawable.rowrowrow2));
		this.mImageArrayList.add(Integer.valueOf(R.drawable.rowrowrow3));
		this.mImageArrayList.add(Integer.valueOf(R.drawable.rowrowrow4));
	}

	@Override
	protected void initSlidingDrawerContent()
	{
		this.mAppTitleString = this.getResources()
				.getString(R.string.rowrowrow);
		this.mAppDescriptionString = this.getResources().getString(
				R.string.rowrowrow_app_description);
		this.mAppResponsibilitiesString = this.getResources().getString(
				R.string.rowrowrow_app_responsibilities);
		super.initSlidingDrawerContent();
	}

	@Override
	protected void initStoreButton()
	{
		super.initStoreButton();
		this.mAppLink = this.getResources().getString(
				R.string.rowrowrow_app_link);
		this.setStoreButtonToiOS();
		this.mStoreButton.setImageResource(R.drawable.rowrowrow);
	}

}
