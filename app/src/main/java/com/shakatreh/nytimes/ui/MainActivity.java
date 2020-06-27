package com.shakatreh.nytimes.ui;


import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.NavUtils;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.shakatreh.nytimes.R;
import com.shakatreh.nytimes.model.article.Article;
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
        addFragment(ArticlesFragment.newInstance(), false);
    }



    public void showArticleDetails(Article article) {
        ArticleDetailsFragment fragment = ArticleDetailsFragment.newInstance();
        Bundle bundle = new Bundle();
        bundle.putParcelable("article", article);
        fragment.setArguments(bundle);
        addFragment(fragment, true);
    }

    public void addFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
        fts.add(R.id.container, fragment);
        if (addToBackStack) {
            String ssd=fragment.getClass().getSimpleName();
            fts.addToBackStack(fragment.getClass().getSimpleName());
            // add back button to action bar
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        fts.commit();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getSupportFragmentManager().popBackStack();
                // remove the action bar back button
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
