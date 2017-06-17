package com.silence.easyadapterdemo.bean;

import com.silence.easyadapter.IDataType;
import com.silence.easyadapterdemo.viewhandler.PagerViewHandler2;

/**
 * Created by wangsai on 2016/6/1.
 */
public class VDataType2 implements IDataType {
    private String value;

    public VDataType2(String value){
        this.value = value;
    }

    @Override
    public String getViewHandlerName() {
        return PagerViewHandler2.class.getName();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
