package dev.ag6.passwordmanager.controller;

import dev.ag6.passwordmanager.PasswordManager;
import dev.ag6.passwordmanager.view.MainView;
import dev.ag6.passwordmanager.view.WelcomeView;

public class WelcomeController extends Controller<WelcomeView> {
    public WelcomeController(WelcomeView view) {
        super(view);
    }

    @Override
    public void initialize() {
        this.view.getEnterButton().setOnAction(actionEvent -> {
            var view = new MainView();
            var controller = new MainController(view);

            PasswordManager.changeView(view, controller);

            controller.initialize();
        });
    }
}
