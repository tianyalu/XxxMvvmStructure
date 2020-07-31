package com.sty.xxt.network.commoninterceptor;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

public class CommonResponsetInterceptor implements Interceptor {
    private static final String TAG = CommonResponsetInterceptor.class.getSimpleName();
    @Override
    public Response intercept(Chain chain) throws IOException {
        long requestTime = System.currentTimeMillis();
        Response response = chain.proceed(chain.request());
        Log.d("TAG", "requestTime = " + (System.currentTimeMillis() - requestTime));
        return response;
    }
}
