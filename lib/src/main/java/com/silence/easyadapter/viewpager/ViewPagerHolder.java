package com.huobi.baselib.adapter.viewpager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.huobi.baselib.utils.ViewFinder;

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

        mItemView.setTag(com.huobi.baselib.R.id.item_holder, this);
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
            return (ViewPagerHolder) itemView.getTag(com.huobi.baselib.R.id.item_holder);
    }
}
