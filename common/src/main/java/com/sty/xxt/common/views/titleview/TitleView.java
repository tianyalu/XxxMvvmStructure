package com.sty.xxt.common.views.titleview;

import android.content.Context;
import android.view.View;

import com.sty.xxt.base.customview.BaseCustomView;
import com.sty.xxt.common.R;
import com.sty.xxt.common.databinding.TitleViewBinding;
import com.sty.xxt.webview.WebviewActivity;

public class TitleView extends BaseCustomView<TitleViewBinding, TitleViewViewModel> {
    public TitleView(Context context) {
        super(context);
    }

    @Override
    public int setViewLayoutId() {
        return R.layout.title_view;
    }

    @Override
    public void setDataToView(TitleViewViewModel data) {
        getDataBinding().setViewModel(data);
    }

    @Override
    public void onRootClick(View view) {
        WebviewActivity.startCommonWeb(view.getContext(), "", getViewModel().jumpUri);
    }
}
