package com.silence.easyadapterdemo.viewhandler;

import android.view.ViewGroup;

import com.silence.easyadapter.recyclerview.RecyclerViewHolder;
import com.silence.easyadapter.recyclerview.IRecyclerViewHandler;
import com.silence.easyadapterdemo.R;
import com.silence.easyadapterdemo.bean.RDataType2;

/**
 * Created by wangsai on 2016/6/1.
 */
public class RViewHandler2 implements IRecyclerViewHandler<RDataType2> {
    @Override
    public int getResId() {
        return R.layout.item_main2;
    }

    @Override
    public void handleView(RecyclerViewHolder holder, int positon, RDataType2 data, ViewGroup parent) {
        holder.getViewFinder().textView(R.id.value2).setText(data.getValue());
    }
}
