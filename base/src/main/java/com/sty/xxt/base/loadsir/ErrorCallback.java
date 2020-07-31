package com.sty.xxt.base.loadsir;


import com.kingja.loadsir.callback.Callback;
import com.sty.xxt.base.R;


public class ErrorCallback extends Callback {
    @Override
    protected int onCreateView() {
        return R.layout.layout_error;
    }
}
