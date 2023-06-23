package dev.ag6.passwordmanager;

import dev.ag6.passwordmanager.controller.WelcomeController;
import dev.ag6.passwordmanager.view.WelcomeView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public final class PasswordManager extends Application {
    private static PasswordManager manager;

    private BorderPane root;

    public static PasswordManager getManager() {
        return manager;
    }

    @Override
    public void start(Stage primaryStage) {
        manager = this;

        this.root = new BorderPane();

        var welcomeView = new WelcomeView();
        var welcomeController = new WelcomeController(welcomeView);

        root.getChildren().clear();
        root.setCenter(welcomeView.getParent());

        Scene scene = new Scene(root, 800, 600);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Password Manager");
        primaryStage.centerOnScreen();
        primaryStage.show();

        welcomeController.init();
    }

    public BorderPane getRoot() {
        return root;
    }
}
