package com.geektech.newsapp.ui;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.geektech.newsapp.base.BaseFragment;
import com.geektech.newsapp.common.Resource;
import com.geektech.newsapp.data.model.MainResponce;
import com.geektech.newsapp.databinding.FragmentTopBinding;
import com.geektech.newsapp.viewmodel.Top;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class TopFragment extends BaseFragment<FragmentTopBinding> {
    private Top viewModel;
    private NewsAdapter adapter;

    @Override
    protected FragmentTopBinding bind() {
        return FragmentTopBinding.inflate(getLayoutInflater());
    }

    @Override
    protected void setupViews() {
        viewModel = new ViewModelProvider(requireActivity())
                .get(Top.class);
        adapter = new NewsAdapter();
        binding.recycler.setAdapter(adapter);
    }

    @Override
    protected void callRequests() {
        viewModel.getTop();
    }

    @Override
    protected void setupListeners() {

    }

    @Override
    protected void setupObservers() {
        viewModel.liveData.observe(getViewLifecycleOwner(), new Observer<Resource<MainResponce>>() {
            @Override
            public void onChanged(Resource<MainResponce> resource) {
                switch (resource.status) {
                    case LOADING: {
                        //TODO Add progress
                        break;
                    }
                    case SUCCESS: {
                        adapter.setNewsList(resource.data.getArticles());
                        break;
                    }
                    case ERROR: {
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