package dev.ag6.passwordmanager;

import dev.ag6.passwordmanager.controller.WelcomeController;
import dev.ag6.passwordmanager.view.WelcomeView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public final class PasswordManager extends Application {
    private BorderPane root;

    @Override
    public void start(Stage primaryStage) {
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
}
