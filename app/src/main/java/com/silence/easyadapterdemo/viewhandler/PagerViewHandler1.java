package com.silence.easyadapterdemo.viewhandler;

import android.view.ViewGroup;

import com.silence.easyadapter.recyclerview.IRecyclerViewHandler;
import com.silence.easyadapter.recyclerview.RecyclerViewHolder;
import com.silence.easyadapter.viewpager.IViewPagerHandler;
import com.silence.easyadapter.viewpager.ViewPagerHolder;
import com.silence.easyadapterdemo.R;
import com.silence.easyadapterdemo.bean.RDataType1;
import com.silence.easyadapterdemo.bean.VDataType1;

/**
 * Created by wangsai on 2016/6/1.
 */
public class PagerViewHandler1 implements IViewPagerHandler<VDataType1> {
    @Override
    public int getResId() {
        return R.layout.item_main1;
    }

    @Override
    public void handleView(ViewPagerHolder holder, int position, VDataType1 data, ViewGroup parent) {
        holder.getViewFinder().textView(R.id.value).setText(data.getValue());
    }
}
