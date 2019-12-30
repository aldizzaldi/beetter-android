package com.example.beetter.ui.profile;

import com.example.beetter.model.User;

public interface IProfileView {
    void showProfile(User profile);
    void showError(String message);
}