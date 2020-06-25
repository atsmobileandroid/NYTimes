package com.shakatreh.nytimes.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.net.InetAddress;

public class NetworkConnectionInterceptor implements Interceptor {

    private Context context;

    public NetworkConnectionInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (!isInternetAvailable())
            throw new NoConnectivityException();

        Request.Builder builder = chain.request().newBuilder();
        return chain.proceed(builder.build());
    }

    public boolean isInternetAvailable() {
        try {
            InetAddress inetAddress = InetAddress.getByName("google.com");
            return inetAddress != null && !inetAddress.equals("");
        } catch (Exception e) {
            return false;
        }
    }


}

