package com.silence.easyadapterdemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.silence.easyadapter.IDataType;
import com.silence.easyadapter.utils.ViewFinder;
import com.silence.easyadapter.viewpager.VEasyAdapter;
import com.silence.easyadapterdemo.bean.RDataType1;
import com.silence.easyadapterdemo.bean.RDataType2;
import com.silence.easyadapterdemo.bean.VDataType1;
import com.silence.easyadapterdemo.bean.VDataType2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangsai on 2017/6/17.
 */

public class ViewPagerActivity extends Activity {
    ViewFinder finder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_viewpager);
        finder = new ViewFinder(this);


        finder.viewPager(R.id.viewpager).setAdapter(new VEasyAdapter(genData()));
    }

    private List<IDataType> genData() {
        List<IDataType> result = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            if (((int) (Math.random() * 10)) % 2 == 0)
                result.add(new VDataType1("RecyclerView DataType 1"));
            else
                result.add(new VDataType2("RecyclerView DataType 2"));
        }
        return result;
    }
}
