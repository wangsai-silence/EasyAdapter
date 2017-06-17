package com.silence.easyadapter.listview;

import android.support.v4.util.ArrayMap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.silence.easyadapter.IDataType;
import com.silence.easyadapter.ViewHandlerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by wangsai on 2016/4/19.
 */
public class LEasyAdapter<T extends IDataType> extends BaseAdapter {

    /**
     * ListView item type count
     */
    private int typeCount;

    /**
     * auto generate item type
     */
    private int itemIdOffset = 0;

    /**
     * cache item type
     */
    private Map<String, Integer> itemTypeArr;

    private List<T> dataList;

    public LEasyAdapter(List<T> dataList) {
        this(dataList, 1);
    }

    public LEasyAdapter(List<T> dataList, int typeCount) {
        this.dataList = dataList;
        this.typeCount = typeCount;
        itemTypeArr = new ArrayMap<>();
    }

    @Override
    public int getCount() {
        return dataList == null ? 0 : dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        IListViewHandler handler = ViewHandlerFactory.getViewHandler(getItem(position).getViewHandlerName());

        Integer id = itemTypeArr.get(handler.getClass().getName());

        if (id == null) {
            id = itemIdOffset++;
            itemTypeArr.put(handler.getClass().getName(), id);
        }

        return id;
    }

    @Override
    public int getViewTypeCount() {
        return typeCount;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public T getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        IListViewHandler handler = ViewHandlerFactory.getViewHandler(getItem(position).getViewHandlerName());
        ListViewHolder holder = ListViewHolder.get(parent.getContext(), convertView, parent, handler.getResId());

        handler.handleView(holder, position, getItem(position), parent);

        return holder.getItemView();
    }
}
