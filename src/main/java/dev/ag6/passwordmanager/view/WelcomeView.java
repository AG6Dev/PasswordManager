package dev.ag6.passwordmanager.view;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.TextAlignment;

public class WelcomeView {
    private final BorderPane root;
    private Label label;

    public WelcomeView() {
        this.root = new BorderPane();

        this.label = new Label("Welcome to Password Manager!");

        label.setTextAlignment(TextAlignment.CENTER);
        label.setAlignment(Pos.CENTER);

        root.setTop(label);

        label.setTextAlignment(TextAlignment.CENTER);
        label.setAlignment(Pos.CENTER);

    }

    public Parent getParent() {
        return root;
    }
}
