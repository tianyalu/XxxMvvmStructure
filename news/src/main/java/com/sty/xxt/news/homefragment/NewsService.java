package com.sty.xxt.news.homefragment;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.sty.xxt.common.arouter.news.INewsService;
import com.sty.xxt.news.homefragment.headlinenews.HeadlineNewsFragment;

import androidx.fragment.app.Fragment;

@Route(path = INewsService.NEWS_SERVICE)
public class NewsService implements INewsService {
    @Override
    public void init(Context context) {

    }

    @Override
    public Fragment getHeadlineNewsFragment() {
        return new HeadlineNewsFragment();
    }
}
