package com.salil.work.apps;

import java.util.ArrayList;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SlidingDrawer;
import android.widget.TextView;

import com.salil.R;
import com.salil.SMBaseActivity;

public class SMBaseAppActivity extends SMBaseActivity
{
	protected ArrayList<Integer> mImageArrayList;
	protected Gallery mGallery;
	protected SMAppGalleryAdapter mGalleryAdapter;
	private LinearLayout mHeaderLayout;
	private SlidingDrawer mSlidingDrawer;
	private LinearLayout mSlidingDrawerContent;

	private TextView mAppTitle;
	private TextView mAppDescription;
	private TextView mAppResponsibilities;

	protected ImageView mStoreButton;

	protected String mAppTitleString;
	protected String mAppDescriptionString;
	protected String mAppResponsibilitiesString;
	protected String mAppLink;

	private Animation mFadeInAnimation;
	private Animation mFadeOutAnimation;

	private boolean mIsAnimating;

	private boolean mIsOverlayVisible = true;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState, R.layout.app);
		this.initImageData();
		this.initGallery();
		this.initSlidingDrawerContent();
		this.initStoreButton();
	}

	@Override
	protected void initViews()
	{
		super.initViews();

		this.mGallery = (Gallery) this.findViewById(R.id.app_gallery);
		this.mHeaderLayout = (LinearLayout) this
				.findViewById(R.id.app_headerContent);
		this.mSlidingDrawer = (SlidingDrawer) this
				.findViewById(R.id.app_slidingDrawer);

		this.mAppTitle = (TextView) this.findViewById(R.id.app_title_text);
		this.mAppDescription = (TextView) this
				.findViewById(R.id.app_description_text);
		this.mAppResponsibilities = (TextView) this
				.findViewById(R.id.app_responsibilities_text);
		this.mStoreButton = (ImageView) this
				.findViewById(R.id.app_store_button);
		this.mSlidingDrawerContent = (LinearLayout) this
				.findViewById(R.id.app_drawerContent);
		this.mTopbar.setTopbarPink();
	}

	@Override
	protected void initClickListeners()
	{
		super.initClickListeners();
		this.mSlidingDrawerContent.setOnClickListener(this.mEmptyClickListener);

	}

	protected void initImageData()
	{
		this.mImageArrayList = new ArrayList<Integer>();
	}

	protected void initGallery()
	{
		this.mGalleryAdapter = new SMAppGalleryAdapter(this,
				this.mImageArrayList);
		this.mGallery.setAdapter(this.mGalleryAdapter);
		this.mGallery.setOnItemClickListener(this.mGalleryClickListener);
	}

	private void hideOverlay()
	{
		if (this.mFadeOutAnimation == null)
		{
			this.mFadeOutAnimation = AnimationUtils.loadAnimation(this,
					R.anim.anim_fade_out);
			this.mFadeOutAnimation.setFillAfter(true);
			this.mFadeOutAnimation
					.setAnimationListener(this.mFadeAnimationListener);
		}
		if (!this.mIsAnimating)
		{
			this.mHeaderLayout.startAnimation(this.mFadeOutAnimation);
			this.mSlidingDrawer.startAnimation(this.mFadeOutAnimation);
			if (this.mSlidingDrawer.isOpened())
			{
				this.mSlidingDrawer.animateClose();
			}
		}
		this.mIsOverlayVisible = false;
	}

	protected void initSlidingDrawerContent()
	{
		this.mAppTitle.setText(this.mAppTitleString);
		this.mAppDescription.setText(this.mAppDescriptionString);
		this.mAppResponsibilities.setText(this.mAppResponsibilitiesString);
	}

	protected void initStoreButton()
	{

	}

	protected void hideStoreButton()
	{
		this.mStoreButton.setVisibility(View.GONE);
	}

	protected void setStoreButtonToiOS()
	{
		this.mStoreButton.setImageResource(R.drawable.appstore_logo);
		this.mStoreButton.setOnClickListener(this.mAppStoreClickListener);
	}

	protected void setStoreButtonToPlay()
	{
		this.mStoreButton.setImageResource(R.drawable.google_play_logo);
		this.mStoreButton.setOnClickListener(this.mPlayClickListener);
	}

	private final OnClickListener mAppStoreClickListener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			SMBaseAppActivity.this.startActivity(new Intent(Intent.ACTION_VIEW,
					Uri.parse(SMBaseAppActivity.this.mAppLink)));
		}
	};

	private final OnClickListener mPlayClickListener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			try
			{
				SMBaseAppActivity.this.startActivity(new Intent(
						Intent.ACTION_VIEW, Uri.parse("market://details?id="
								+ SMBaseAppActivity.this.mAppLink)));
			}
			catch (android.content.ActivityNotFoundException anfe)
			{
				SMBaseAppActivity.this
						.startActivity(new Intent(
								Intent.ACTION_VIEW,
								Uri.parse("http://play.google.com/store/apps/details?id="
										+ SMBaseAppActivity.this.mAppLink)));
			}
		}
	};

	private void showOverlay()
	{
		if (this.mFadeInAnimation == null)
		{
			this.mFadeInAnimation = AnimationUtils.loadAnimation(this,
					R.anim.anim_fade_in);
			this.mFadeInAnimation.setFillAfter(true);
			this.mFadeInAnimation
					.setAnimationListener(this.mFadeAnimationListener);
		}
		if (!this.mIsAnimating)
		{
			this.mHeaderLayout.startAnimation(this.mFadeInAnimation);
			this.mSlidingDrawer.startAnimation(this.mFadeInAnimation);
		}
		this.mIsOverlayVisible = true;
	}

	private final AnimationListener mFadeAnimationListener = new AnimationListener()
	{

		@Override
		public void onAnimationStart(Animation animation)
		{
			SMBaseAppActivity.this.mIsAnimating = true;
			if (SMBaseAppActivity.this.mIsOverlayVisible)
			{
				SMBaseAppActivity.this.mActionbar.setEnabled(true);
				SMBaseAppActivity.this.mSlidingDrawer.setEnabled(true);
				SMBaseAppActivity.this.mSlidingDrawer.close();
			}
		}

		@Override
		public void onAnimationRepeat(Animation animation)
		{
			// TODO Auto-generated method stub

		}

		@Override
		public void onAnimationEnd(Animation animation)
		{
			SMBaseAppActivity.this.mIsAnimating = false;
			if (!SMBaseAppActivity.this.mIsOverlayVisible)
			{
				SMBaseAppActivity.this.mActionbar.setEnabled(false);
				SMBaseAppActivity.this.mSlidingDrawer.setEnabled(true);
			}
		}
	};

	private final OnItemClickListener mGalleryClickListener = new OnItemClickListener()
	{
		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
				long arg3)
		{
			if (SMBaseAppActivity.this.mIsOverlayVisible)
			{
				SMBaseAppActivity.this.hideOverlay();

			}
			else
			{
				SMBaseAppActivity.this.showOverlay();
			}
		}
	};

	private final OnClickListener mEmptyClickListener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{

		}
	};
}
