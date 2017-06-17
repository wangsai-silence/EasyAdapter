package com.silence.easyadapterdemo.bean;

import com.silence.easyadapter.IDataType;
import com.silence.easyadapterdemo.viewhandler.RViewHandler1;

/**
 * Created by wangsai on 2016/6/1.
 */
public class RDataType1 implements IDataType {
    private String value;

    public RDataType1(String value){
        this.value = value;
    }

    @Override
    public String getViewHandlerName() {
        return RViewHandler1.class.getName();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
