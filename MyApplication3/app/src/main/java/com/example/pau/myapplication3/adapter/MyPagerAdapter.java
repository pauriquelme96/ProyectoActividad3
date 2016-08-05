package com.example.pau.myapplication3.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.pau.myapplication3.activity.MainActivity;
import com.example.pau.myapplication3.fragment.ProductoFragment;
import com.example.pau.myapplication3.fragment.RegistroFragment;

import java.util.ArrayList;

/**
 * Created by Pau on 03/08/2016.
 */
public class MyPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> fragments;

    public MyPagerAdapter(FragmentManager fm){
        super(fm);

        fragments = new ArrayList<>();
        initFragments();
    }

    private void initFragments(){
        fragments.add(new ProductoFragment());
        fragments.add(new RegistroFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return MainActivity.getTitulo(position);
    }
}
