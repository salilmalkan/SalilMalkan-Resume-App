package com.salil.work.apps;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

public class SMAppGalleryAdapter extends BaseAdapter
{
	private final Context mContext;
	private final ArrayList<Integer> mImageList;

	public SMAppGalleryAdapter(Context c, ArrayList<Integer> imageList)
	{
		this.mContext = c;
		this.mImageList = imageList;
		System.gc();
	}

	@Override
	public int getCount()
	{
		return this.mImageList.size();
	}

	@Override
	public Object getItem(int position)
	{
		return position;
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ImageView i = new ImageView(this.mContext);
		i.setImageResource(this.mImageList.get(position).intValue());
		i.setScaleType(ScaleType.CENTER_INSIDE);
		i.setLayoutParams(new Gallery.LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.WRAP_CONTENT));

		return i;
	}

}
