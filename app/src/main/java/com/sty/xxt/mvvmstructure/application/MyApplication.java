package com.sty.xxt.mvvmstructure.application;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.kingja.loadsir.core.LoadSir;
import com.sty.xxt.base.loadsir.CustomCallback;
import com.sty.xxt.base.loadsir.EmptyCallback;
import com.sty.xxt.base.loadsir.ErrorCallback;
import com.sty.xxt.base.loadsir.LoadingCallback;
import com.sty.xxt.base.loadsir.TimeoutCallback;
import com.sty.xxt.base.preference.PreferencesUtil;
import com.sty.xxt.base.utils.ToastUtil;
import com.sty.xxt.network.base.NetworkApi;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        PreferencesUtil.init(this);
        NetworkApi.init(new XxtNetwork(this));
        ToastUtil.init(this);
        ARouter.init(this);
        ARouter.openDebug();
        ARouter.openLog();
        LoadSir.beginBuilder()
                .addCallback(new ErrorCallback())//添加各种状态页
                .addCallback(new EmptyCallback())
                .addCallback(new LoadingCallback())
                .addCallback(new TimeoutCallback())
                .addCallback(new CustomCallback())
                .setDefaultCallback(LoadingCallback.class)//设置默认状态页
                .commit();
    }
}
