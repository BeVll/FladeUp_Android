package com.bevl.fladeup.network;


import com.bevl.fladeup.dto.User.UserModelDTO;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UserApi {
    @GET("/User/allUsers")
    public Call<List<UserModelDTO>> list();
}