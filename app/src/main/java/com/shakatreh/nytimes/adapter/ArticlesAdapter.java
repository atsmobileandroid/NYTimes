package com.shakatreh.nytimes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.shakatreh.nytimes.databinding.RowArticleBinding;
import com.shakatreh.nytimes.model.article.Article;
import com.shakatreh.nytimes.ui.MainActivity;
import java.util.ArrayList;
import java.util.List;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ArticleViewHolder> {

    private Context context;
    private List<Article> articles;

    public ArticlesAdapter(Context context) {
        this.context = context;
        articles = new ArrayList<>();
    }


    public void setData(List<Article> articles) {
        this.articles = articles;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RowArticleBinding itemBinding = RowArticleBinding.inflate(layoutInflater, parent, false);
        return new ArticleViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Article article = articles.get(position);
        holder.bind(article);
    }


    public class ArticleViewHolder extends RecyclerView.ViewHolder {
        private RowArticleBinding binder;

        public ArticleViewHolder(RowArticleBinding binding) {
            super(binding.getRoot());
            this.binder = binding;
            this.binder.setHandler(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    ((MainActivity)context).showArticleDetails(articles.get(getAdapterPosition()));
                }
            });
        }

        public void bind(Article article) {
            binder.setArticle(article);
            binder.setImageUrl(article.getSmallestThumb());
        }
    }


    public interface OnClickListener {
        void onClick(View v);
    }
}
