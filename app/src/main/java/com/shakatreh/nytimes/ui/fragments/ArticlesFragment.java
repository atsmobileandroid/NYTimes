package com.shakatreh.nytimes.ui.fragments;


import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.shakatreh.nytimes.R;
import com.shakatreh.nytimes.databinding.FragmentArticlesBinding;
import com.shakatreh.nytimes.model.article.Article;
import com.shakatreh.nytimes.model.article.ArticlesResponse;
import com.shakatreh.nytimes.net.NoConnectivityException;
import com.shakatreh.nytimes.viewmodel.ArticlesViewModel;

import java.util.List;


public class ArticlesFragment extends Fragment {

    public static final String TAG = "ArticlesFragment";

    private FragmentArticlesBinding binding;
    private ArticlesViewModel viewModel;


    public static ArticlesFragment newInstance() {
        ArticlesFragment instance = new ArticlesFragment();
        final Bundle args = new Bundle();
        args.putString("TAG", TAG);
        instance.setArguments(args);
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_articles, container, false);
        View view = binding.getRoot();
        viewModel = ViewModelProviders.of(getActivity()).get(ArticlesViewModel.class);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getArticles();
    }

    private void getArticles() {
        viewModel.data.observe(this, new Observer<ArticlesResponse>() {
            @Override
            public void onChanged(ArticlesResponse articlesResponse) {
                if (articlesResponse.getThrowable() != null) {
                    if (articlesResponse.getThrowable() instanceof NoConnectivityException) {
                        // show No Connectivity message to user or do whatever you want.
                    }
                    return;
                }
                List<Article> data = articlesResponse.getArticles();
            }
        });
        viewModel.getArticles();
    }
}
