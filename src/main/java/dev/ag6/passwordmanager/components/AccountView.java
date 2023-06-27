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

        this.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

        this.usernameLabel = new Label(account.getUsername());
        this.websiteNameLabel = new Label(account.getWebsiteName());
        this.websiteUrlLabel = new Label(account.getWebsiteUrl());

        this.getChildren().addAll(usernameLabel, websiteNameLabel, websiteUrlLabel);

        this.setPrefWidth(200.0D);
        this.setPrefHeight(200.0D);
    }

    public Account getAccount() {
        return account;
    }
}
