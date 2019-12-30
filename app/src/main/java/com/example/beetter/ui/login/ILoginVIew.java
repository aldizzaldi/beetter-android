package com.example.beetter.ui.login;

public interface ILoginVIew {
    void moveToTeamList();
    void showMessage(String message);

    void showLoading();
    void hideLoading();
    void showError();
}
