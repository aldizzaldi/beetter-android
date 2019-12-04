package com.example.beetter.ui.profile;

import com.example.beetter.SharedPrefUtils;
import com.example.beetter.data.api.ApiRetrofit;
import com.example.beetter.data.api.IApiEndPoint;
import com.example.beetter.model.User;
import com.example.beetter.model.response.GetUserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfilePresenter {
    private IProfileView view;
    private final IApiEndPoint apiEndPoint = ApiRetrofit.getInstance().create(IApiEndPoint.class);

    public ProfilePresenter(IProfileView view) {
        this.view = view;
    }

    void getProfile(){
        String token = SharedPrefUtils.getStringSharedPref("token", "");
        apiEndPoint.getLogin(token).enqueue(new Callback<GetUserResponse>() {
            @Override
            public void onResponse(Call<GetUserResponse> call, Response<GetUserResponse> response) {
                if (response.isSuccessful()){
                    User profile = response.body().getUser();
                    view.showProfile(profile);
                }
            }

            @Override
            public void onFailure(Call<GetUserResponse> call, Throwable t) {
                view.showError(t.getMessage());
            }
        });
    }
}
