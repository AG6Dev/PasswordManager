package dev.ag6.passwordmanager.view;

import com.sun.javafx.css.StyleManager;
import io.github.palexdev.materialfx.font.FontResources;
import io.github.palexdev.materialfx.font.MFXFontIcon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import lombok.Getter;

public class MainView extends View {
    @Getter
    private final AnchorPane mainFrame;
    @Getter
    private final HBox windowHeader;

    @Getter
    private final StackPane contentArea;

    @Getter
    private final MFXFontIcon minimizeButton, closeButton, alwaysOnTopButton;

    //242526, 18191A, 3a3b3c
    public MainView() {

        this.mainFrame = new AnchorPane();
        this.mainFrame.setBackground(new Background(new BackgroundFill(Color.web("#121212"), new CornerRadii(15D), Insets.EMPTY)));
        this.getMainFrame().getStylesheets().add("css/main.css");

        this.windowHeader = new HBox();
        this.windowHeader.setBackground(new Background(new BackgroundFill(Color.web("#1E1E1E"), new CornerRadii(15D, 15D, 0D, 0D, false ), Insets.EMPTY)));
        this.windowHeader.setAlignment(Pos.CENTER);
        this.windowHeader.setPadding(new Insets(10D));

        AnchorPane.setTopAnchor(windowHeader, 0D);
        AnchorPane.setLeftAnchor(windowHeader, 0D);
        AnchorPane.setRightAnchor(windowHeader, 0D);

        HBox windowHeaderLeft = new HBox();
        Label windowTitle = new Label("Password Manager");
        windowTitle.setFont(Font.font("Roboto", 15));
        windowTitle.setTextFill(Color.WHITE);
        windowHeaderLeft.setAlignment(Pos.CENTER_LEFT);

        HBox windowHeaderRight = new HBox();
        windowHeaderRight.setAlignment(Pos.CENTER_RIGHT);
        windowHeaderRight.setSpacing(10D);

        this.alwaysOnTopButton = new MFXFontIcon(FontResources.CIRCLE.getDescription(), 15.0D, Color.web("#7a0ed9"));
        this.alwaysOnTopButton.getStyleClass().add("always-on-top-button");
        this.alwaysOnTopButton.setOpacity(0.5D);

        this.minimizeButton = new MFXFontIcon(FontResources.CIRCLE.getDescription(), 15.0D, Color.rgb(255, 191, 55));
        this.minimizeButton.getStyleClass().add("minimize-button");
        this.minimizeButton.setOpacity(0.5D);

        this.closeButton = new MFXFontIcon(FontResources.CIRCLE.getDescription(), 15.0D, Color.rgb(239, 110, 107));
        this.closeButton.getStyleClass().add("close-button");
        this.closeButton.setOpacity(0.5D);

        Region filler = new Region();
        HBox.setHgrow(filler, Priority.ALWAYS);

        this.contentArea = new StackPane();
        AnchorPane.setTopAnchor(contentArea, 43D);
        AnchorPane.setLeftAnchor(contentArea, 0D);
        AnchorPane.setRightAnchor(contentArea, 0D);
        AnchorPane.setBottomAnchor(contentArea, 0D);

        windowHeaderLeft.getChildren().add(windowTitle);
        windowHeaderRight.getChildren().addAll(alwaysOnTopButton, minimizeButton, closeButton);
        this.windowHeader.getChildren().addAll(windowHeaderLeft, filler, windowHeaderRight);

        this.mainFrame.getChildren().add(windowHeader);
        this.mainFrame.getChildren().add(contentArea);
    }

    @Override
    public Pane getRoot() {
        return this.mainFrame;
    }

    public void addDebugBorder(Region node, Color color) {
        node.setBorder(new Border(new BorderStroke(color, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
    }
}
