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
import com.shakatreh.nytimes.R;
import com.shakatreh.nytimes.databinding.FragmentArticlesBinding;
import com.shakatreh.nytimes.ui.MainActivity;


public class ArticlesFragment extends Fragment {

    public static final String TAG  = "ArticlesFragment";

    private FragmentArticlesBinding binding;

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
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
