package com.silence.easyadapterdemo.viewhandler;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;

import com.silence.easyadapter.listview.IListViewHandler;
import com.silence.easyadapter.listview.ListViewHolder;
import com.silence.easyadapterdemo.R;
import com.silence.easyadapterdemo.bean.DataType1;

/**
 * Created by wangsai on 2016/6/1.
 */
public class ViewHandler1 implements IListViewHandler<DataType1>, View.OnClickListener {
    @Override
    public int getResId() {
        return R.layout.item_main1;
    }

    @Override
    public int getUniqueItemTypeId() {
        return R.layout.item_main1;
    }

    @Override
    public void handleView(ListViewHolder holder, int positon, DataType1 data, ViewGroup parent) {
        holder.getViewFinder().textView(R.id.value).setText(data.getValue());

        holder.getItemView().setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        v.getContext().startActivity(new Intent(v.getContext(), RecyclerViewActivity.class));
    }
}
