package com.silence.easyadapter.viewpager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.silence.easyadapter.R;
import com.silence.easyadapter.utils.ViewFinder;


/**
 * Created by wangsai on 2017/6/17.
 */

public class ViewPagerHolder {
    private ViewFinder viewFinder;

    private View mItemView;

    private ViewPagerHolder(Context context, ViewGroup parent, int layoutId) {
        LayoutInflater inflater = LayoutInflater.from(context);
        mItemView = inflater.inflate(layoutId, parent, false);
        viewFinder = new ViewFinder(mItemView);

        mItemView.setTag(R.id.item_holder, this);
    }

    public View getItemView() {
        return mItemView;
    }

    public ViewFinder getViewFinder() {
        return viewFinder;
    }

    public static ViewPagerHolder get(Context context, View itemView, ViewGroup parent, int layoutId) {
        if (itemView == null)
            return new ViewPagerHolder(context, parent, layoutId);
        else
            return (ViewPagerHolder) itemView.getTag(R.id.item_holder);
    }
}
