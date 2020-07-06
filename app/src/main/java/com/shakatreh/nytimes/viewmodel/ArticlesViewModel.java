package com.shakatreh.nytimes.viewmodel;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.test.espresso.idling.CountingIdlingResource;

import com.shakatreh.nytimes.model.article.ArticlesResponse;
import com.shakatreh.nytimes.net.ServiceProvider;
import com.shakatreh.nytimes.util.Constants;
import com.shakatreh.nytimes.util.EspressoIdlingResources;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ArticlesViewModel extends AndroidViewModel {

    private static final String TAG = "ArticlesViewModel";


    private CompositeDisposable disposables;
    public MutableLiveData<ArticlesResponse> data;

    public ArticlesViewModel(@NonNull Application application) {
        super(application);
        disposables = new CompositeDisposable();
        data = new MutableLiveData<>();
    }


    public void getArticles() {
        EspressoIdlingResources.increment();
        ServiceProvider.getInstance().getArticles(Constants.API_KEY)
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
                        EspressoIdlingResources.decrement();
                    }

                    @Override
                    public void onError(Throwable e) {
                        data.setValue(new ArticlesResponse(e));
                        EspressoIdlingResources.decrement();
                    }
                });
    }


    @Override
    protected void onCleared() {
        disposables.clear();
        super.onCleared();
    }

}
