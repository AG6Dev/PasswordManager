package dev.ag6.passwordmanager.controller;

import dev.ag6.passwordmanager.view.MainView;
import dev.ag6.passwordmanager.view.View;
import javafx.application.Platform;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainController extends Controller<MainView> {
    private final Stage stage;

    public MainController(Stage stage, MainView view) {
        super(view);

        this.stage = stage;
    }

    @Override
    public void initialize() {
        this.view.getCloseButton().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> Platform.exit());
        this.view.getMinimizeButton().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> stage.setIconified(true));
        this.view.getAlwaysOnTopButton().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> stage.setAlwaysOnTop(!stage.isAlwaysOnTop()));

        //TODO: Fix the cursor teleporting to the corner, offset of some kind required.
        this.view.getWindowHeader().setOnMouseDragged(event -> {
            stage.setX(event.getScreenX());
            stage.setY(event.getScreenY());
        });
    }

    public void changeView(View view, Controller<? extends View> controller) {

    }
}
