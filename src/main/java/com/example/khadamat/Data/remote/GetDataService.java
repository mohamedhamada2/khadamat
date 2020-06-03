package com.example.khadamat.Data.remote;



import com.example.khadamat.Data.Model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface GetDataService {

    @FormUrlEncoded
    @POST("api/register")
    Call<User> register_user(@Field("user_name") String user_name,
                             @Field("password") String password,
                             @Field("national_num") String national_num,
                             @Field("phone") String phone,
                             @Field("adress") String adress);
    @FormUrlEncoded
    @POST("api/login")
    Call<User>login_user(@Field("phone")String phone,@Field("password")String password);
}
