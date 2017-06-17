package com.silence.easyadapter.viewpager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;


import com.silence.easyadapter.IDataType;
import com.silence.easyadapter.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangsai on 2017/6/7.
 */

public abstract class CacheViewAdapter<T extends IDataType> extends PagerAdapter {

    public Map<Integer, List<View>> viewMap;


    public CacheViewAdapter() {
        viewMap = new HashMap<>();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view;

        List<View> viewList = viewMap.get(getItemViewType(position));
        if (viewList == null) {
            viewList = new ArrayList<>();
            viewMap.put(getItemViewType(position), viewList);
        }

        if (viewList.size() != 0) {
            view = getView(position, viewList.remove(0), container);
        } else {
            view = getView(position, null, container);
        }
        view.setTag(R.id.item_viewtype, getItemViewType(position));
        container.addView(view);

        return view;
    }

    protected abstract int getItemViewType(int position);

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;

        container.removeView(view);
        int itemType = (int) view.getTag(R.id.item_viewtype);

        List<View> cacheList = viewMap.get(itemType);
        if (cacheList == null) {
            cacheList = new ArrayList<>();
            viewMap.put(itemType, cacheList);
        }
        cacheList.add(view);
    }

    /**
     * 创建新的条目
     *
     * @return
     */
    public abstract View getView(int position, View convertView, ViewGroup parent);


    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}
