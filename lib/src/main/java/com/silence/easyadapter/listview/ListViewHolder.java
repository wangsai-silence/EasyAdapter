package com.silence.easyadapter.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.silence.easyadapter.R;
import com.silence.easyadapter.utils.ViewFinder;

/**
 * Created by wangsai on 2016/4/19.
 */
public class ListViewHolder {
    private ViewFinder viewFinder;

    private View mItemView;

    private ListViewHolder(Context context, ViewGroup parent, int layoutId) {
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

    public static ListViewHolder get(Context context, View itemView, ViewGroup parent, int layoutId) {
        if (itemView == null)
            return new ListViewHolder(context, parent, layoutId);
        else
            return (ListViewHolder) itemView.getTag(R.id.item_holder);
    }
}
