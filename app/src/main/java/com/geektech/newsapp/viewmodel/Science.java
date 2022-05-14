package com.geektech.newsapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.geektech.newsapp.common.Resource;
import com.geektech.newsapp.data.model.MainResponce;
import com.geektech.newsapp.data.repository.NewsRepositoryImpl;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class Science extends ViewModel {
    private NewsRepositoryImpl repositories;
    public LiveData<Resource<MainResponce>> liveData;

    @Inject
    public Science(NewsRepositoryImpl repositories) {
        this.repositories = repositories;
    }

    public  void getScience() {
        liveData = repositories.getScienceNews();
    }
}
