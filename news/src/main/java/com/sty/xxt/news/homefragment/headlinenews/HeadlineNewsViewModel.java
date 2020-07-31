package com.sty.xxt.news.homefragment.headlinenews;


import com.sty.xxt.base.viewmodel.MvvmBaseViewModel;

public class HeadlineNewsViewModel extends MvvmBaseViewModel<ChannelsModel, ChannelsModel.Channel> {
    public HeadlineNewsViewModel(){
        model = new ChannelsModel();
        model.register(this);
        model.getCachedDataAndLoad();
    }
}
