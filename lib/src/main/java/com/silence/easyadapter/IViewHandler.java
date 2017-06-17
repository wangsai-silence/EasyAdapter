package com.silence.easyadapter;

import android.view.ViewGroup;

/**
 * Created by wangsai on 2016/6/3.
 */
public interface IViewHandler<H, T> {
    /**
     *
     * @return
     */
    int getResId();

    /**
     *
     * @param holder
     * @param position
     * @param data
     * @param parent
     */
    void handleView(H holder, int position, T data, ViewGroup parent);
}
