package com.silence.easyadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.silence.easyadapter.R;
import com.silence.easyadapter.utils.ViewFinder;

/**
 * Created by wangsai on 2016/4/19.
 */
public class ViewHolder {
    private ViewFinder viewFinder;

    private View mItemView;

    private ViewHolder(Context context, ViewGroup parent, int layoutId) {
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

    public static ViewHolder get(Context context, View itemView, ViewGroup parent, int layoutId) {
        if (itemView == null)
            return new ViewHolder(context, parent, layoutId);
        else
            return (ViewHolder) itemView.getTag(R.id.item_holder);
    }
}
