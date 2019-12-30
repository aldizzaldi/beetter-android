package com.example.beetter.ui.login;

import android.content.Intent;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.example.beetter.NavigationActivity;
import com.example.beetter.R;
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
        view.showLoading();
        apiEndPoint.login(txtEmail,txtPassword).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                String token;

                if(response.isSuccessful()){
                    token = "Bearer " + response.body().getToken();
                    SharedPrefUtils.setStringSharedPref("token", token);
                    SharedPrefUtils.setStringSharedPref("email", txtEmail);
                    Log.e("hiyaLogin", "response e berhasil lo");
                    view.hideLoading();
                    view.moveToTeamList();
                }
                else{
                    view.hideLoading();
                    view.showMessage("Password atau username salah");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                view.showMessage(t.getMessage());
            }
        });
    }

    void showError(){
        view.showMessage("Field username atau password kosong");
        view.showError();
    }
}
