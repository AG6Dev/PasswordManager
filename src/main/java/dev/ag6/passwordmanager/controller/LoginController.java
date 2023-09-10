package dev.ag6.passwordmanager.controller;

import dev.ag6.passwordmanager.AccountManager;
import dev.ag6.passwordmanager.PasswordManager;
import dev.ag6.passwordmanager.view.HomeView;
import dev.ag6.passwordmanager.view.LoginView;

public class LoginController extends Controller<LoginView> {
    public LoginController(LoginView view) {
        super(view);
    }

    @Override
    public void initialize() {
        boolean isFirstTime = AccountManager.INSTANCE.isFirstTime();

        if (isFirstTime) {
            this.view.getPromptLabel().setText("Please enter a master password to use for this application.");
        } else {
            this.view.getPromptLabel().setText("Please enter your master password.");
        }

        this.view.getContinueButton().setOnAction(event -> {
            boolean result = AccountManager.INSTANCE.login(this.view.getPasswordField().getText(), isFirstTime);
            if(result) {
                var homeView = new HomeView();
                var homeController = new HomeController(homeView);
                PasswordManager.changeView(homeView, homeController);

                return;
            }
            this.view.getPromptLabel().setText("Unable to login. Check master password and try again.");
        });
    }
}
