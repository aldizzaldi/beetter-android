package com.example.beetter.ui.login;

import android.content.Intent;
import android.widget.Toast;

import com.example.beetter.NavigationActivity;
import com.example.beetter.SharedPrefUtils;
import com.example.beetter.data.api.ApiRetrofit;
import com.example.beetter.data.api.IApiEndPoint;
import com.example.beetter.model.response.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {

    private ILoginVIew view;
    private final IApiEndPoint apiEndPoint = ApiRetrofit.getInstance().create(IApiEndPoint.class);


    public LoginPresenter(ILoginVIew view) {
        this.view = view;
    }

    void doLogin(String txtEmail, String txtPassword){
        apiEndPoint.login(txtEmail,txtPassword).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                String token;
                token = response.body().getToken();
                view.moveToTeamList();
                SharedPrefUtils.setStringSharedPref("token", "Bearer " + token);
                SharedPrefUtils.setStringSharedPref("email", txtEmail);
//                view.showMessage(token);
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                view.showMessage(t.getMessage());
            }
        });

    }
}
