package dev.ag6.passwordmanager.controller;

import dev.ag6.passwordmanager.components.AccountView;
import dev.ag6.passwordmanager.model.Account;
import dev.ag6.passwordmanager.view.MainView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MainController {
    private final MainView view;

    private final ObservableList<AccountView> accounts = FXCollections.observableArrayList();

    public MainController(MainView view) {
        this.view = view;
    }

    public void initialize() {
        view.getAddButton().setOnAction(actionEvent -> {
            var account = new Account("name", "password", "https://www.google.com", "google", "wpofjsweuihfweoig");
            var account2 = new Account("name", "password", "https://www.google.com", "facebook", "wpofjsweuihfweoig");
            accounts.addAll(new AccountView(account), new AccountView(account2));

            System.out.println(accounts);
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
