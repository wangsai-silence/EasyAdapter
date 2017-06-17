package com.silence.easyadapter;

import android.support.v4.util.ArrayMap;
import android.util.Log;

import com.silence.easyadapter.utils.Assert;

import java.util.Map;

/**
 * Created by wangsai on 2016/4/20.
 */
public class ViewHandlerFactory {
    private static final String TAG = ViewHandlerFactory.class.getSimpleName();
    /**
     * cached handler
     */
    private static Map<String, IViewHandler> mHandlerMap = new ArrayMap<>();

    /**
     *
     * @param viewHandlerClazz
     */
    public static <T extends IViewHandler> T getViewHandler(String viewHandlerClazz) {
        IViewHandler result = mHandlerMap.get(viewHandlerClazz);

        if (result == null) {
            try {
                Class clazz = Class.forName(viewHandlerClazz);

                Assert.judge(IViewHandler.class.isAssignableFrom(clazz), "IViewHandler not implemented");

                result = (IViewHandler) clazz.newInstance();
                mHandlerMap.put(viewHandlerClazz, result);
            } catch (Exception e) {
                Log.e(TAG, "Exception!", e);
            }
        }

        if (result == null)
            throw new RuntimeException("IViewHandler create failed:" + viewHandlerClazz);

        return (T) result;
    }
}
