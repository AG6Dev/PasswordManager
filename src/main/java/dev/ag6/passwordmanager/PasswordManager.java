package dev.ag6.passwordmanager;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public final class PasswordManager extends Application {
    private BorderPane root;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.root = new BorderPane();

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("Password Manager");
        primaryStage.centerOnScreen();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public BorderPane getRoot() {
        return root;
    }
}
