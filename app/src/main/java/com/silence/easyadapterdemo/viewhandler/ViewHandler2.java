package com.silence.easyadapterdemo.viewhandler;

import android.view.ViewGroup;

import com.silence.easyadapter.listview.IListViewHandler;
import com.silence.easyadapter.listview.ListViewHolder;
import com.silence.easyadapterdemo.R;
import com.silence.easyadapterdemo.bean.DataType2;

/**
 * Created by wangsai on 2016/6/1.
 */
public class ViewHandler2 implements IListViewHandler<DataType2> {
    @Override
    public int getResId() {
        return R.layout.item_main2;
    }

    @Override
    public void handleView(ListViewHolder holder, int positon, DataType2 data, ViewGroup parent) {
        holder.getViewFinder().textView(R.id.value2).setText(data.getValue());
    }
}
