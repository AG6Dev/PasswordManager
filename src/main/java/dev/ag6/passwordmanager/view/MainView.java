package dev.ag6.passwordmanager.view;

import io.github.palexdev.materialfx.font.FontResources;
import io.github.palexdev.materialfx.font.MFXFontIcon;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import lombok.Getter;

public class MainView extends View {
    @Getter
    private final AnchorPane mainFrame;
    @Getter
    private final HBox windowHeader;

    @Getter
    private final StackPane contentArea;

    @Getter
    private final StackPane overlayPane;

    @Getter
    private final MFXFontIcon minimizeButton, closeButton, alwaysOnTopButton;

    public MainView() {
        this.mainFrame = new AnchorPane();
        this.mainFrame.getStyleClass().add("root");
        this.getMainFrame().getStylesheets().add("css/view/main.css");

        this.windowHeader = new HBox();
        this.windowHeader.getStyleClass().add("window-header");

        AnchorPane.setTopAnchor(windowHeader, 0D);
        AnchorPane.setLeftAnchor(windowHeader, 0D);
        AnchorPane.setRightAnchor(windowHeader, 0D);

        HBox windowHeaderLeft = new HBox();
        windowHeaderLeft.getStyleClass().add("window-header-left");

        Label windowTitle = new Label("Password Manager");
        windowTitle.getStyleClass().add("window-title");

        HBox windowHeaderRight = new HBox();
        windowHeaderRight.getStyleClass().add("window-header-right");

        this.alwaysOnTopButton = new MFXFontIcon(FontResources.CIRCLE.getDescription(), 15.0D, Color.web("#7a0ed9"));
        this.alwaysOnTopButton.getStyleClass().add("always-on-top-button");

        this.minimizeButton = new MFXFontIcon(FontResources.CIRCLE.getDescription(), 15.0D, Color.rgb(255, 191, 55));
        this.minimizeButton.getStyleClass().add("minimize-button");

        this.closeButton = new MFXFontIcon(FontResources.CIRCLE.getDescription(), 15.0D, Color.rgb(239, 110, 107));
        this.closeButton.getStyleClass().add("close-button");

        Region filler = new Region();
        HBox.setHgrow(filler, Priority.ALWAYS);

        this.overlayPane = new StackPane();
        AnchorPane.setTopAnchor(overlayPane, 43D);
        AnchorPane.setLeftAnchor(overlayPane, 0D);
        AnchorPane.setRightAnchor(overlayPane, 0D);
        AnchorPane.setBottomAnchor(overlayPane, 0D);

        this.contentArea = new StackPane();
        AnchorPane.setTopAnchor(contentArea, 43D);
        AnchorPane.setLeftAnchor(contentArea, 0D);
        AnchorPane.setRightAnchor(contentArea, 0D);
        AnchorPane.setBottomAnchor(contentArea, 0D);

        windowHeaderLeft.getChildren().addAll(windowTitle);
        windowHeaderRight.getChildren().addAll(alwaysOnTopButton, minimizeButton, closeButton);
        this.windowHeader.getChildren().addAll(windowHeaderLeft, filler, windowHeaderRight);

        this.overlayPane.getChildren().add(contentArea);

        this.mainFrame.getChildren().add(windowHeader);
        this.mainFrame.getChildren().add(overlayPane);
    }

    @Override
    public Pane getRoot() {
        return this.mainFrame;
    }
}
