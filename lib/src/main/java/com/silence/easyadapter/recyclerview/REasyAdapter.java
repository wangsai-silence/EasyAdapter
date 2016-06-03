package com.silence.easyadapter.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.ViewGroup;

import com.silence.easyadapter.IDataType;
import com.silence.easyadapter.ViewHandlerFactory;

import java.util.List;

/**
 * Created by wangsai on 2016/6/3.
 */
public class REasyAdapter<T extends IDataType> extends RecyclerView.Adapter<RecyclerViewHolder> {
    /**
     * 数据列表
     */
    private List<T> dataList;

    private SparseArray<Integer> resArray;

    public REasyAdapter(List<T> dataList) {
        this.dataList = dataList;
        resArray = new SparseArray<>();
    }

    public T getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        IRecyclerViewHandler handler = ViewHandlerFactory.getViewHandler(getItem(position).getViewHandlerName());

        resArray.put(handler.getUniqueItemTypeId(), handler.getResId());

        return handler.getUniqueItemTypeId();
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
