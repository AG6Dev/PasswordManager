package dev.ag6.passwordmanager;

import dev.ag6.passwordmanager.controller.Controller;
import dev.ag6.passwordmanager.controller.MainController;
import dev.ag6.passwordmanager.view.MainView;
import dev.ag6.passwordmanager.view.View;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

//TODO: Add some sort of encryption
//TODO: change the button colours they're so ugly
public final class PasswordManager extends Application {
    private static PasswordManager manager;

    private MainController mainController;


    public static <V extends View> void changeView(V view, Controller<V> controller) {
        manager.mainController.changeView(view, controller);
    }

    @Override
    public void start(Stage primaryStage) {
        manager = this;

        Font.loadFont(getClass().getResourceAsStream("/fonts/Roboto-Regular.ttf"), 10D);

        var mainView = new MainView();
        this.mainController = new MainController(primaryStage, mainView);
        this.mainController.initialize();

        Scene scene = new Scene(mainView.getRoot(), 1280, 720);
        scene.setFill(Color.TRANSPARENT);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Password Manager");
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public static void shutdown(int code) {
        Platform.exit();
        //add save all
        System.exit(code);
    }
}
