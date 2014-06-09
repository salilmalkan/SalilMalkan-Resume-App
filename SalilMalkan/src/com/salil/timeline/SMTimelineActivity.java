package com.salil.timeline;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.salil.R;
import com.salil.SMBaseActivity;
import com.salil.SMGlobalHelper;


public class SMTimelineActivity extends SMBaseActivity
{
	private RelativeLayout mTimelineContainer;
	private RelativeLayout mYearsContainer;
	private RelativeLayout mTimelineInformationContainer;

	private Animation mTimelineAnimationLeft;
	private Animation mTimelineAnimationRight;
	private Animation mYearsFadeInAnimation;
	private Animation mYearsFadeOutAnimation;
	private Animation mInformationFadeInAnimation;
	private Animation mInformationFadeOutAnimation;
	private Animation mInformationChangeAnimation1;
	private Animation mInformationChangeAnimation2;

	private ImageView mPoint1;
	private ImageView mPoint2;
	private ImageView mPoint3;
	private ImageView mPoint4;
	private ImageView mPoint5;
	private ImageView mPoint6;
	private ImageView mPoint7;
	private ImageView mPoint8;

	private TextView mYearText;
	private TextView mDetailsText;
	private ImageView mTimelineImage;

	private int mSelectedPoint;

	private boolean mIsTimelineOpen = false;
	private boolean mIsAnimating = false;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState, R.layout.timeline);
	}

	@Override
	protected void initViews()
	{
		super.initViews();

		this.mTimelineContainer = (RelativeLayout) this
				.findViewById(R.id.timeline_line_layout);
		this.mYearsContainer = (RelativeLayout) this
				.findViewById(R.id.timeline_years_layout);
		this.mTimelineInformationContainer = (RelativeLayout) this
				.findViewById(R.id.timeline_information_layout);
		this.mTimelineInformationContainer.getLayoutParams().width = (int) (SMGlobalHelper
				.getScreenWidth(this) * .75);

		this.mPoint1 = (ImageView) this.findViewById(R.id.timeline_point_1);
		this.mPoint2 = (ImageView) this.findViewById(R.id.timeline_point_2);
		this.mPoint3 = (ImageView) this.findViewById(R.id.timeline_point_3);
		this.mPoint4 = (ImageView) this.findViewById(R.id.timeline_point_4);
		this.mPoint5 = (ImageView) this.findViewById(R.id.timeline_point_5);
		this.mPoint6 = (ImageView) this.findViewById(R.id.timeline_point_6);
		this.mPoint7 = (ImageView) this.findViewById(R.id.timeline_point_7);
		this.mPoint8 = (ImageView) this.findViewById(R.id.timeline_point_8);
		
		this.mYearText = (TextView) this.findViewById(R.id.timeline_year);
		this.mDetailsText = (TextView) this.findViewById(R.id.timeline_details);
		this.mTimelineImage = (ImageView) this
				.findViewById(R.id.timeline_image);
		this.mTopbar.setTopbarBlue();
		this.mActionbar.setTitle("Timeline");
	}

	@Override
	protected void initClickListeners()
	{
		super.initClickListeners();
		// this.mTimelineContainer.setOnClickListener(this.mTimelineClickListener);
		this.mPoint1.setOnClickListener(this.mPointClickListener);
		this.mPoint2.setOnClickListener(this.mPointClickListener);
		this.mPoint3.setOnClickListener(this.mPointClickListener);
		this.mPoint4.setOnClickListener(this.mPointClickListener);
		this.mPoint5.setOnClickListener(this.mPointClickListener);
		this.mPoint6.setOnClickListener(this.mPointClickListener);
		this.mPoint7.setOnClickListener(this.mPointClickListener);
		this.mPoint8.setOnClickListener(this.mPointClickListener);
	}

	@Override
	protected void initAnimations()
	{
		super.initAnimations();
		this.mTimelineAnimationLeft = new SMTimelineOpenAnimation(this,
				this.mTimelineContainer);
		this.mTimelineAnimationLeft.setFillEnabled(true);
		this.mTimelineAnimationLeft
				.setAnimationListener(this.mOpenTimelineAnimationListener);

		this.mTimelineAnimationRight = new SMTimelineCloseAnimation(this,
				this.mTimelineContainer);
		this.mTimelineAnimationRight
				.setAnimationListener(this.mCloseTimelineAnimationListener);

		this.mYearsFadeInAnimation = AnimationUtils.loadAnimation(this,
				R.anim.anim_fade_in);
		this.mYearsFadeInAnimation.setFillAfter(true);
		this.mYearsFadeInAnimation.setDuration(500);

		this.mYearsFadeOutAnimation = AnimationUtils.loadAnimation(this,
				R.anim.anim_fade_out);
		this.mYearsFadeOutAnimation.setFillAfter(true);
		this.mYearsFadeOutAnimation.setDuration(500);

		this.mInformationFadeInAnimation = AnimationUtils.loadAnimation(this,
				R.anim.anim_fade_in);
		this.mInformationFadeInAnimation
				.setAnimationListener(this.mInformationFadeInAnimationListener);
		this.mInformationFadeInAnimation.setFillAfter(true);
		this.mInformationFadeInAnimation.setDuration(500);

		this.mInformationFadeOutAnimation = AnimationUtils.loadAnimation(this,
				R.anim.anim_fade_out);
		this.mInformationFadeOutAnimation
				.setAnimationListener(this.mInformationFadeOutAnimationListener);
		this.mInformationFadeOutAnimation.setFillAfter(true);
		this.mInformationFadeOutAnimation.setDuration(500);

		this.mInformationChangeAnimation1 = AnimationUtils.loadAnimation(this,
				R.anim.anim_fade_out);
		this.mInformationChangeAnimation1
				.setAnimationListener(this.mInformationChangeListener);
		this.mInformationChangeAnimation1.setDuration(500);

		this.mInformationChangeAnimation2 = AnimationUtils.loadAnimation(this,
				R.anim.anim_fade_in);
		this.mInformationChangeAnimation2.setDuration(500);

		Animation instantFadeAnimation = AnimationUtils.loadAnimation(this,
				R.anim.anim_fade_out);
		instantFadeAnimation.setDuration(0);
		instantFadeAnimation.setFillAfter(true);
		this.mTimelineInformationContainer.startAnimation(instantFadeAnimation);

	}

	private void openTimeline()
	{
		this.mTimelineContainer.startAnimation(this.mTimelineAnimationLeft);
		this.mYearsContainer.startAnimation(this.mYearsFadeOutAnimation);
		this.mIsTimelineOpen = true;
	}

	private void setInformationValues()
	{
		switch (this.mSelectedPoint)
		{
		case 1:
			this.mYearText.setText(this.getResources().getString(
					R.string.timelinepoint1_year));
			this.mDetailsText.setText(this.getResources().getString(
					R.string.timelinepoint1_text));
			this.mTimelineImage.setImageResource(R.drawable.indianflag);
			this.mTimelineInformationContainer
					.setBackgroundResource(R.drawable.timeline_bordered_bg_green);
			break;
		case 2:
			this.mYearText.setText(this.getResources().getString(
					R.string.timelinepoint2_year));
			this.mDetailsText.setText(this.getResources().getString(
					R.string.timelinepoint2_text));
			this.mTimelineImage.setImageResource(R.drawable.plane);
			this.mTimelineInformationContainer
					.setBackgroundResource(R.drawable.timeline_bordered_bg_blue1);
			break;
		case 3:
			this.mYearText.setText(this.getResources().getString(
					R.string.timelinepoint3_year));
			this.mDetailsText.setText(this.getResources().getString(
					R.string.timelinepoint3_text));
			this.mTimelineImage.setImageResource(R.drawable.imac);
			this.mTimelineInformationContainer
					.setBackgroundResource(R.drawable.timeline_bordered_bg_blue2);
			break;
		case 4:
			this.mYearText.setText(this.getResources().getString(
					R.string.timelinepoint4_year));
			this.mDetailsText.setText(this.getResources().getString(
					R.string.timelinepoint4_text));
			this.mTimelineImage.setImageResource(R.drawable.mario);
			this.mTimelineInformationContainer
					.setBackgroundResource(R.drawable.timeline_bordered_bg_purple);
			break;
		case 5:
			this.mYearText.setText(this.getResources().getString(
					R.string.timelinepoint5_year));
			this.mDetailsText.setText(this.getResources().getString(
					R.string.timelinepoint5_text));
			this.mTimelineImage.setImageResource(R.drawable.psu);
			this.mTimelineInformationContainer
					.setBackgroundResource(R.drawable.timeline_bordered_bg_red);
			break;
		case 6:
			this.mYearText.setText(this.getResources().getString(
					R.string.timelinepoint6_year));
			this.mDetailsText.setText(this.getResources().getString(
					R.string.timelinepoint6_text));
			this.mTimelineImage.setImageResource(R.drawable.graduation);
			this.mTimelineInformationContainer
					.setBackgroundResource(R.drawable.timeline_bordered_bg_orange);
			break;
		case 7:
			this.mYearText.setText(this.getResources().getString(
					R.string.timelinepoint7_year));
			this.mDetailsText.setText(this.getResources().getString(
					R.string.timelinepoint7_text));
			this.mTimelineImage.setImageResource(R.drawable.sanfrancisco);
			this.mTimelineInformationContainer
					.setBackgroundResource(R.drawable.timeline_bordered_bg_yellow);
			break;
		case 8:
			this.mYearText.setText(this.getResources().getString(
					R.string.timelinepoint8_year));
			this.mDetailsText.setText(this.getResources().getString(
					R.string.timelinepoint8_text));
			this.mTimelineImage.setImageResource(R.drawable.monkey);
			this.mTimelineInformationContainer
					.setBackgroundResource(R.drawable.timeline_bordered_bg_lightgreen);
			break;
		}
	}

	private void resetLastSelectedPointImage(int lastSelectedPoint)
	{
		switch (lastSelectedPoint)
		{
		case 1:
			this.mPoint1
					.setImageResource(R.drawable.timeline_circle_green_unselected);
			break;
		case 2:
			this.mPoint2
					.setImageResource(R.drawable.timeline_circle_blue1_unselected);
			break;
		case 3:
			this.mPoint3
					.setImageResource(R.drawable.timeline_circle_blue2_unselected);
			break;
		case 4:
			this.mPoint4
					.setImageResource(R.drawable.timeline_circle_purple_unselected);
			break;
		case 5:
			this.mPoint5
					.setImageResource(R.drawable.timeline_circle_red_unselected);
			break;
		case 6:
			this.mPoint6
					.setImageResource(R.drawable.timeline_circle_orange_unselected);
			break;
		case 7:
			this.mPoint7
					.setImageResource(R.drawable.timeline_circle_yellow_unselected);
			break;
		case 8:
			this.mPoint7
					.setImageResource(R.drawable.timeline_circle_lightgreen_unselected);
			break;
		}
	}

	private void setCurrentSelectedPointImage()
	{
		switch (this.mSelectedPoint)
		{
		case 1:
			this.mPoint1.setImageResource(R.drawable.timeline_circle_green);

			break;
		case 2:
			this.mPoint2.setImageResource(R.drawable.timeline_circle_blue1);

			break;
		case 3:
			this.mPoint3.setImageResource(R.drawable.timeline_circle_blue2);

			break;
		case 4:
			this.mPoint4.setImageResource(R.drawable.timeline_circle_purple);

			break;
		case 5:
			this.mPoint5.setImageResource(R.drawable.timeline_circle_red);

			break;
		case 6:
			this.mPoint6.setImageResource(R.drawable.timeline_circle_orange);

			break;
		case 7:
			this.mPoint7.setImageResource(R.drawable.timeline_circle_yellow);
			break;
		case 8:
			this.mPoint8.setImageResource(R.drawable.timeline_circle_lightgreen);
		}
	}

	private final OnClickListener mPointClickListener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			if (SMTimelineActivity.this.mIsAnimating)
			{
				return;
			}
			int lastSelectedPoint = SMTimelineActivity.this.mSelectedPoint;
			if (v.getId() == SMTimelineActivity.this.mPoint1.getId())
			{
				SMTimelineActivity.this.mSelectedPoint = 1;
			}
			else if (v.getId() == SMTimelineActivity.this.mPoint2.getId())
			{
				SMTimelineActivity.this.mSelectedPoint = 2;
			}
			else if (v.getId() == SMTimelineActivity.this.mPoint3.getId())
			{
				SMTimelineActivity.this.mSelectedPoint = 3;
			}
			else if (v.getId() == SMTimelineActivity.this.mPoint4.getId())
			{
				SMTimelineActivity.this.mSelectedPoint = 4;
			}
			else if (v.getId() == SMTimelineActivity.this.mPoint5.getId())
			{
				SMTimelineActivity.this.mSelectedPoint = 5;
			}
			else if (v.getId() == SMTimelineActivity.this.mPoint6.getId())
			{
				SMTimelineActivity.this.mSelectedPoint = 6;
			}
			else if (v.getId() == SMTimelineActivity.this.mPoint7.getId())
			{
				SMTimelineActivity.this.mSelectedPoint = 7;
			}
			else if(v.getId() == SMTimelineActivity.this.mPoint8.getId())
			{
				SMTimelineActivity.this.mSelectedPoint = 8;
			}
			
			if (!SMTimelineActivity.this.mIsTimelineOpen)
			{
				SMTimelineActivity.this.openTimeline();
				SMTimelineActivity.this.setInformationValues();
			}
			else if (SMTimelineActivity.this.mSelectedPoint == lastSelectedPoint)
			{
				// do nothing
			}
			else
			{
				SMTimelineActivity.this.mTimelineInformationContainer
						.startAnimation(SMTimelineActivity.this.mInformationChangeAnimation1);
			}

			SMTimelineActivity.this
					.resetLastSelectedPointImage(lastSelectedPoint);
			SMTimelineActivity.this.setCurrentSelectedPointImage();
		}
	};

	private final AnimationListener mInformationChangeListener = new AnimationListener()
	{

		@Override
		public void onAnimationStart(Animation animation)
		{

		}

		@Override
		public void onAnimationRepeat(Animation animation)
		{

		}

		@Override
		public void onAnimationEnd(Animation animation)
		{
			SMTimelineActivity.this.setInformationValues();
			SMTimelineActivity.this.mTimelineInformationContainer
					.startAnimation(SMTimelineActivity.this.mInformationChangeAnimation2);
		}
	};

	private final AnimationListener mInformationFadeOutAnimationListener = new AnimationListener()
	{
		@Override
		public void onAnimationStart(Animation arg0)
		{
			SMTimelineActivity.this.mIsAnimating = true;
		}

		@Override
		public void onAnimationRepeat(Animation arg0)
		{

		}

		@Override
		public void onAnimationEnd(Animation arg0)
		{
			SMTimelineActivity.this.mTimelineContainer
					.startAnimation(SMTimelineActivity.this.mTimelineAnimationRight);
			SMTimelineActivity.this.mYearsContainer
					.startAnimation(SMTimelineActivity.this.mYearsFadeInAnimation);
		}

	};

	private final AnimationListener mInformationFadeInAnimationListener = new AnimationListener()
	{

		@Override
		public void onAnimationStart(Animation animation)
		{

		}

		@Override
		public void onAnimationRepeat(Animation animation)
		{

		}

		@Override
		public void onAnimationEnd(Animation animation)
		{
			SMTimelineActivity.this.mIsAnimating = false;
		}
	};

	private final AnimationListener mOpenTimelineAnimationListener = new AnimationListener()
	{

		@Override
		public void onAnimationStart(Animation animation)
		{
			SMTimelineActivity.this.mIsAnimating = true;
		}

		@Override
		public void onAnimationRepeat(Animation animation)
		{

		}

		@Override
		public void onAnimationEnd(Animation animation)
		{
			SMTimelineActivity.this.mTimelineInformationContainer
					.startAnimation(SMTimelineActivity.this.mInformationFadeInAnimation);
		}
	};

	private final AnimationListener mCloseTimelineAnimationListener = new AnimationListener()
	{

		@Override
		public void onAnimationStart(Animation animation)
		{

		}

		@Override
		public void onAnimationRepeat(Animation animation)
		{

		}

		@Override
		public void onAnimationEnd(Animation animation)
		{
			SMTimelineActivity.this.mIsAnimating = false;

		}
	};
}
