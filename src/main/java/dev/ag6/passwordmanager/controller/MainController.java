package dev.ag6.passwordmanager.controller;

import dev.ag6.passwordmanager.PasswordManager;
import dev.ag6.passwordmanager.components.AccountView;
import dev.ag6.passwordmanager.model.Account;
import dev.ag6.passwordmanager.view.CreateAccountView;
import dev.ag6.passwordmanager.view.MainView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainController extends Controller<MainView> {
    public static final ObservableList<AccountView> accounts = FXCollections.observableArrayList();

    public MainController(MainView view) {
        super(view);
    }

    public void initialize() {
        view.getAddButton().setOnAction(actionEvent -> {
            var createAccountView = new CreateAccountView();
            var createAccountController = new CreateAccountController(createAccountView);
            PasswordManager.changeView(createAccountView, createAccountController);
        });

        view.getSearchField().textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                view.getAccountList().setItems(accounts);
            } else {
                ObservableList<AccountView> filteredAccounts = FXCollections.observableArrayList();
                for (AccountView account : accounts) {
                    if (account.getAccount().getWebsiteName().toLowerCase().contains(newValue.toLowerCase())) {
                        filteredAccounts.add(account);
                    }
                }
                view.getAccountList().setItems(filteredAccounts);
            }
        });
        view.getAccountList().setItems(accounts);
    }
}
