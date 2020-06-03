package com.example.khadamat.Activities.Authentication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.khadamat.R;
import com.example.khadamat.databinding.ActivityRegisterationBinding;
import com.example.khadamat.viewmodel.Presenter;
import com.example.khadamat.viewmodel.UserViewModel;

public class RegisterationActivity extends AppCompatActivity {
    ActivityRegisterationBinding activityRegisterationBinding;
    UserViewModel userviewModel;
    String name,phone,password,address,nationalnum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        activityRegisterationBinding = DataBindingUtil.setContentView(this,R.layout.activity_registeration);
        userviewModel = new UserViewModel(this);
        activityRegisterationBinding.setUsermodel(userviewModel);
        activityRegisterationBinding.setPresenter(new Presenter() {
            @Override
            public void RegisterData() {
                name = activityRegisterationBinding.etUsername.getText().toString();
                phone = activityRegisterationBinding.etUserPhone.getText().toString();
                password = activityRegisterationBinding.etPassword.getText().toString();
                nationalnum = activityRegisterationBinding.etUserNationalNum.getText().toString();
                address = activityRegisterationBinding.etUserAddress.getText().toString();
                /*if (!TextUtils.isEmpty(name) && password.length() >= 6
                        && !TextUtils.isEmpty(nationalnum) && phone.length() == 10
                        && !TextUtils.isEmpty(address)) {*/
                    userviewModel.sendRegisterRequest(name, password, nationalnum, phone, address);
                /*} else {
                    if (TextUtils.isEmpty(name)) {
                        activityRegisterationBinding.etUsername.setError(getResources().getString(R.string.validate_name));
                    } else {
                        activityRegisterationBinding.etUsername.setError(null);
                    }
                    if (TextUtils.isEmpty(nationalnum)) {
                        activityRegisterationBinding.etUserNationalNum.setError(getResources().getString(R.string.validate_national_num));
                    } else {
                        activityRegisterationBinding.etUserNationalNum.setError(null);
                    }
                    if (TextUtils.isEmpty(address)) {
                        activityRegisterationBinding.etUserAddress.setError(getResources().getString(R.string.validate_address));
                    } else {
                        activityRegisterationBinding.etUserAddress.setError(null);
                    }
                    if (activityRegisterationBinding.etPassword.length() < 6) {
                        activityRegisterationBinding.etPassword.setError(getResources().getString(R.string.validate_password));
                    } else {
                        activityRegisterationBinding.etPassword.setError(null);
                    }
                    if (activityRegisterationBinding.etUserPhone.length() != 11) {
                        activityRegisterationBinding.etUserPhone.setError(getResources().getString(R.string.validate_phone));
                    } else {
                        activityRegisterationBinding.etUserPhone.setError(null);
                    }
                }*/
            }
        });
        }
}
