package com.example.khadamat.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.khadamat.Activities.Home;
import com.example.khadamat.Data.Model.User;
import com.example.khadamat.Data.local.MySharedPreference;
import com.example.khadamat.Data.remote.GetDataService;
import com.example.khadamat.Data.remote.RetrofitClientInstance;
import com.example.khadamat.Utilities.Utilities;

import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserViewModel extends Observable {
    MySharedPreference mprefs;
    Context context;

    public UserViewModel(Context context) {
        this.context = context;
    }

    public void sendRegisterRequest(String name, String password, String nationalnum, String phone, String address) {
        Log.e("test",name);
        Toast.makeText(context, "lllllll", Toast.LENGTH_SHORT).show();
        if (Utilities.isNetworkAvailable(context)) {
            mprefs = MySharedPreference.getInstance();
            GetDataService getDataService = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
            Call<User> call = getDataService.register_user(name, password, nationalnum, phone, address);
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if (response.isSuccessful()) {
                        if (response.body().getSuccess() == 1) {
                            mprefs.Create_Update_UserData(context, response.body());
                            context.startActivity(new Intent(context, Home.class));
                            ((Activity)context).finish();
                            Toast.makeText(context, "تمت تسجيل الدخول بنجاح", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(context, "لقد تم دخولك مسبقا", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {

                }
            });
        }

    }

}