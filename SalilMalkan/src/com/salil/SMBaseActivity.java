package com.salil;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import com.salil.widgets.SMActionbar;
import com.salil.widgets.SMTopbar;


public class SMBaseActivity extends Activity
{
	protected SMActionbar mActionbar;
	protected SMTopbar mTopbar;

	/** Called when the activity is first created. */
	public void onCreate(Bundle savedInstanceState, int layoutResource)
	{
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		this.setContentView(layoutResource);
		this.initViews();
		this.initAnimations();
		this.initClickListeners();
	}

	protected void initViews()
	{
		this.mActionbar = (SMActionbar) this.findViewById(R.id.smactionbar);
		this.mTopbar = (SMTopbar) this.findViewById(R.id.smtopbar);
	}

	protected void initAnimations()
	{

	}

	protected void initClickListeners()
	{

	}
}
