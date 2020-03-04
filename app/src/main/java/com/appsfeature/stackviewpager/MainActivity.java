package com.appsfeature.stackviewpager;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;

import com.appsfeature.stackviewpager.fragment.CardFragment;
import com.stack.viewpager.OrientedViewPager;
import com.appsfeature.stackviewpager.adapter.StackFragmentAdapter;
import com.stack.viewpager.transformer.VerticalStackTransformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private OrientedViewPager mOrientedViewPager;
    private StackFragmentAdapter mContentFragmentAdapter;
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOrientedViewPager = (OrientedViewPager) findViewById(R.id.view_pager);

        for (int i = 0; i < 10; i++) {
            mFragments.add(CardFragment.newInstance(i + 1));
        }

        mContentFragmentAdapter = new
                StackFragmentAdapter(getSupportFragmentManager(), mFragments);
        mOrientedViewPager.setOrientation(OrientedViewPager.Orientation.VERTICAL);
        mOrientedViewPager.setOffscreenPageLimit(3);
        mOrientedViewPager.setPageTransformer(true, new VerticalStackTransformer(getApplicationContext()));
        mOrientedViewPager.setAdapter(mContentFragmentAdapter);

    }
}
