package dev.ag6.passwordmanager.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import lombok.Getter;

public class LoginView extends View {
    private final BorderPane mainRoot;

    @Getter
    private final Label promptLabel;

    @Getter
    private final PasswordField passwordField;

    @Getter
    private final Button continueButton;

    public LoginView() {
        this.mainRoot = new BorderPane();

        VBox topLabels = new VBox();
        Label welcomeLabel = new Label("Welcome, %s".formatted(System.getProperty("user.name")));

        this.promptLabel = new Label();
        topLabels.getChildren().addAll(welcomeLabel, promptLabel);

        this.passwordField = new PasswordField();
        this.passwordField.setPromptText("Password");

        this.continueButton = new Button();
        this.continueButton.setText("Enter");

        this.mainRoot.setTop(topLabels);
        this.mainRoot.setCenter(passwordField);
        this.mainRoot.setBottom(continueButton);
    }

    @Override
    public Pane getRoot() {
        return mainRoot;
    }
}
