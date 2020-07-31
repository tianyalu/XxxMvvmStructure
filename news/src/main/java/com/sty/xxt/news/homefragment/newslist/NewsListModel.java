package com.sty.xxt.news.homefragment.newslist;


import com.sty.xxt.base.customview.BaseCustomViewModel;
import com.sty.xxt.base.model.MvvmBaseModel;
import com.sty.xxt.common.views.picturetitleview.PictureTitleViewViewModel;
import com.sty.xxt.common.views.titleview.TitleViewViewModel;
import com.sty.xxt.network.TencentNetworkApi;
import com.sty.xxt.network.observer.BaseObserver;
import com.sty.xxt.news.homefragment.api.NewsApiInterface;
import com.sty.xxt.news.homefragment.api.NewsListBean;

import java.util.ArrayList;

public class NewsListModel extends MvvmBaseModel<NewsListBean, ArrayList<BaseCustomViewModel>> {
    private String mChannelId = "";
    private String mChannelName = "";

    public NewsListModel(String channelId, String channelName) {
        super(NewsListBean.class, true, "pref_key_news_" + channelId, null, 1);
        mChannelId = channelId;
        mChannelName = channelName;
    }

    @Override
    public void refresh() {
        isRefresh = true;
        load();
    }

    public void loadNexPage() {
        isRefresh = false;
        load();
    }

    @Override
    protected void load() {
        TencentNetworkApi.getService(NewsApiInterface.class)
                .getNewsList(mChannelId, mChannelName, String.valueOf(isRefresh ? 1 : pageNumber))
                .compose(TencentNetworkApi.
                        getInstance().
                        applySchedulers(new BaseObserver<NewsListBean>(this, this)));
    }

    @Override
    public void onSuccess(NewsListBean newsListBean, boolean isFromCache) {
        ArrayList<BaseCustomViewModel> baseViewModels = new ArrayList<>();
        for (NewsListBean.Contentlist source : newsListBean.showapiResBody.pagebean.contentlist) {
            if (source.imageurls != null && source.imageurls.size() > 1) {
                PictureTitleViewViewModel viewModel = new PictureTitleViewViewModel();
                viewModel.avatarUrl = source.imageurls.get(0).url;
                viewModel.jumpUri = source.link;
                viewModel.title = source.title;
                baseViewModels.add(viewModel);
            } else {
                TitleViewViewModel viewModel = new TitleViewViewModel();
                viewModel.jumpUri = source.link;
                viewModel.title = source.title;
                baseViewModels.add(viewModel);
            }
        }
        loadSuccess(newsListBean, baseViewModels, isFromCache);
    }

    @Override
    public void onFailure(Throwable e) {
        e.printStackTrace();
        loadFail(e.getMessage());
    }
}
