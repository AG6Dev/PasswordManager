package dev.ag6.passwordmanager.controller;

import dev.ag6.passwordmanager.PasswordManager;
import dev.ag6.passwordmanager.components.AccountView;
import dev.ag6.passwordmanager.model.Account;
import dev.ag6.passwordmanager.view.CreateAccountView;
import dev.ag6.passwordmanager.view.MainView;

public class CreateAccountController extends Controller<CreateAccountView> {
    public CreateAccountController(CreateAccountView view) {
        super(view);
    }

    public void initialize() {
        this.view.getCancelButton().setOnAction(actionEvent -> {
            var mainView = new MainView();
            var mainController = new MainController(mainView);
            PasswordManager.changeView(mainView, mainController);
        });

        this.view.getSaveButton().setOnAction(actionEvent -> {
            var mainView = new MainView();
            var mainController = new MainController(mainView);
            MainController.accounts.add(new AccountView(new Account(view.getUsernameField().getText(), view.getPasswordField().getText(), view.getWebsiteUrlField().getText(), view.getWebsiteNameField().getText(), view.getNotesArea().getText())));
            PasswordManager.changeView(mainView, mainController);
        });
    }
}
