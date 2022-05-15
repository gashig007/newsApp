package com.geektech.newsapp.ui;

import android.widget.Toast;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.geektech.newsapp.base.BaseFragment;
import com.geektech.newsapp.common.Resource;
import com.geektech.newsapp.data.model.MainResponce;
import com.geektech.newsapp.databinding.FragmentBussinessBinding;
import com.geektech.newsapp.viewmodel.Business;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class BusinessFragment extends BaseFragment<FragmentBussinessBinding> {
    private Business viewModel;
    private NewsAdapter adapter;
    @Override
    protected FragmentBussinessBinding bind() {
        return FragmentBussinessBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void setupViews() {
        viewModel = new ViewModelProvider(requireActivity())
                .get(Business.class);
        adapter = new NewsAdapter();
        binding.recycler.setAdapter(adapter);
    }

    @Override
    protected void callRequests() {
        viewModel.getBusiness();
    }

    @Override
    protected void setupListeners() {

    }

    @Override
    protected void setupObservers() {
        viewModel.liveData.observe(getViewLifecycleOwner(), new Observer<Resource<MainResponce>>() {
            @Override
            public void onChanged(Resource<MainResponce> resource) {
                switch (resource.status){
                    case LOADING:{
                        //TODO Add progress
                        break;
                    }
                    case SUCCESS:{
                        Toast.makeText(requireActivity(), "34", Toast.LENGTH_SHORT).show();
                        adapter.setNewsList(resource.data.getArticles());
                        break;
                    }
                    case ERROR:{
                        Snackbar.make(binding.getRoot(),
                                resource.msg,
                                BaseTransientBottomBar.LENGTH_LONG);
                        break;
                    }
                }
            }
        });
    }
}