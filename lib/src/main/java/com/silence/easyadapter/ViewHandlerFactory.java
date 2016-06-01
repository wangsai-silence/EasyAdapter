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
     * 缓存已存在的handler
     */
    private static Map<String, IViewHandler> mHandlerMap = new ArrayMap<>();

    /**
     * 通过类名动态加载创建、加载对应的类对象
     *
     * @param viewHandlerClazz
     * @return
     */
    public static IViewHandler getViewHandler(String viewHandlerClazz) {
        IViewHandler result = mHandlerMap.get(viewHandlerClazz);

        if (result == null) {
            try {
                Class clazz = Class.forName(viewHandlerClazz);

                Assert.judge(IViewHandler.class.isAssignableFrom(clazz), "处理类必须实现IViewHandler接口");

                result = (IViewHandler) clazz.newInstance();
                mHandlerMap.put(viewHandlerClazz, result);
            } catch (Exception e) {
                Log.e(TAG, "Exception!", e);
            }
        }

        if (result == null)
            throw new RuntimeException("IViewHandler创建失败:" + viewHandlerClazz);

        return result;
    }
}
