package com.salil.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.salil.R;
import com.salil.SMBaseActivity;


public class SMActionbar extends RelativeLayout
{
	private TextView mTitleText;
	private TextView mBackArrow;
	private boolean mIsEnabled = true;

	public SMActionbar(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		this.init();
	}

	public SMActionbar(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		this.init();
	}

	public SMActionbar(Context context)
	{
		super(context);
		this.init();
	}

	private void init()
	{
		LayoutInflater inflater = (LayoutInflater) this.getContext()
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		inflater.inflate(R.layout.actionbar, this);

		this.mTitleText = (TextView) this.findViewById(R.id.actionbar_textview);
		this.mBackArrow = (TextView) this
				.findViewById(R.id.actionbar_backarrow);
		this.mBackArrow.setOnClickListener(this.mBackArrowClickListener);

	}

	@Override
	public void setEnabled(boolean isEnabled)
	{
		this.mIsEnabled = isEnabled;
	}

	private final OnClickListener mBackArrowClickListener = new OnClickListener()
	{

		@Override
		public void onClick(View v)
		{
			if (SMActionbar.this.mIsEnabled)
			{
				((SMBaseActivity) SMActionbar.this.getContext()).finish();
			}
		}
	};

	public void setTitle(String title)
	{
		this.mTitleText.setText(title);
	}

	public void hideBackArrow()
	{
		this.mBackArrow.setVisibility(View.GONE);
		this.mTitleText.setPadding((int) TypedValue.applyDimension(
				TypedValue.COMPLEX_UNIT_DIP, 8, this.getContext()
						.getResources().getDisplayMetrics()), 0, 0, 0);
	}
}
