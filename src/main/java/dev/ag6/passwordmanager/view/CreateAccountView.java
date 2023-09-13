package dev.ag6.passwordmanager.view;

import io.github.palexdev.materialfx.font.FontResources;
import io.github.palexdev.materialfx.font.MFXFontIcon;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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
        this.contentRoot.getStylesheets().add("css/view/createaccount.css");

        this.bottomBar = new HBox();
        this.bottomBar.getStyleClass().add("bottom-bar-hbox");

        this.backButton = new Button("Discard", new MFXFontIcon(FontResources.X_ALT.getDescription()));
        this.backButton.getStyleClass().add("back-button");

        this.createButton = new Button("Create", new MFXFontIcon(FontResources.PLUS.getDescription()));
        this.createButton.getStyleClass().add("create-button");

        this.bottomBar.getChildren().addAll(this.backButton, this.createButton);

        this.infoLayout = new VBox();
        this.infoLayout.getStyleClass().add("info-layout-vbox");

        this.mainDetailsBox = new HBox();
        this.mainDetailsBox.getStyleClass().add("main-details-hbox");

        this.usernameField = new TextField();
        this.usernameField.getStyleClass().add("username-field");
        this.usernameField.setPromptText("Username");

        this.passwordField = new TextField();
        this.passwordField.getStyleClass().add("password-field");
        this.passwordField.setPromptText("Password");

        this.mainDetailsBox.getChildren().addAll(this.usernameField, this.passwordField);

        this.websiteDetailsBox = new HBox();
        this.websiteDetailsBox.getStyleClass().add("website-details-hbox");

        this.websiteUrlField = new TextField();
        this.websiteUrlField.getStyleClass().add("website-url-field");
        this.websiteUrlField.setPromptText("Website URL");

        this.websiteNameField = new TextField();
        this.websiteNameField.setPromptText("Website Name");
        this.websiteNameField.getStyleClass().add("website-name-field");

        this.websiteDetailsBox.getChildren().addAll(this.websiteUrlField, this.websiteNameField);

        HBox notesBox = new HBox();
        notesBox.getStyleClass().add("notes-hbox");

        this.notesArea = new TextArea();
        this.notesArea.getStyleClass().add("notes-area");
        this.notesArea.setPromptText("Additional Notes...");
        this.notesArea.setBackground(new Background(new BackgroundFill(Color.web("#2E2E2E"), CornerRadii.EMPTY, Insets.EMPTY)));

        notesArea.getBackground().getFills().stream().map(BackgroundFill::getFill).forEach(System.out::println);

        notesBox.getChildren().add(this.notesArea);

        HBox labelBox = new HBox();
        labelBox.getStyleClass().add("label-hbox");

        Label pageLabel = new Label("Add Account");
        pageLabel.getStyleClass().add("page-label");

        labelBox.getChildren().add(pageLabel);

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
