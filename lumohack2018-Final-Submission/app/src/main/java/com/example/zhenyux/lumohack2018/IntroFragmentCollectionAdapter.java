package com.example.zhenyux.lumohack2018;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class IntroFragmentCollectionAdapter extends FragmentStatePagerAdapter{
    public IntroFragmentCollectionAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        IntroFragment introFragment = new IntroFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("integer", position);

        position = position+1;
        bundle.putString("message", "Hello from page :" + position);
        introFragment.setArguments(bundle);
        return introFragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
