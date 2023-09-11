package dev.ag6.passwordmanager.view;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.font.FontResources;
import io.github.palexdev.materialfx.font.MFXFontIcon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import lombok.Getter;

public class CreateAccountView extends View {
    private final BorderPane contentRoot;

    @Getter
    private final VBox infoLayout;

    @Getter
    private final HBox bottomBar, mainDetailsBox, websiteDetailsBox;

    @Getter
    private final TextField usernameField, passwordField, websiteUrlField, websiteNameField;

    @Getter
    private final TextArea notesArea;

    @Getter
    private final Button backButton, createButton;

    public CreateAccountView() {
        this.contentRoot = new BorderPane();

        // bottom
        this.bottomBar = new HBox();
        this.bottomBar.getStyleClass().add("bottom-bar-hbox");
        this.bottomBar.setAlignment(Pos.CENTER);
        this.bottomBar.setSpacing(10D);

        this.backButton = new MFXButton("Discard", new MFXFontIcon(FontResources.X_ALT.getDescription()));
        this.backButton.getStyleClass().add("back-button");
        this.backButton.setPrefSize(100D, 35D);
        this.backButton.setBackground(new Background(new BackgroundFill(Color.web("#CF6679"), new CornerRadii(10D), Insets.EMPTY)));
        this.backButton.setStyle("-fx-font-size:15");

        this.createButton = new MFXButton("Create", new MFXFontIcon(FontResources.PLUS.getDescription()));
        this.createButton.getStyleClass().add("create-button");
        this.createButton.setPrefSize(100D, 35D);
        this.createButton.setBackground(new Background(new BackgroundFill(Color.web("#BB86FC"), new CornerRadii(10D), Insets.EMPTY)));
        this.createButton.setStyle("-fx-font-size:15");

        this.bottomBar.getChildren().addAll(this.backButton, this.createButton);

        //main

        this.infoLayout = new VBox();
        this.infoLayout.getStyleClass().add("info-layout-vbox");
        this.infoLayout.setBackground(Background.EMPTY);
        this.infoLayout.setAlignment(Pos.TOP_CENTER);
        this.infoLayout.setSpacing(10D);

        this.mainDetailsBox = new HBox();
        this.mainDetailsBox.getStyleClass().add("main-details-hbox");
        this.mainDetailsBox.setAlignment(Pos.CENTER);
        this.usernameField = new MFXTextField();
        this.usernameField.getStyleClass().add("username-field");
        this.usernameField.setPromptText("Username");
        this.usernameField.setPrefSize(200D, 35D);

        this.passwordField = new MFXTextField();
        this.passwordField.getStyleClass().add("password-field");
        this.passwordField.setPromptText("Password");
        this.passwordField.setPrefSize(200D, 35D);

        this.mainDetailsBox.getChildren().addAll(this.usernameField, this.passwordField);
        //website details

        this.websiteDetailsBox = new HBox();
        this.websiteDetailsBox.getStyleClass().add("website-details-hbox");
        this.websiteDetailsBox.setAlignment(Pos.CENTER);
        this.websiteUrlField = new MFXTextField();
        this.websiteUrlField.setPromptText("Website URL");
        this.websiteUrlField.setPrefSize(200D, 35D);

        this.websiteNameField = new MFXTextField();
        this.websiteNameField.getStyleClass().add("website-name-hbox");
        this.websiteNameField.setPromptText("Website Name");
        this.websiteNameField.setPrefSize(200D, 35D);

        this.websiteDetailsBox.getChildren().addAll(this.websiteUrlField, this.websiteNameField);

        //notes
        HBox notesBox = new HBox();
        notesBox.getStyleClass().add("notes-hbox");
        notesBox.setAlignment(Pos.CENTER);
        notesBox.setPrefSize(400D, 200D);
        this.notesArea = new TextArea();
        this.notesArea.setPromptText("Additional Notes...");
        notesBox.setAlignment(Pos.CENTER);

        notesBox.getChildren().add(this.notesArea);

        //other
        HBox labelBox = new HBox();
        labelBox.getStyleClass().add("label-hbox");
        labelBox.setAlignment(Pos.CENTER);

        Label pageLabel = new Label("Add Account");
        pageLabel.getStyleClass().add("info-label");
        pageLabel.setFont(Font.font("Roboto", 24D));
        pageLabel.setTextFill(Color.WHITE);
        pageLabel.setPadding(new Insets(10D));

        labelBox.getChildren().add(pageLabel);

        // add

        this.infoLayout.getChildren().addAll(this.mainDetailsBox, this.websiteDetailsBox, notesBox);

        this.contentRoot.setTop(labelBox);
        this.contentRoot.setCenter(this.infoLayout);
        this.contentRoot.setBottom(this.bottomBar);
    }

    @Override
    public Pane getRoot() {
        return contentRoot;
    }
}
