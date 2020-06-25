package com.shakatreh.nytimes.net;

import com.shakatreh.nytimes.model.article.ArticlesResponse;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIPaths {

    @GET("v2/mostviewed/all-sections/1.json")
    Single<ArticlesResponse> getArticles(@Query("api-key") String apiKey);

}
