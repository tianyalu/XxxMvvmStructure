package com.sty.xxt.network.commoninterceptor;

import com.sty.xxt.network.base.INetworkRequiredInfo;
import com.sty.xxt.network.utils.TencentUtil;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class CommonRequestInterceptor implements Interceptor {
    private INetworkRequiredInfo requiredInfo;

    public CommonRequestInterceptor(INetworkRequiredInfo requiredInfo) {
        this.requiredInfo = requiredInfo;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        builder.addHeader("os", "android");
        builder.addHeader("appVersion", this.requiredInfo.getAppVersionName());
        builder.addHeader("appVersionCode", this.requiredInfo.getAppVersionCode());
        return chain.proceed(builder.build());
    }
}
