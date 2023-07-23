package dev.ag6.passwordmanager.controller;

import dev.ag6.passwordmanager.PasswordManager;
import dev.ag6.passwordmanager.view.CreateAccountView;
import dev.ag6.passwordmanager.view.HomeView;

public class HomeController extends Controller<HomeView> {
    public HomeController(HomeView view) {
        super(view);
    }

    @Override
    public void initialize() {
        this.view.getCreateButton().setOnAction(event -> {
            CreateAccountView createAccountView = new CreateAccountView();
            CreateAccountController createAccountController = new CreateAccountController(this, createAccountView);
            PasswordManager.changeView(createAccountView, createAccountController);
        });
    }
}
