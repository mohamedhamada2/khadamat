package com.example.khadamat.Activities.Authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.text.TextUtils;


import com.example.khadamat.R;
import com.example.khadamat.databinding.ActivityLoginBinding;
import com.example.khadamat.viewmodel.LoginPresenter;
import com.example.khadamat.viewmodel.LoginViewModel;

import org.w3c.dom.Text;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding activityLoginBinding;
    LoginViewModel loginViewModel;
    String phone, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        activityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        loginViewModel = new LoginViewModel(this);
        activityLoginBinding.setLoginviewmodel(loginViewModel);
        activityLoginBinding.setLoginpresenter(new LoginPresenter() {
            @Override
            public void LoginData() {
                phone = activityLoginBinding.etPhone.getText().toString().trim();
                password = activityLoginBinding.etPassword.getText().toString();
                if(!TextUtils.isEmpty(phone)&& !TextUtils.isEmpty(password))
                loginViewModel.LoginUserRequest(phone,password);
                else {
                    if(TextUtils.isEmpty(phone)){
                        activityLoginBinding.etPhone.setError("ادخل رقم الهاتف");
                    }else {
                        activityLoginBinding.etPhone.setError(null);
                    }
                    if(TextUtils.isEmpty(password)){
                        activityLoginBinding.etPassword.setError("ادخل كلمة المرور");
                    }else {
                        activityLoginBinding.etPassword.setError(null);
                    }
                }
            }
        });
    }
}