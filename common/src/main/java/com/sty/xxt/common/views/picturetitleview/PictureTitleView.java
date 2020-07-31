package com.sty.xxt.common.views.picturetitleview;

import android.content.Context;
import android.view.View;

import com.sty.xxt.base.customview.BaseCustomView;
import com.sty.xxt.common.R;
import com.sty.xxt.common.databinding.PictureTitleViewBinding;
import com.sty.xxt.webview.WebviewActivity;

public class PictureTitleView extends BaseCustomView<PictureTitleViewBinding, PictureTitleViewViewModel> {
    public PictureTitleView(Context context) {
        super(context);
    }

    @Override
    public int setViewLayoutId() {
        return R.layout.picture_title_view;
    }

    @Override
    public void setDataToView(PictureTitleViewViewModel data) {
        getDataBinding().setViewModel(data);
    }

    @Override
    public void onRootClick(View view) {
        WebviewActivity.startCommonWeb(view.getContext(), "", getViewModel().jumpUri);
    }
}
