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
            var account = new Account("New Account", "New Username", "New Password", "sweoiyfghuiw");
            accounts.add(new AccountView(account));

            System.out.println(accounts);
        });

        view.getAccountList().setItems(accounts);
    }
}
