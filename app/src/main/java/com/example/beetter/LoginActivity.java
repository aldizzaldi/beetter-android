package com.example.beetter;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.beetter.data.api.ApiRetrofit;
import com.example.beetter.data.api.IApiEndPoint;
import com.example.beetter.model.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private String token;
    private EditText email;
    private EditText password;
    private String txtEmail;
    private String txtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        email = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        btnLogin = (Button)findViewById(R.id.buttonLogin);


        final IApiEndPoint apiEndPoint = ApiRetrofit.getInstance().create(IApiEndPoint.class);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtEmail = email.getText().toString();
                txtPassword = password.getText().toString();

                apiEndPoint.login(txtEmail,txtPassword).enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        token = response.body().getToken();
                        Toast.makeText(getApplicationContext(),"berhasil login",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });

    }
}
