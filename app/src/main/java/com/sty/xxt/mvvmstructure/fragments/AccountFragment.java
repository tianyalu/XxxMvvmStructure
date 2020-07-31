package com.sty.xxt.mvvmstructure.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sty.xxt.mvvmstructure.R;
import com.sty.xxt.mvvmstructure.databinding.FragmentAccountBinding;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;


public class AccountFragment extends Fragment {
    FragmentAccountBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_account, container, false);
        mBinding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*                CCResult result = CC.obtainBuilder("UserCenter")  .setActionName("login")
                        .build().call();*/

            }
        });
        return mBinding.getRoot();
    }
}
