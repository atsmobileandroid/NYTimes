package com.shakatreh.nytimes.ui;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.shakatreh.nytimes.R;
import com.shakatreh.nytimes.ui.fragments.ArticleDetailsFragment;
import com.shakatreh.nytimes.ui.fragments.ArticlesFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialViews();
    }

    private void initialViews() {
        setContentView(R.layout.activity_main);
        setTitle("NY Times Most Popular");
        showFragment(ArticlesFragment.newInstance());
    }


    public void showFragment(Fragment fragment) {
        String tag = null;
        if (fragment != null && fragment.getArguments() != null && fragment.getArguments().getString("TAG") != null)
            tag = fragment.getArguments().getString("TAG");
        else
            return;

        Fragment existFragment = getSupportFragmentManager().findFragmentByTag(tag);

        if (tag.equals(ArticlesFragment.TAG)) {
            hideFragment(ArticleDetailsFragment.TAG);
        } else if (tag.equals(ArticleDetailsFragment.TAG)) {
            hideFragment(ArticlesFragment.TAG);
        }

        if (existFragment != null) {
            getSupportFragmentManager().beginTransaction().show(existFragment).commit();
        } else {
            FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
            fts.add(R.id.container, fragment, tag);
            fts.addToBackStack(tag);
            fts.commit();
        }
    }

    private void hideFragment(String tag) {
        Fragment f = getSupportFragmentManager().findFragmentByTag(tag);
        if (f != null)
            getSupportFragmentManager().beginTransaction().hide(f).commit();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }
}
