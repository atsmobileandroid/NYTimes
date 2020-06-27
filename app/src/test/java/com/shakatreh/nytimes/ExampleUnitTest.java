package com.shakatreh.nytimes;

import com.shakatreh.nytimes.model.article.ArticlesResponse;
import com.shakatreh.nytimes.net.APIPaths;
import com.shakatreh.nytimes.net.ServiceProvider;
import com.shakatreh.nytimes.util.Constants;
import com.shakatreh.nytimes.viewmodel.ArticlesViewModel;
import io.reactivex.Single;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.TestObserver;
import okhttp3.OkHttpClient;
import org.junit.Before;
import org.junit.Test;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {


    private Retrofit retrofit;
    public TestObserver articlesObserver;


    @Before
    public void setUp() {
        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(new OkHttpClient.Builder()
                        .readTimeout(20, TimeUnit.SECONDS)
                        .connectTimeout(20, TimeUnit.SECONDS)
                        .build()).build();
        articlesObserver = new TestObserver<ArticlesResponse>();
    }


    @Test
    public void checkArticlesApiCalling() {
        APIPaths apiPaths = retrofit.create(APIPaths.class);
        apiPaths.getArticles(Constants.API_KEY).subscribe(articlesObserver);
        articlesObserver.assertValue(new Predicate() {
            @Override
            public boolean test(Object o) throws Exception {
                ArticlesResponse testedResponse = (ArticlesResponse) o;
                return testedResponse.getStatus().equals("OK");
            }
        });
    }
}