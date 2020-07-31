package com.sty.xxt.mvvmstructure.application;

//注意：这里要用app的，不要用子模块的BuildConfig
import android.app.Application;

import com.sty.xxt.mvvmstructure.BuildConfig;
import com.sty.xxt.network.base.INetworkRequiredInfo;

public class XxtNetwork implements INetworkRequiredInfo {
    private Application mApplication;

    public XxtNetwork(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Override
    public String getAppVersionName() {
        return BuildConfig.VERSION_NAME;
    }

    @Override
    public String getAppVersionCode() {
        return String.valueOf(BuildConfig.VERSION_CODE);
    }

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    @Override
    public Application getApplicationContext() {
        return mApplication;
    }
}
