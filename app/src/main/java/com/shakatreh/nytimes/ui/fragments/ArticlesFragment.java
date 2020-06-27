package com.shakatreh.nytimes.ui.fragments;


import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.shakatreh.nytimes.R;
import com.shakatreh.nytimes.adapter.ArticlesAdapter;
import com.shakatreh.nytimes.databinding.FragmentArticlesBinding;
import com.shakatreh.nytimes.model.article.Article;
import com.shakatreh.nytimes.model.article.ArticlesResponse;
import com.shakatreh.nytimes.net.NoConnectivityException;
import com.shakatreh.nytimes.util.Utils;
import com.shakatreh.nytimes.viewmodel.ArticlesViewModel;

import java.util.List;


public class ArticlesFragment extends Fragment{

    private FragmentArticlesBinding binder;
    private ArticlesViewModel viewModel;
    private ArticlesAdapter adapter;


    public static ArticlesFragment newInstance() {
        ArticlesFragment instance = new ArticlesFragment();
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_articles, container, false);
        View view = binder.getRoot();
        viewModel = ViewModelProviders.of(getActivity()).get(ArticlesViewModel.class);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new ArticlesAdapter(getContext());
        binder.rvArticles.setLayoutManager(new LinearLayoutManager(getContext()));
        binder.rvArticles.setAdapter(adapter);
        getArticles();
    }

    private void getArticles() {
        viewModel.data.observe(this, new Observer<ArticlesResponse>() {
            @Override
            public void onChanged(ArticlesResponse articlesResponse) {
                if (articlesResponse.getThrowable() != null) {
                    if (articlesResponse.getThrowable() instanceof NoConnectivityException) {
                        Utils.showAlertDialog(getContext(), "Connectivity problem", "Unable to connect to the internet!");
                    } else {
                        // TODO: can implementing other errors
                    }
                    return;
                }
                adapter.setData(articlesResponse.getArticles());
            }
        });
        viewModel.getArticles();
    }


}
