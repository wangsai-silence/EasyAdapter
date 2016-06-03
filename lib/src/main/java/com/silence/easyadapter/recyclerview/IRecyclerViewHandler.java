package com.silence.easyadapter.recyclerview;

import android.support.v7.widget.RecyclerView;

import com.silence.easyadapter.IViewHandler;

/**
 * 用于{@link RecyclerView} 条目处理
 * Created by wangsai on 2016/6/3.
 */
public interface IRecyclerViewHandler<T> extends IViewHandler<RecyclerViewHolder, T> {
}
