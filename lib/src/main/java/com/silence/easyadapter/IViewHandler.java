package com.silence.easyadapter;

import android.view.ViewGroup;

/**
 * Created by wangsai on 2016/6/3.
 */
public interface IViewHandler<H, T> {
    /**
     * 获取资源布局
     *
     * @return
     */
    int getResId();

    /**
     * 返回一个独一无二的 id，作为条目区分用
     *
     * @return
     */
    int getUniqueItemTypeId();

    /**
     * 对于条目显示的处理
     *
     * @param holder
     * @param positon
     * @param data
     * @param parent
     */
    void handleView(H holder, int positon, T data, ViewGroup parent);
}
