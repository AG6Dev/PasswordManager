package dev.ag6.passwordmanager.view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextAlignment;

public class WelcomeView extends View {
    private final BorderPane root;
    private final Label welcomeLabel;

    private final Button button;

    public WelcomeView() {
        this.root = new BorderPane();

        this.welcomeLabel = new Label("Welcome to Password Manager!");

        this.welcomeLabel.setTextAlignment(TextAlignment.CENTER);
        this.welcomeLabel.setAlignment(Pos.CENTER);

        this.button = new Button();
        this.button.setText("Enter");

        this.root.setTop(welcomeLabel);
        this.root.setCenter(button);

        this.welcomeLabel.setTextAlignment(TextAlignment.CENTER);
        this.welcomeLabel.setAlignment(Pos.CENTER);
    }

    public Button getEnterButton() {
        return button;
    }

    @Override
    public BorderPane getRoot() {
        return root;
    }
}
