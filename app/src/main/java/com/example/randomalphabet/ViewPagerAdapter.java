package com.example.randomalphabet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> views;

    public ViewPagerAdapter(@NonNull FragmentManager fm, List<Fragment> views) {
        super(fm);
        this.views = views;
    }

    @Override
    public int getCount() {
        return views.size();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return views.get(position);
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        int index = views.indexOf (object);
        if (index == -1)
            return POSITION_NONE;
        else
            return index;
    }

    public void addView(Fragment view, int index) {
        views.add(index, view);
        notifyDataSetChanged();
    }

    public void removeView(int index) {
        views.remove(index);
        notifyDataSetChanged();
    }

}
