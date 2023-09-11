package dev.ag6.passwordmanager.view;

import dev.ag6.passwordmanager.components.TogglePasswordField;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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
        this.getRoot().getStylesheets().add("css/view/login.css");

        VBox topLabels = new VBox();
        topLabels.getStyleClass().add("top-labels-vbox");

        Label welcomeLabel = new Label("Welcome, %s".formatted(System.getProperty("user.name")));
        welcomeLabel.getStyleClass().add("welcome-label");

        this.promptLabel = new Label();
        promptLabel.getStyleClass().add("prompt-label");

        topLabels.getChildren().addAll(welcomeLabel, promptLabel);

        HBox passwordArea = new HBox();
        passwordArea.getStyleClass().add("password-area-hbox");

        this.passwordField = new TogglePasswordField();
        this.passwordField.getStyleClass().add("password-field");
        this.passwordField.setPromptText("Password");

        passwordArea.getChildren().addAll(passwordField);

        //todo: reset button
        HBox buttonArea = new HBox();
        buttonArea.getStyleClass().add("button-area-hbox");
        System.out.println(topLabels.getPadding().getTop());

        this.continueButton = new Button("Enter");
        this.continueButton.getStyleClass().add("continue-button");

        buttonArea.getChildren().add(this.continueButton);

        this.mainRoot.setTop(topLabels);
        this.mainRoot.setCenter(passwordArea);
        this.mainRoot.setBottom(buttonArea);
    }

    @Override
    public Pane getRoot() {
        return mainRoot;
    }
}
