package com.huobi.baselib.adapter.viewpager;

import android.support.v4.util.ArrayMap;
import android.view.View;
import android.view.ViewGroup;

import com.huobi.baselib.adapter.IDataType;
import com.huobi.baselib.adapter.IViewHandler;
import com.huobi.baselib.adapter.ViewHandlerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by wangsai on 2017/6/17.
 */

public class VEasyAdapter<T extends IDataType> extends CacheViewAdapter<T> {

    /**
     * auto generate item type
     */
    private int itemIdOffset = 0;

    /**
     * cache item type
     */
    private Map<String, Integer> itemTypeArr;

    private List<T> dataList;

    public VEasyAdapter(List<T> dataList) {
        super();

        this.dataList = dataList;
        itemTypeArr = new ArrayMap<>();
    }

    @Override
    public int getCount() {
        return dataList == null ? 0 : dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        IViewHandler handler = ViewHandlerFactory.getViewHandler(getItem(position).getViewHandlerName());

        Integer id = itemTypeArr.get(handler.getClass().getName());

        if (id == null) {
            id = itemIdOffset++;
            itemTypeArr.put(handler.getClass().getName(), id);
        }

        return id;
    }

    public T getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        IViewHandler handler = ViewHandlerFactory.getViewHandler(getItem(position).getViewHandlerName());
        ViewPagerHolder holder = ViewPagerHolder.get(parent.getContext(), convertView, parent, handler.getResId());

        handler.handleView(holder, position, getItem(position), parent);

        return holder.getItemView();
    }
}
