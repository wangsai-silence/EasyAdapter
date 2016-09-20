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
     *
     * @param view
     */
    public ViewFinder(View view) {
        wrapper = new ViewWrapper(view);
        init();
    }

    /**
     *
     * @param window
     */
    public ViewFinder(Window window) {
        wrapper = new WindowWrapper(window);
        init();
    }

    /**
     * @param activity
     */
    public ViewFinder(Activity activity) {
        this(activity.getWindow());
    }

    private void init() {
        mViews = new SparseArray<>();
    }

    /**
     * @param id
     * @return
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
     *
     * @param id
     * @return image view
     */
    public ImageView imageView(final int id) {
        return find(id);
    }

    /**
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

