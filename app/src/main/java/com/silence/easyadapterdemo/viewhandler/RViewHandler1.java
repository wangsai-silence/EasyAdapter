package com.silence.easyadapterdemo.viewhandler;

import android.view.ViewGroup;

import com.silence.easyadapter.recyclerview.RecyclerViewHolder;
import com.silence.easyadapter.recyclerview.IRecyclerViewHandler;
import com.silence.easyadapterdemo.R;
import com.silence.easyadapterdemo.bean.RDataType1;

/**
 * Created by wangsai on 2016/6/1.
 */
public class RViewHandler1 implements IRecyclerViewHandler<RDataType1> {
    @Override
    public int getResId() {
        return R.layout.item_main1;
    }

    @Override
    public int getUniqueItemTypeId() {
        return R.layout.item_main1;
    }

    @Override
    public void handleView(RecyclerViewHolder holder, int positon, RDataType1 data, ViewGroup parent) {
        holder.getViewFinder().textView(R.id.value).setText(data.getValue());
    }
}
