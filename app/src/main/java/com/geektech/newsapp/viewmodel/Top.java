package com.geektech.newsapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.newsapp.common.Resource;
import com.geektech.newsapp.data.model.MainResponce;
import com.geektech.newsapp.data.repository.NewsRepositoryImpl;

import javax.inject.Inject;

public class Top extends ViewModel {
    private NewsRepositoryImpl repositories;
    public LiveData<Resource<MainResponce>> liveData;

    @Inject
    public Top(NewsRepositoryImpl repositories) {
        this.repositories = repositories;
    }

    public void getTop() {
        liveData = repositories.getTopNews();
    }
}