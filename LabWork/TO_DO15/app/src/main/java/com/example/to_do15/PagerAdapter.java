package com.example.to_do15;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PagerAdapter#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
    int b;
    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.b = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new tab_fragment1();
            case 1:
                return new tab_fragment2();
            case 2:
                return new tab_fragment3();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {

        return b;
    }
}