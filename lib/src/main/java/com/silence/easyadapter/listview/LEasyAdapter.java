package com.silence.easyadapter.listview;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.silence.easyadapter.IDataType;
import com.silence.easyadapter.ViewHandlerFactory;

import java.util.List;

/**
 * Created by wangsai on 2016/4/19.
 */
public class LEasyAdapter<T extends IDataType> extends BaseAdapter {

    /**
     * ListView的item类型数量
     */
    private int typeCount;

    /**
     * 自动生成item类型对应的下标
     */
    private int itemIdOffset = 0;

    /**
     * 缓存条目类型下标
     */
    private SparseArray<Integer> itemTypeArr;

    /**
     * 数据列表
     */
    private List<T> dataList;

    public LEasyAdapter(List<T> dataList) {
        this(dataList, 1);
    }

    public LEasyAdapter(List<T> dataList, int typeCount) {
        this.dataList = dataList;
        this.typeCount = typeCount;
        itemTypeArr = new SparseArray<>();
    }

    @Override
    public int getCount() {
        return dataList == null ? 0 : dataList.size();
    }

    @Override
    public int getItemViewType(int position) {
        IListViewHandler handler = ViewHandlerFactory.getViewHandler(getItem(position).getViewHandlerName());

        Integer id = itemTypeArr.get(handler.getUniqueItemTypeId());

        if (id == null) {
            id = itemIdOffset++;
            itemTypeArr.put(handler.getUniqueItemTypeId(), id);
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
