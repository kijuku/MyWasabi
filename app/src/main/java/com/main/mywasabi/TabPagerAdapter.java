package com.main.mywasabi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.main.mywasabi.Fragment.ChatFragment;
import com.main.mywasabi.Fragment.ConfigFragment;
import com.main.mywasabi.Fragment.GroupFragment;
import com.main.mywasabi.Fragment.MainFragment;

public class TabPagerAdapter extends FragmentStateAdapter {
    public TabPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    public TabPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    public TabPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Bundle data = new Bundle();
        switch (position){
            case 0:
                data.putString("dataID","Tekstiä MainActivitystä!");
                return new MainFragment();
            case 1:
                return new ChatFragment();
            case 2:
                return new GroupFragment();
            case 3:
                return new ConfigFragment();

            default:
                return new MainFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
