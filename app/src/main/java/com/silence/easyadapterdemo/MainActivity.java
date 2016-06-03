package com.silence.easyadapterdemo;

import android.app.Activity;
import android.os.Bundle;

import com.silence.easyadapter.listview.LEasyAdapter;
import com.silence.easyadapter.IDataType;
import com.silence.easyadapter.utils.ViewFinder;
import com.silence.easyadapterdemo.bean.DataType1;
import com.silence.easyadapterdemo.bean.DataType2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangsai on 2016/6/1.
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        new ViewFinder(this).listView(R.id.listview).setAdapter(new LEasyAdapter(genData(),2));
    }

    private List<IDataType> genData() {
        List<IDataType> result = new ArrayList<>();
        for (int i = 0 ;i< 40;i++){
            if(((int)(Math.random() *10)) % 2 == 0)
                result.add(new DataType1("DataType 1"));
            else
                result.add(new DataType2("DataType 2"));
        }
        return result;
    }

}
