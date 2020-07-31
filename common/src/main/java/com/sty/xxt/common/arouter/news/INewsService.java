package com.sty.xxt.common.arouter.news;

import com.alibaba.android.arouter.facade.template.IProvider;

import androidx.fragment.app.Fragment;

public interface INewsService extends IProvider {
    String NEWS_ROUTER = "/news/";
    String NEWS_SERVICE = NEWS_ROUTER + "news_service";
    Fragment getHeadlineNewsFragment();
}
