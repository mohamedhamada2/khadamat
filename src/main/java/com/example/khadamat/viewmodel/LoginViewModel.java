package com.example.khadamat.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.khadamat.Data.Model.User;
import com.example.khadamat.Data.remote.GetDataService;
import com.example.khadamat.Data.remote.RetrofitClientInstance;
import com.example.khadamat.MainActivity;
import com.example.khadamat.Utilities.Utilities;

import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginViewModel extends Observable {
    Context context;

    public LoginViewModel(Context context) {
        this.context = context;
    }

    public void LoginUserRequest(String phone, String password) {
        if(Utilities.isNetworkAvailable(context)){
            GetDataService getDataService = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
            Call<User> call = getDataService.login_user(phone,password);
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if (response.isSuccessful()){
                        if (response.body().getSuccess() == 1){
                            Toast.makeText(context, "login successfully", Toast.LENGTH_SHORT).show();
                            context.startActivity(new Intent(context, MainActivity.class));
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
