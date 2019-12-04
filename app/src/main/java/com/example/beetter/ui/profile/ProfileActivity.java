package com.example.beetter.ui.profile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.beetter.R;
import com.example.beetter.model.User;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileActivity extends AppCompatActivity implements IProfileView {
    @BindView(R.id.username)
    TextView username;

    @BindView(R.id.email)
    TextView email;

    @BindView(R.id.viewName)
    TextView viewName;

    @BindView(R.id.viewUsername)
    TextView viewUsername;

    @BindView(R.id.viewEmail)
    TextView viewEmail;

    private ProfilePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        ButterKnife.bind(this);

        presenter = new ProfilePresenter(this);
        presenter.getProfile();
    }

    @Override
    public void showProfile(User profile) {
        username.setText(profile.getUsername());
        email.setText(profile.getEmail());
        viewName.setText(profile.getName());
        viewUsername.setText(profile.getUsername());
        viewEmail.setText(profile.getEmail());
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
