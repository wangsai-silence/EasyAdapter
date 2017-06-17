package com.silence.easyadapterdemo.bean;

import com.silence.easyadapter.IDataType;
import com.silence.easyadapterdemo.viewhandler.ViewHandler2;

/**
 * Created by wangsai on 2016/6/1.
 */
public class DataType2 implements IDataType {
    private String value;

    public DataType2(String value){
        this.value = value;
    }

    @Override
    public String getViewHandlerName() {
        return ViewHandler2.class.getName();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
