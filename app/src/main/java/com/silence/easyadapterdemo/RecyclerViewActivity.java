package com.silence.easyadapterdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.silence.easyadapter.IDataType;
import com.silence.easyadapter.recyclerview.REasyAdapter;
import com.silence.easyadapter.utils.ViewFinder;
import com.silence.easyadapterdemo.bean.RDataType1;
import com.silence.easyadapterdemo.bean.RDataType2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangsai on 2016/6/3.
 */
public class RecyclerViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.act_recycler);
        ViewFinder finder = new ViewFinder(this);
        RecyclerView recyclerView = finder.find(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new REasyAdapter(genData()));

        finder.find(R.id.go_pager).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(v.getContext(), ViewPagerActivity.class));
                    }
                }
        );
    }

    private List<IDataType> genData() {
        List<IDataType> result = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            if (((int) (Math.random() * 10)) % 2 == 0)
                result.add(new RDataType1("RecyclerView DataType 1"));
            else
                result.add(new RDataType2("RecyclerView DataType 2"));
        }
        return result;
    }
}
