package dev.ag6.passwordmanager.controller;

import dev.ag6.passwordmanager.PasswordManager;
import dev.ag6.passwordmanager.view.CreateAccountView;

public class CreateAccountController extends Controller<CreateAccountView> {
    private final HomeController oldState;

    public CreateAccountController(HomeController oldState, CreateAccountView view) {
        super(view);

        this.oldState = oldState;
    }

    @Override
    public void initialize() {
        this.view.getBackButton().setOnAction(event -> PasswordManager.changeView(oldState.view, oldState));

        this.view.getCreateButton().setOnAction(event -> {
            //oldState.addAccount();
            PasswordManager.changeView(oldState.view, oldState);
        });
    }
}
