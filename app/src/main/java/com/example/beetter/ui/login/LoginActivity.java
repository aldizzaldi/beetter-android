package com.example.beetter.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.beetter.NavigationActivity;
import com.example.beetter.R;
import com.example.beetter.data.api.ApiRetrofit;
import com.example.beetter.data.api.IApiEndPoint;
import com.example.beetter.model.response.LoginResponse;
import com.example.beetter.ui.listteam.ListTeamActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements ILoginVIew{

    @BindView(R.id.username)
    EditText email;

    @BindView(R.id.password)
    EditText password;

    @BindView(R.id.btnLogin)
    Button btnLogin;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ButterKnife.bind(this);

        presenter = new LoginPresenter(this);
    }

    @OnClick(R.id.btnLogin)
    public void onBtnLoginClicked(){
        String username = email.getText().toString();
        String pwd = password.getText().toString();

        presenter.doLogin(username,pwd);
    }

    @Override
    public void moveToTeamList() {
        Intent intent = new Intent(getApplicationContext(), ListTeamActivity.class);
        startActivity(intent);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
