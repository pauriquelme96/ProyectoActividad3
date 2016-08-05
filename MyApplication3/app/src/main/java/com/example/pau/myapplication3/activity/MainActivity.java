package com.example.pau.myapplication3.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import com.example.pau.myapplication3.R;
import com.example.pau.myapplication3.adapter.MyPagerAdapter;

public class MainActivity extends FragmentActivity {

    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private static String[] titulo_tab = {"PRODUCTOS","REGISTRO"};
    public static String getTitulo(int position){return titulo_tab[position];}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        for (int i = 0; i < titulo_tab.length; i++){
            tabLayout.addTab(tabLayout.newTab());
        }

        tabLayout.setupWithViewPager(viewPager);
    }
}
