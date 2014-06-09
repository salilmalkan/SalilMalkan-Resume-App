package com.salil.work;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.salil.R;
import com.salil.SMBaseActivity;
import com.salil.SMGlobalHelper;
import com.salil.widgets.SMWorkGridButton;
import com.salil.work.apps.SMFrenchGirlsActivity;
import com.salil.work.apps.SMGTBankActivity;
import com.salil.work.apps.SMManillaActivity;
import com.salil.work.apps.SMMinigripActivity;
import com.salil.work.apps.SMPathmappActivity;
import com.salil.work.apps.SMReferLocalAndroidActivity;
import com.salil.work.apps.SMReferLocaliOSActivity;
import com.salil.work.apps.SMRowRowRowActivity;
import com.salil.work.apps.SMVYTLActivity;
import com.salil.work.apps.SMWakanowActivity;

public class SMWorkActivity extends SMBaseActivity
{
	private SMWorkGridButton mWakanowButton;
	private SMWorkGridButton mReferlocaliOSButton;
	private SMWorkGridButton mReferlocalAndroidButton;
	private SMWorkGridButton mVYTLButton;
	private SMWorkGridButton mGTBankButton;
	private SMWorkGridButton mMinigripButton;
	private SMWorkGridButton mRowRowRowButton;
	private SMWorkGridButton mPathmappButton;
	private SMWorkGridButton mFrenchGirlsButton;
	private SMWorkGridButton mManillaButton;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState, R.layout.work);
	}

	@Override
	protected void initViews()
	{
		super.initViews();

		this.mWakanowButton = (SMWorkGridButton) this
				.findViewById(R.id.work_wakanow_button);
		this.mReferlocaliOSButton = (SMWorkGridButton) this
				.findViewById(R.id.work_referlocalios_button);
		this.mReferlocalAndroidButton = (SMWorkGridButton) this
				.findViewById(R.id.work_referlocalandroid_button);
		this.mVYTLButton = (SMWorkGridButton) this
				.findViewById(R.id.work_vytl_button);
		this.mGTBankButton = (SMWorkGridButton) this
				.findViewById(R.id.work_gtbank_button);
		this.mMinigripButton = (SMWorkGridButton) this
				.findViewById(R.id.work_minigrip_button);
		this.mRowRowRowButton = (SMWorkGridButton) this
				.findViewById(R.id.work_rowrowrow_button);
		this.mPathmappButton = (SMWorkGridButton) this
				.findViewById(R.id.work_pathmapp_button);
		this.mFrenchGirlsButton = (SMWorkGridButton) this
				.findViewById(R.id.work_frenchgirls_button);
		this.mManillaButton = (SMWorkGridButton) this
				.findViewById(R.id.work_manilla_button);

		
		this.mTopbar.setTopbarPink();
		this.mActionbar.setTitle("Work");
	}

	@Override
	protected void initAnimations()
	{
		super.initAnimations();

		Animation wakanowAnimation = AnimationUtils.loadAnimation(this,
				R.anim.anim_fade_in_fast);

		Animation referlocaliOSAnimation = AnimationUtils.loadAnimation(this,
				R.anim.anim_fade_in_fast);
		referlocaliOSAnimation.setStartOffset(125);

		Animation referlocalAndroidAnimation = AnimationUtils.loadAnimation(
				this, R.anim.anim_fade_in_fast);
		referlocalAndroidAnimation.setStartOffset(250);

		Animation vytlAnimation = AnimationUtils.loadAnimation(this,
				R.anim.anim_fade_in_fast);
		vytlAnimation.setStartOffset(325);

		Animation gtBankAnimation = AnimationUtils.loadAnimation(this,
				R.anim.anim_fade_in_fast);
		gtBankAnimation.setStartOffset(475);

		Animation minigripAnimation = AnimationUtils.loadAnimation(this,
				R.anim.anim_fade_in_fast);
		minigripAnimation.setStartOffset(600);

		Animation rowrowrowAnimation = AnimationUtils.loadAnimation(this,
				R.anim.anim_fade_in_fast);
		rowrowrowAnimation.setStartOffset(725);

		Animation pathmappAnimation = AnimationUtils.loadAnimation(this,
				R.anim.anim_fade_in_fast);
		pathmappAnimation.setStartOffset(900);
		
		Animation fgAnimation = AnimationUtils.loadAnimation(this,
				R.anim.anim_fade_in_fast);
		pathmappAnimation.setStartOffset(900);
		
		Animation manillaAnimation = AnimationUtils.loadAnimation(this,
				R.anim.anim_fade_in_fast);
		pathmappAnimation.setStartOffset(900);

		this.mWakanowButton.startAnimation(wakanowAnimation);
		this.mReferlocaliOSButton.startAnimation(referlocaliOSAnimation);
		this.mReferlocalAndroidButton
				.startAnimation(referlocalAndroidAnimation);
		this.mVYTLButton.startAnimation(vytlAnimation);
		this.mGTBankButton.startAnimation(gtBankAnimation);
		this.mMinigripButton.startAnimation(minigripAnimation);
		this.mRowRowRowButton.startAnimation(rowrowrowAnimation);
		this.mPathmappButton.startAnimation(pathmappAnimation);
		this.mFrenchGirlsButton.startAnimation(fgAnimation);
		this.mManillaButton.startAnimation(manillaAnimation);

	}

	@Override
	protected void initClickListeners()
	{
		super.initClickListeners();

		this.mWakanowButton.setOnClickListener(this.mWakanowClickListener);
		this.mReferlocaliOSButton
				.setOnClickListener(this.mReferLocaliOSClickListener);
		this.mReferlocalAndroidButton
				.setOnClickListener(this.mReferLocalAndroidClickListener);
		this.mVYTLButton.setOnClickListener(this.mVYTLClickListener);
		this.mGTBankButton.setOnClickListener(this.mGTBankClickListener);
		this.mMinigripButton.setOnClickListener(this.mMinigripClickListener);
		this.mRowRowRowButton.setOnClickListener(this.mRowRowRowClickListener);
		this.mPathmappButton.setOnClickListener(this.mPathmappClickListener);
		this.mFrenchGirlsButton.setOnClickListener(this.mFrenchGirlsClickListener);
		this.mManillaButton.setOnClickListener(this.mManillaClickListener);
	}

	private final OnClickListener mWakanowClickListener = new OnClickListener()
	{
		@Override
		public void onClick(View v)
		{
			Intent i = new Intent(SMWorkActivity.this, SMWakanowActivity.class);
			SMWorkActivity.this.startActivity(i);
		}
	};

	private final OnClickListener mReferLocaliOSClickListener = new OnClickListener()
	{
		@Override
		public void onClick(View v)
		{
			Intent i = new Intent(SMWorkActivity.this,
					SMReferLocaliOSActivity.class);
			SMWorkActivity.this.startActivity(i);
		}
	};

	private final OnClickListener mReferLocalAndroidClickListener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			Intent i = new Intent(SMWorkActivity.this,
					SMReferLocalAndroidActivity.class);
			SMWorkActivity.this.startActivity(i);
		}
	};

	private final OnClickListener mVYTLClickListener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			Intent i = new Intent(SMWorkActivity.this, SMVYTLActivity.class);
			SMWorkActivity.this.startActivity(i);
		}
	};
	private final OnClickListener mGTBankClickListener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			Intent i = new Intent(SMWorkActivity.this, SMGTBankActivity.class);
			SMWorkActivity.this.startActivity(i);
		}
	};

	private final OnClickListener mMinigripClickListener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			Intent i = new Intent(SMWorkActivity.this, SMMinigripActivity.class);
			SMWorkActivity.this.startActivity(i);
		}
	};

	private final OnClickListener mRowRowRowClickListener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			Intent i = new Intent(SMWorkActivity.this,
					SMRowRowRowActivity.class);
			SMWorkActivity.this.startActivity(i);
		}
	};

	private final OnClickListener mPathmappClickListener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			Intent i = new Intent(SMWorkActivity.this, SMPathmappActivity.class);
			SMWorkActivity.this.startActivity(i);
		}
	};
	
	private final OnClickListener mFrenchGirlsClickListener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			Intent i = new Intent(SMWorkActivity.this, SMFrenchGirlsActivity.class);
			SMWorkActivity.this.startActivity(i);
		}
	};
	
	private final OnClickListener mManillaClickListener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			Intent i = new Intent(SMWorkActivity.this, SMManillaActivity.class);
			SMWorkActivity.this.startActivity(i);
		}
	};

}
