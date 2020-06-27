package com.shakatreh.nytimes.ui.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import com.shakatreh.nytimes.R;
import com.shakatreh.nytimes.databinding.FragmentArticleDetailsBinding;
import com.shakatreh.nytimes.model.article.Article;
import com.shakatreh.nytimes.ui.MainActivity;


public class ArticleDetailsFragment extends Fragment {

    private FragmentArticleDetailsBinding binder;


    public static ArticleDetailsFragment newInstance() {
        ArticleDetailsFragment instance = new ArticleDetailsFragment();
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binder = DataBindingUtil.inflate(inflater, R.layout.fragment_article_details, container, false);
        View view = binder.getRoot();
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        Bundle bundle = getArguments();
        if (bundle != null) {
            Article article = bundle.getParcelable("article");
            if (article != null)
                binder.setImageUrl(article.getBiggestThumb());
                binder.setArticle(article);
        }
    }




}
