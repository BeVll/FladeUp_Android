package com.bevl.fladeup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.bevl.fladeup.adapters.UserAdapter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bevl.fladeup.constants.Urls;
import com.bevl.fladeup.dto.User.UserModelDTO;
import com.bevl.fladeup.service.ApplicationNetwork;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context contest = this;

        ApplicationNetwork
                .getInstance()
                .getUsersApi()
                .list()
                .enqueue(new Callback<List<UserModelDTO>>() {
                    @Override
                    public void onResponse(Call<List<UserModelDTO>> call, Response<List<UserModelDTO>> response) {

                        Log.d("Get OK", response.body().toString());
                        if(response.isSuccessful()) {
                            List<UserModelDTO> listTmp = response.body();


                            ListView listViewUsers = findViewById(R.id.listViewUsers);
                            UserAdapter arrayAdapter = new UserAdapter(listTmp, contest);
                            listViewUsers.setAdapter(arrayAdapter);


                            Log.d("Get OK", Integer.toString(listTmp.stream().findFirst().get().getId()));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<UserModelDTO>> call, Throwable t) {
                        Log.d("fdas", t.toString());
                        Log.d("call", call.request().url().toString());
                    }
                });
    }
}