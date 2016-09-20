package com.silence.easyadapter.utils;

import android.support.graphics.drawable.BuildConfig;

/**
 * Only enable when debug
 *
 * Created by wangsai on 2016/4/12.
 */
public class Assert {

    private static final String MESSAGE_FORMAT = "\"%s\" params empty.";

    /**
     * judge whether Object is empty, if true throw NullPointerException
     * </p>
     *
     * @param object
     * @param argName
     */
    public static void checkNotNull(Object object, String argName) {
        if (object == null && BuildConfig.DEBUG) {

            throw new NullPointerException(String.format(MESSAGE_FORMAT, argName));
        }
    }

    public static void judge(boolean bool) {
        if (bool || !BuildConfig.DEBUG)
            return;

        RuntimeException error = new RuntimeException();
        StackTraceElement[] elements = error.getStackTrace();
        judge(bool, "Assert error! Class:" + elements[1].getClassName()
                + " Method:" + elements[1].getMethodName()
                + " Line:" + elements[1].getLineNumber());
    }

    public static void judge(boolean bool, String hint) {
        if (bool || !BuildConfig.DEBUG)
            return;

        throw new RuntimeException(hint);
    }
}
