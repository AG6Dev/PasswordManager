package dev.ag6.passwordmanager.controller;

import dev.ag6.passwordmanager.PasswordManager;
import dev.ag6.passwordmanager.view.MainView;
import dev.ag6.passwordmanager.view.WelcomeView;

public class WelcomeController {
    public final WelcomeView view;

    public WelcomeController(WelcomeView view) {
        this.view = view;
    }

    public void init() {
        view.getEnterButton().setOnAction(actionEvent -> {
            var view = new MainView();
            var controller = new MainController(view);

            PasswordManager.getManager().getRoot().getChildren().clear();
            PasswordManager.getManager().getRoot().getChildren().addAll(view.getRoot());

            controller.initialize();
        });
    }
}
