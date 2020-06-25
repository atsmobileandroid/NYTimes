package com.shakatreh.nytimes.viewmodel;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.shakatreh.nytimes.model.article.ArticlesResponse;
import com.shakatreh.nytimes.net.ServiceProvider;
import com.shakatreh.nytimes.util.Constants;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ArticlesViewModel extends AndroidViewModel {

    private static final String TAG = "ArticlesViewModel";

    private Context context;
    private CompositeDisposable disposables;
    public MutableLiveData<ArticlesResponse> data;

    public ArticlesViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
        disposables = new CompositeDisposable();
        data = new MutableLiveData<>();
    }


    public void getArticles() {
        ServiceProvider.getInstance(context).getArticles(Constants.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<ArticlesResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposables.add(d);
                    }

                    @Override
                    public void onSuccess(ArticlesResponse articlesResponse) {
                        data.setValue(articlesResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        data.setValue(new ArticlesResponse(e));
                    }
                });
    }


    @Override
    protected void onCleared() {
        disposables.clear();
        super.onCleared();
    }

}
