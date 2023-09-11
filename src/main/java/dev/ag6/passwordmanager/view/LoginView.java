package dev.ag6.passwordmanager.view;

import dev.ag6.passwordmanager.components.TogglePasswordField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import lombok.Getter;

public class LoginView extends View {
    private final BorderPane mainRoot;

    @Getter
    private final Label promptLabel;

    @Getter
    private final TogglePasswordField passwordField;

    @Getter
    private final Button continueButton;

    public LoginView() {
        this.mainRoot = new BorderPane();

        VBox topLabels = new VBox();
        topLabels.setAlignment(Pos.TOP_CENTER);
        topLabels.setPadding(new Insets(30, 0, 0, 0));

        Label welcomeLabel = new Label("Welcome, %s".formatted(System.getProperty("user.name")));
        welcomeLabel.setFont(Font.font("Roboto", 30));
        welcomeLabel.setTextFill(Color.WHITE);

        this.promptLabel = new Label();
        this.promptLabel.setTextFill(Color.WHITE);
        this.promptLabel.setFont(Font.font("Roboto", 30));

        topLabels.getChildren().addAll(welcomeLabel, promptLabel);

        HBox passwordArea = new HBox();

        this.passwordField = new TogglePasswordField();
        this.passwordField.setPromptText("Password");
        this.passwordField.setPrefHeight(35D);
        this.passwordField.setPrefWidth(350);
        this.passwordField.setStyle("-fx-text-fill: white; -fx-font-size: 15");
        this.passwordField.setBackground(new Background(new BackgroundFill(Color.web("#2E2E2E"), new CornerRadii(10D), Insets.EMPTY)));

        passwordArea.setSpacing(10D);
        passwordArea.getChildren().addAll(passwordField);
        passwordArea.setAlignment(Pos.CENTER);

        this.continueButton = new Button();
        this.continueButton.setText("Enter");

        this.mainRoot.setTop(topLabels);
        this.mainRoot.setCenter(passwordArea);
        this.mainRoot.setBottom(continueButton);
    }

    @Override
    public Pane getRoot() {
        return mainRoot;
    }
}
