package com.salil.contact;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.salil.R;
import com.salil.SMBaseActivity;


public class SMContactActivity extends SMBaseActivity
{
	private Button mCallButton;
	private Button mEmailButton;
	private Button mHireButton;

	private ImageView mProfileImageView;

	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState, R.layout.contact);
	}

	@Override
	protected void initViews()
	{
		super.initViews();
		this.mCallButton = (Button) this.findViewById(R.id.contact_call_button);
		this.mEmailButton = (Button) this
				.findViewById(R.id.contact_email_button);
		this.mHireButton = (Button) this.findViewById(R.id.contact_hire_button);
		this.mProfileImageView = (ImageView) this
				.findViewById(R.id.contact_imageview);
		this.mTopbar.setTopbarGreen();
		this.mActionbar.setTitle("Contact");
	}

	@Override
	protected void initClickListeners()
	{
		super.initClickListeners();
		this.mCallButton.setOnClickListener(this.mCallClickListener);
		this.mEmailButton.setOnClickListener(this.mEmailClickListener);
		this.mHireButton.setOnClickListener(this.mHireClickListener);
	}

	@Override
	protected void initAnimations()
	{
		super.initAnimations();

		Animation callButtonAnimation = AnimationUtils.loadAnimation(this,
				R.anim.anim_move_top_down);
		Animation emailButtonAnimation = AnimationUtils.loadAnimation(this,
				R.anim.anim_move_top_down);
		Animation hireButtonAnimation = AnimationUtils.loadAnimation(this,
				R.anim.anim_move_top_down);
		Animation profileImageAnimation = AnimationUtils.loadAnimation(this,
				R.anim.anim_fade_in);

		emailButtonAnimation.setStartOffset(250);
		hireButtonAnimation.setStartOffset(500);
		profileImageAnimation.setStartOffset(1250);

		this.mCallButton.startAnimation(callButtonAnimation);
		this.mEmailButton.startAnimation(emailButtonAnimation);
		this.mHireButton.startAnimation(hireButtonAnimation);
		this.mProfileImageView.startAnimation(profileImageAnimation);
	}

	private final OnClickListener mCallClickListener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			if (SMContactActivity.this.isDeviceAPhone())
			{
				String number = SMContactActivity.this.getResources()
						.getString(R.string.call_intent_string);
				Intent callIntent = new Intent(Intent.ACTION_CALL,
						Uri.parse(number));
				SMContactActivity.this.startActivity(callIntent);
			}
			else
			{
				AlertDialog alertDialog = new AlertDialog.Builder(
						SMContactActivity.this).create();
				alertDialog.setTitle(SMContactActivity.this.getResources()
						.getString(R.string.call_alert_title));
				alertDialog.setMessage(SMContactActivity.this.getResources()
						.getString(R.string.call_alert_string));
			}
		}
	};

	private final OnClickListener mEmailClickListener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			Intent i = new Intent(Intent.ACTION_SEND);
			i.putExtra(android.content.Intent.EXTRA_EMAIL,
					new String[] { SMContactActivity.this.getResources()
							.getString(R.string.email) });
			i.putExtra(
					android.content.Intent.EXTRA_SUBJECT,
					SMContactActivity.this.getResources().getString(
							R.string.email_subject));
			i.putExtra(
					android.content.Intent.EXTRA_TEXT,
					SMContactActivity.this.getResources().getString(
							R.string.email_body));
			i.setType("plain/text");
			SMContactActivity.this.startActivity(Intent.createChooser(
					i,
					SMContactActivity.this.getResources().getString(
							R.string.email_alert_title)));
		}
	};

	private final OnClickListener mHireClickListener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			Intent i = new Intent(Intent.ACTION_SEND);
			i.putExtra(android.content.Intent.EXTRA_EMAIL,
					new String[] { SMContactActivity.this.getResources()
							.getString(R.string.email) });
			i.putExtra(
					android.content.Intent.EXTRA_SUBJECT,
					SMContactActivity.this.getResources().getString(
							R.string.hire_subject));
			i.putExtra(
					android.content.Intent.EXTRA_TEXT,
					SMContactActivity.this.getResources().getString(
							R.string.hire_body));
			i.setType("plain/text");
			SMContactActivity.this.startActivity(Intent.createChooser(
					i,
					SMContactActivity.this.getResources().getString(
							R.string.hire_me_now)));
		}
	};

	private boolean isDeviceAPhone()
	{
		TelephonyManager manager = (TelephonyManager) this
				.getSystemService(Context.TELEPHONY_SERVICE);
		if (manager.getPhoneType() == TelephonyManager.PHONE_TYPE_NONE)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
}
