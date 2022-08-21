package com.symboljoyful.morse.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.symboljoyful.morse.base.BaseActivity;
import com.symboljoyful.morse.databinding.ActivityLoginBinding;
import com.symboljoyful.morse.ui.component.WebViewActivity;
import com.symboljoyful.morse.utils.AntiShakeUtils;
import com.symboljoyful.morse.ui.utils.ToastUtil;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private ActivityLoginBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityLoginBinding.inflate(getLayoutInflater());

        setContentView(mBinding.getRoot());
        initView();
    }
    private void initView(){
        bindClick();
    }
    private void bindClick(){
        mBinding.loginBtn.setOnClickListener(this);
        mBinding.registerText.setOnClickListener(this);
        mBinding.userServiceAgreemen.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Log.v("loginActivity","按钮点击");
        if (AntiShakeUtils.isInvalidClick(v)) return;
        //判断ID
        if (v.getId() == mBinding.loginBtn.getId()) {
            if(!mBinding.agreementCheckBox.isChecked()){
                ToastUtil.centerToast(this, "请先勾选同意后再进行操作！");
                return;
            }
            if (TextUtils.isEmpty(mBinding.account.getText().toString().trim())) {
                ToastUtil.centerToast(this, "请输入账号！");
                return;
            }
            if (TextUtils.isEmpty(mBinding.password.getText().toString().trim())) {
                ToastUtil.centerToast(this, "请输入密码！");
                return;
            }
        }else if(v.getId() == mBinding.registerText.getId()){
            Intent intent = new Intent();
            intent.setClass(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        }else if(v.getId() == mBinding.userServiceAgreemen.getId()){

            Intent intent = new Intent();
            intent.setClass(LoginActivity.this, WebViewActivity.class);
            WebViewActivity.url = "https://www.baidu.com";
            startActivity(intent);
        }
    }
}