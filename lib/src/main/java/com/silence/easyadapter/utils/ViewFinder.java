package com.silence.easyadapter.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.util.SparseArray;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.ref.WeakReference;

/**
 * 简化view的find和赋值操作操作
 * Created by wangsai on 2016/3/25.
 */
public class ViewFinder {

    private SparseArray<WeakReference<View>> mViews;

    private interface FindWrapper {

        View findViewById(int id);

        Resources getResources();
    }

    private static class WindowWrapper implements FindWrapper {

        private final Window window;

        WindowWrapper(final Window window) {
            this.window = window;
        }

        public View findViewById(final int id) {
            return window.findViewById(id);
        }

        public Resources getResources() {
            return window.getContext().getResources();
        }
    }

    private static class ViewWrapper implements FindWrapper {

        private final View view;

        ViewWrapper(final View view) {
            this.view = view;
        }

        public View findViewById(final int id) {
            return view.findViewById(id);
        }

        public Resources getResources() {
            return view.getResources();
        }
    }

    private final FindWrapper wrapper;

    /**
     * 创建finder 包装给定view
     *
     * @param view
     */
    public ViewFinder(View view) {
        wrapper = new ViewWrapper(view);
        init();
    }

    /**
     * 创建finder 包装给定window
     *
     * @param window
     */
    public ViewFinder(Window window) {
        wrapper = new WindowWrapper(window);
        init();
    }

    /**
     * 创建finder 包装给定activity
     *
     * @param activity
     */
    public ViewFinder(Activity activity) {
        this(activity.getWindow());
    }

    private void init() {
        mViews = new SparseArray<>();
    }

    /**
     * 通过id查找view
     *
     * @param id
     * @return 找到的view
     */
    public <V extends View> V find(int id) {
        View v;

        if (mViews.get(id) != null)
            v = mViews.get(id).get();
        else {
            v = wrapper.findViewById(id);
            if (v != null)
                mViews.put(id, new WeakReference<View>(v));
        }

        return (V) v;
    }

    /**
     * 通过id获取image
     *
     * @param id
     * @return image view
     */
    public ImageView imageView(final int id) {
        return find(id);
    }

    /**
     * 通过id获取text view
     *
     * @param id
     * @return text view
     */
    public TextView textView(final int id) {
        return find(id);
    }


    public ListView listView(final int id) {
        return find(id);
    }

    /**
     * 为对应id的child image view设置drawable
     *
     * @param id
     * @param drawable
     * @return image view
     */
    public ImageView setDrawable(final int id, final int drawable) {
        ImageView image = imageView(id);
        image.setImageDrawable(image.getResources().getDrawable(drawable));
        return image;
    }
}

