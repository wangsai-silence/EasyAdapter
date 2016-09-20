package com.silence.easyadapter.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.support.v4.util.ArrayMap;
import android.view.ViewGroup;

import com.silence.easyadapter.IDataType;
import com.silence.easyadapter.ViewHandlerFactory;

import java.util.List;
import java.util.Map;

/**
 * Created by wangsai on 2016/6/3.
 */
public class REasyAdapter<T extends IDataType> extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<T> dataList;

    private Map<Integer, Integer> resArray;

    public REasyAdapter(List<T> dataList) {
        this.dataList = dataList;
        resArray = new ArrayMap<>();
    }

    public T getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        IRecyclerViewHandler handler = ViewHandlerFactory.getViewHandler(getItem(position).getViewHandlerName());

        resArray.put(handler.getClass().hashCode(), handler.getResId());

        return handler.getClass().hashCode();
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return RecyclerViewHolder.get(parent, resArray.get(viewType));
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        IRecyclerViewHandler handler = ViewHandlerFactory.getViewHandler(getItem(position).getViewHandlerName());

        handler.handleView(holder, position, getItem(position), (ViewGroup) holder.itemView.getParent());
    }

    @Override
    public int getItemCount() {
        return dataList == null ? 0 : dataList.size();
    }

}
