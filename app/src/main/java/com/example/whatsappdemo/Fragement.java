package com.example.whatsappdemo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Fragement extends FragmentStatePagerAdapter {
    private final List<Fragment>fragment_local=new ArrayList<Fragment>();
    private final List<String>fragment_local_title=new ArrayList<String>();

    public void add(Fragment fragment,String title)
    {
        fragment_local.add(fragment);
        fragment_local_title.add(title);
    }

    public Fragement(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragment_local.get(position);
    }

    @Override
    public int getCount() {
        return fragment_local_title.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragment_local_title.get(position);
    }
}
