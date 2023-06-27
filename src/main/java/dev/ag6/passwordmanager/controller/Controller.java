package dev.ag6.passwordmanager.controller;

import dev.ag6.passwordmanager.view.View;

public abstract class Controller<V extends View> {
    protected final V view;

    public Controller(V view) {
        this.view = view;
    }

    public abstract void initialize();
}
