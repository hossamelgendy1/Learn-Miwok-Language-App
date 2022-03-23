package com.example.android;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.android.miwok.R;
import com.example.android.ud839_miwok_starter_code.ColorsFragment;
import com.example.android.ud839_miwok_starter_code.FamilyFragment;
import com.example.android.ud839_miwok_starter_code.NumbersFragment;
import com.example.android.ud839_miwok_starter_code.PhrasesFragment;

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {
    private Context mContext;

    public SimpleFragmentPagerAdapter(FragmentManager fm,Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new NumbersFragment();
        } else if (position == 1) {
            return new FamilyFragment();
        } else if (position == 2) {
            return new ColorsFragment();
        } else {
            return new PhrasesFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mContext.getString(R.string.category_numbers);
        } else if (position == 1) {
            return mContext.getString(R.string.category_family);
        } else if (position == 2) {
            return mContext.getString(R.string.category_colors);
        } else {
            return mContext.getString(R.string.category_phrases);
        }
    }
}
