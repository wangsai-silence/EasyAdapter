package com.silence.easyadapterdemo.viewhandler;

import android.view.ViewGroup;

import com.silence.easyadapter.viewpager.IViewPagerHandler;
import com.silence.easyadapter.viewpager.ViewPagerHolder;
import com.silence.easyadapterdemo.R;
import com.silence.easyadapterdemo.bean.VDataType2;

/**
 * Created by wangsai on 2016/6/1.
 */
public class PagerViewHandler2 implements IViewPagerHandler<VDataType2> {
    @Override
    public int getResId() {
        return R.layout.item_main2;
    }

    @Override
    public void handleView(ViewPagerHolder holder, int position, VDataType2 data, ViewGroup parent) {
        holder.getViewFinder().textView(R.id.value2).setText(data.getValue());
    }
}
