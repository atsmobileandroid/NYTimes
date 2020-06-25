package com.shakatreh.nytimes.ui.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.shakatreh.nytimes.R;
import com.shakatreh.nytimes.ui.MainActivity;
import com.shakatreh.nytimes.viewmodel.ArticlesViewModel;


public class ArticleDetailsFragment extends Fragment {

    public static final String TAG  = "ArticleDetailsFragment";

    public static ArticleDetailsFragment newInstance() {
        ArticleDetailsFragment instance = new ArticleDetailsFragment();
        final Bundle args = new Bundle();
        args.putString("TAG", TAG);
        instance.setArguments(args);
        return instance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_article_details, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
