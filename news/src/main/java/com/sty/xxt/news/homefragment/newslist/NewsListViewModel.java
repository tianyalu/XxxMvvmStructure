package com.sty.xxt.news.homefragment.newslist;

import com.sty.xxt.base.customview.BaseCustomViewModel;
import com.sty.xxt.base.viewmodel.MvvmBaseViewModel;

public class NewsListViewModel extends MvvmBaseViewModel<NewsListModel, BaseCustomViewModel> {
    public NewsListViewModel init(String classId, String lboClassId) {
        model = new NewsListModel(classId, lboClassId);
        model.register(this);
        model.getCachedDataAndLoad();
        return this;
    }

    public void tryToLoadNextPage() {
        model.loadNexPage();
    }
}
