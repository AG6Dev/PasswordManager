package dev.ag6.passwordmanager.components;

import dev.ag6.passwordmanager.model.Account;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class AccountView extends StackPane {
    private final Account account;

    private final Label label;

    public AccountView(Account account) {
        this.account = account;

        setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));

        this.label = new Label(account.getUsername());
        label.setAlignment(Pos.CENTER);


        getChildren().add(label);

        setPrefWidth(200.0D);
        setPrefHeight(200.0D);
    }
}
