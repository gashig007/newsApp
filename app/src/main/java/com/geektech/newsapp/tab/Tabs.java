package com.geektech.newsapp.tab;

import androidx.fragment.app.Fragment;

public class Tabs  extends Fragment {
    public Tabs (Fragment fragments,String news){
        this.fragments=fragments;
        this.news=news;
    }
    private Fragment fragments;
    private String news;

    public Fragment getFragments() {
        return fragments;
    }

    public void setFragments(Fragment fragments) {
        this.fragments = fragments;
    }


    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}
