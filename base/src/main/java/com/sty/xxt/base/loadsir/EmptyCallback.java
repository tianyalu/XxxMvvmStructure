package com.sty.xxt.base.loadsir;

import com.kingja.loadsir.callback.Callback;
import com.sty.xxt.base.R;


public class EmptyCallback extends Callback {

    @Override
    protected int onCreateView() {
        return R.layout.layout_empty;
    }

}
