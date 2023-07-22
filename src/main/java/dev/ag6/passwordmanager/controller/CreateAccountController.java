package dev.ag6.passwordmanager.controller;

import dev.ag6.passwordmanager.PasswordManager;
import dev.ag6.passwordmanager.model.Account;
import dev.ag6.passwordmanager.view.CreateAccountView;
import dev.ag6.passwordmanager.view.MainView;
import dev.ag6.passwordmanager.view.OldMainView;

public class CreateAccountController extends Controller<CreateAccountView> {
    public CreateAccountController(CreateAccountView view) {
        super(view);
    }

    public void initialize() {
        this.view.getCancelButton().setOnAction(actionEvent -> {
            var mainView = new MainView();
            var mainController = new MainController(null, mainView);
            PasswordManager.changeView(mainView, mainController);
        });

        this.view.getSaveButton().setOnAction(actionEvent -> {
            var mainView = new OldMainView();
            var mainController = new OldMainController(mainView);
            Account account = new Account(view.getUsernameField().getText(), view.getPasswordField().getText(), view.getWebsiteUrlField().getText(), view.getWebsiteNameField().getText(), view.getNotesArea().getText());

            OldMainController.accounts.add(account);
            mainController.saveAccount(account);

            PasswordManager.changeView(mainView, mainController);
        });
    }
}
