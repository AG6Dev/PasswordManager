package dev.ag6.passwordmanager.controller;

import dev.ag6.passwordmanager.PasswordManager;
import dev.ag6.passwordmanager.components.AccountView;
import dev.ag6.passwordmanager.model.Account;
import dev.ag6.passwordmanager.view.CreateAccountView;
import dev.ag6.passwordmanager.view.MainView;

public class CreateAccountController {
    private final CreateAccountView view;

    public CreateAccountController(CreateAccountView view) {
        this.view = view;
    }

    public void initialize() {
        view.getCancelButton().setOnAction(actionEvent -> {
            var mainView = new MainView();
            var mainController = new MainController(mainView);
            PasswordManager.getManager().getRoot().getChildren().clear();
            PasswordManager.getManager().getRoot().setCenter(view.getRoot());
            mainController.initialize();
        });

        view.getSaveButton().setOnAction(actionEvent -> {
            var mainView = new MainView();
            var mainController = new MainController(mainView);

            MainController.accounts.add(new AccountView(new Account(view.getUsernameField().getText(), view.getPasswordField().getText(), view.getWebsiteUrlField().getText(), view.getWebsiteNameField().getText(), view.getNotesArea().getText())));

            PasswordManager.getManager().getRoot().getChildren().clear();
            PasswordManager.getManager().getRoot().setCenter(mainView.getRoot());
            mainController.initialize();
        });
    }
}
