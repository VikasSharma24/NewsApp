package com.example.vikas.NewsApp.news;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.vikas.NewsApp.R;
import com.example.vikas.NewsApp.fragement.NewsCategoryFragment;
import java.util.ArrayList;
import java.util.List;


public class NewsMainActivity extends AppCompatActivity {
    ViewPager viewpager;
    private TabLayout tabLayout;
    private ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_main);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.detail_tabs);
        setViewpager();

    }


    /*Set The View Pager*/
    private void setViewpager() {
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

       /* // Iterate through Set
        Set<Map.Entry<String, ArrayList<Sources>>> entrySet = mapdData.entrySet();
        for (Map.Entry<String, ArrayList<Sources>> entry : entrySet)*/
        viewPagerAdapter.addFragment(new NewsCategoryFragment("business"), "Business");
        viewPagerAdapter.addFragment(new NewsCategoryFragment("entertainment"), "Entertainment");
        viewPagerAdapter.addFragment(new NewsCategoryFragment("health"), "Health");
        viewPagerAdapter.addFragment(new NewsCategoryFragment("science"), "Science");
        viewPagerAdapter.addFragment(new NewsCategoryFragment("sports"), "Sports");
        viewPagerAdapter.addFragment(new NewsCategoryFragment("technology"), "Technology");
        viewpager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewpager);
    }


    /* View PagerAdapter Class*/
    class ViewPagerAdapter extends FragmentStatePagerAdapter {
        private Fragment mCurrentFragment;

        public Fragment getCurrentFragment() {
            return mCurrentFragment;
        }

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            //   Fragment myFragment = getCurrentFragment();
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
