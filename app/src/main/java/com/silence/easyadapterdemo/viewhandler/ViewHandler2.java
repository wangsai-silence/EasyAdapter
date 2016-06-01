package com.silence.easyadapterdemo.viewhandler;

import android.view.ViewGroup;

import com.silence.easyadapter.IViewHandler;
import com.silence.easyadapter.ViewHolder;
import com.silence.easyadapterdemo.R;
import com.silence.easyadapterdemo.bean.DataType2;

/**
 * Created by wangsai on 2016/6/1.
 */
public class ViewHandler2 implements IViewHandler<DataType2> {
    @Override
    public int getResId() {
        return R.layout.item_main2;
    }

    @Override
    public int getUniqueItemTypeId() {
        return R.layout.item_main2;
    }

    @Override
    public void handleView(ViewHolder holder, int positon, DataType2 data, ViewGroup parent) {
        holder.getViewFinder().textView(R.id.value2).setText(data.getValue());
    }
}
