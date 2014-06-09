package com.salil.work.apps;

import android.os.Bundle;

import com.salil.R;

public class SMFrenchGirlsActivity extends SMBaseAppActivity
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
		this.mActionbar.setTitle("French Girls iOS");
	}

	@Override
	protected void initImageData()
	{
		super.initImageData();

		this.mImageArrayList.add(Integer.valueOf(R.drawable.frenchgirlsicon));
		this.mImageArrayList.add(Integer.valueOf(R.drawable.frenchgirls1));
		this.mImageArrayList.add(Integer.valueOf(R.drawable.frenchgirls2));
	}

	@Override
	protected void initSlidingDrawerContent()
	{
		this.mAppTitleString = this.getResources().getString(R.string.frenchgirls);
		this.mAppDescriptionString = this.getResources().getString(
				R.string.frenchgirls_app_description);
		this.mAppResponsibilitiesString = this.getResources().getString(
				R.string.frenchgirls_app_responsibilities);

		super.initSlidingDrawerContent();
	}

	@Override
	protected void initStoreButton()
	{
		super.initStoreButton();
		this.mAppLink = this.getResources()
				.getString(R.string.frenchgirls_app_link);
		this.setStoreButtonToiOS();
	}

}
