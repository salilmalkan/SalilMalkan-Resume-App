package com.salil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.salil.contact.SMContactActivity;
import com.salil.timeline.SMTimelineActivity;
import com.salil.widgets.SMTopbar;
import com.salil.work.SMWorkActivity;


public class SMMainActivity extends SMBaseActivity
{
	Button mWorkButton;
	Button mTimelineButton;
	Button mContactButton;
	ScrollView mScrollView;
	RelativeLayout mLogoContainer;
	SMTopbar mTopbar;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState, R.layout.menu);
		this.initViews();
		this.initAnimations();
		this.initClickListeners();
	}

	@Override
	protected void initViews()
	{
		super.initViews();

		this.mScrollView = (ScrollView) this.findViewById(R.id.menu_scollview);
		this.mWorkButton = (Button) this.findViewById(R.id.menu_work_button);
		this.mTimelineButton = (Button) this
				.findViewById(R.id.menu_timeline_button);
		this.mContactButton = (Button) this
				.findViewById(R.id.menu_contact_button);
		this.mLogoContainer = (RelativeLayout) this
				.findViewById(R.id.menu_logo_container);
		this.mTopbar = (SMTopbar) this.findViewById(R.id.smtopbar);

		this.mActionbar.hideBackArrow();
	}
	
	@Override
	protected void initAnimations()
	{
		super.initAnimations();

		Animation workButtonAnimation = AnimationUtils.loadAnimation(this,
				R.anim.anim_right_to_left);

		Animation educationButtonAnimation = AnimationUtils.loadAnimation(this,
				R.anim.anim_right_to_left);
		educationButtonAnimation.setStartOffset(125);

		Animation contactButtonAnimation = AnimationUtils.loadAnimation(this,
				R.anim.anim_right_to_left);
		contactButtonAnimation.setStartOffset(250);

		Animation logoAnimation = AnimationUtils.loadAnimation(this,
				R.anim.anim_fade_in);
		logoAnimation.setStartOffset(775);

		this.mWorkButton.startAnimation(workButtonAnimation);
		this.mTimelineButton.startAnimation(educationButtonAnimation);
		this.mContactButton.startAnimation(contactButtonAnimation);
		this.mLogoContainer.startAnimation(logoAnimation);

		this.mTopbar.animateFadeInSequentially(0);
	}

	@Override
	protected void initClickListeners()
	{
		this.mWorkButton.setOnClickListener(this.mWorkClickListener);
		this.mTimelineButton.setOnClickListener(this.mTimelineClickListener);
		this.mContactButton.setOnClickListener(this.mContactClickListener);
	}

	private final OnClickListener mWorkClickListener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			Intent i = new Intent(SMMainActivity.this, SMWorkActivity.class);
			SMMainActivity.this.startActivity(i);
		}
	};

	private final OnClickListener mTimelineClickListener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			Intent i = new Intent(SMMainActivity.this, SMTimelineActivity.class);
			SMMainActivity.this.startActivity(i);
		}
	};

	private final OnClickListener mContactClickListener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			Intent i = new Intent(SMMainActivity.this, SMContactActivity.class);
			SMMainActivity.this.startActivity(i);
		}
	};
}