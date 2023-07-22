package dev.ag6.passwordmanager.controller;

import dev.ag6.passwordmanager.view.HomeView;
import dev.ag6.passwordmanager.view.MainView;
import dev.ag6.passwordmanager.view.View;
import javafx.application.Platform;
import javafx.css.PseudoClass;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainController extends Controller<MainView> {
    private final Stage stage;

    private int cursorOffsetX;
    private int cursorOffsetY;

    public MainController(Stage stage, MainView view) {
        super(view);

        this.stage = stage;
    }

    @Override
    public void initialize() {
        this.view.getCloseButton().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> Platform.exit());
        this.view.getMinimizeButton().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> stage.setIconified(true));
        this.view.getAlwaysOnTopButton().addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            this.view.getAlwaysOnTopButton().pseudoClassStateChanged(PseudoClass.getPseudoClass("always-on-top"), !stage.isAlwaysOnTop());
            stage.setAlwaysOnTop(!stage.isAlwaysOnTop());
        });

        this.view.getWindowHeader().setOnMousePressed(event -> {
            this.cursorOffsetX = (int) (stage.getX() - event.getScreenX());
            this.cursorOffsetY = (int) (stage.getY() - event.getScreenY());
        });

        this.view.getWindowHeader().setOnMouseDragged(event -> {
            stage.setX(event.getScreenX() + cursorOffsetX);
            stage.setY(event.getScreenY() + cursorOffsetY);
        });

        HomeView view = new HomeView();
        HomeController controller = new HomeController(view);
        changeView(view, controller);
    }

    public void changeView(View view, Controller<? extends View> controller) {
        this.view.getContentArea().getChildren().clear();
        this.view.getContentArea().getChildren().add(view.getRoot());
        controller.initialize();
    }
}
