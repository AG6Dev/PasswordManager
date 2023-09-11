package dev.ag6.passwordmanager.model;

import com.google.gson.annotations.Expose;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(callSuper = true)
@Data
public class Account extends StackPane {
    private final Label usernameLabel, websiteNameLabel, websiteUrlLabel, notesLabel;
    @Getter
    private final Label passwordLabel;
    private final VBox leftBox, rightBox;

    @Expose
    private String username, password, websiteName, websiteUrl, notes;
    @Expose
    private long timestamp;

    public Account(String username, String password, String websiteUrl, String websiteName, String notes, long timestamp) {
        this.username = username;
        this.password = password;
        this.websiteUrl = websiteUrl;
        this.websiteName = websiteName;
        this.notes = notes;
        this.timestamp = timestamp;

        this.setBackground(new Background(new BackgroundFill(Color.RED, new CornerRadii(10D), Insets.EMPTY)));

        this.leftBox = new VBox();
        this.leftBox.setSpacing(10.0D);
        this.leftBox.setAlignment(Pos.CENTER_LEFT);
        this.leftBox.setPadding(new Insets(0, 0, 0, 10));

        this.usernameLabel = new Label(this.getUsername());
        this.passwordLabel = new Label(this.getPassword());
        this.websiteNameLabel = new Label(this.getWebsiteName());
        this.websiteUrlLabel = new Label(this.getWebsiteUrl());

        this.passwordLabel.setEffect(new GaussianBlur(7.5D));
        this.passwordLabel.hoverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                this.passwordLabel.setEffect(null);
                return;
            }

            this.passwordLabel.setEffect(new GaussianBlur(7.5D));
        });

        this.rightBox = new VBox();
        this.rightBox.setAlignment(Pos.CENTER_RIGHT);
        this.notesLabel = new Label(this.getNotes());


        this.leftBox.getChildren().addAll(usernameLabel, passwordLabel, websiteNameLabel, websiteUrlLabel);
        this.rightBox.getChildren().add(notesLabel);

        this.getChildren().addAll(leftBox, rightBox);

        this.setPrefWidth(200.0D);
        this.setPrefHeight(200.0D);
    }
}
