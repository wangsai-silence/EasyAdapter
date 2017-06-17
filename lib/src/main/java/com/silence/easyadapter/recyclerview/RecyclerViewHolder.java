package com.silence.easyadapter.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.silence.easyadapter.utils.ViewFinder;

/**
 * Created by wangsai on 2016/6/3.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    private ViewFinder viewFinder;

    public RecyclerViewHolder(View itemView) {
        super(itemView);

        viewFinder = new ViewFinder(itemView);
    }

    public ViewFinder getViewFinder() {
        return viewFinder;
    }

    public static RecyclerViewHolder get(ViewGroup parent, int layoutId) {
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(layoutId, parent, false));
    }
}
