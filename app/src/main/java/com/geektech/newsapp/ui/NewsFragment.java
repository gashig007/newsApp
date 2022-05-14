package com.geektech.newsapp.ui;

import androidx.annotation.NonNull;

import com.geektech.newsapp.base.BaseFragment;
import com.geektech.newsapp.databinding.FragmentNewsBinding;
import com.geektech.newsapp.tab.Tabs;
import com.geektech.newsapp.tab.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class NewsFragment extends BaseFragment<FragmentNewsBinding> {
    private ArrayList<Tabs> fragments;
    private ViewPagerAdapter adapter;

    @Override
    protected FragmentNewsBinding bind() {
        return FragmentNewsBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void setupViews() {

    }

    @Override
    protected void callRequests() {

    }

    @Override
    protected void setupListeners() {

    }

    @Override
    protected void setupObservers() {
        fragments=new ArrayList<>();
        fragments.add(new Tabs(new BusinessFragment(),"Business News"));
        fragments.add(new Tabs(new EntertainmentFragment(),"Entertainment News"));
        fragments.add(new Tabs(new GeneralFragment(),"General News"));
        fragments.add(new Tabs(new HealthFragment(),"Health News"));
        fragments.add(new Tabs(new ScienceFragment(),"Science News"));
        fragments.add(new Tabs(new SportFragment(),"Sport News"));
        fragments.add(new Tabs(new TechnologyFragment(),"Technology News"));
        fragments.add(new Tabs(new TopFragment(),"Top News"));
        adapter = new ViewPagerAdapter(this);
        adapter.setFragments(fragments);
        binding.viewPager.setAdapter(adapter);
        new TabLayoutMediator(binding.tab, binding.viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(fragments.get(position).getNews());
            }
        }).attach();
    }
}
