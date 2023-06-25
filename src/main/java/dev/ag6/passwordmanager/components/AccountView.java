package dev.ag6.passwordmanager.components;

import dev.ag6.passwordmanager.model.Account;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class AccountView extends StackPane {
    private final Account account;

    private final Label usernameLabel;
    private final Label websiteNameLabel;
    private final Label websiteUrlLabel;

    public AccountView(Account account) {
        this.account = account;

        setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

        usernameLabel = new Label(account.getUsername());
        websiteNameLabel = new Label(account.getWebsiteName());
        websiteUrlLabel = new Label(account.getWebsiteUrl());

        getChildren().addAll(usernameLabel, websiteNameLabel, websiteUrlLabel);

        setPrefWidth(200.0D);
        setPrefHeight(200.0D);
    }

    public Account getAccount() {
        return account;
    }
}
