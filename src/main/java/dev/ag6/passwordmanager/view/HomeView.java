package dev.ag6.passwordmanager.view;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.font.FontResources;
import io.github.palexdev.materialfx.font.MFXFontIcon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import lombok.Getter;

public class HomeView extends View {
    private final BorderPane contentRoot;

    @Getter
    private final GridPane accountGrid;

    @Getter
    private final HBox topBar;

    @Getter
    private final TextField searchField;

    @Getter
    private final MFXButton createButton;

    public HomeView() {
        this.contentRoot = new BorderPane();

        this.accountGrid = new GridPane();

        this.topBar = new HBox();
        this.topBar.setAlignment(Pos.CENTER_RIGHT);
        this.topBar.setSpacing(10D);
        this.topBar.setPadding(new Insets(10D));

        this.searchField = new TextField();
        this.searchField.setPromptText("Search for Account...");
        this.searchField.setPrefHeight(35D);
        this.searchField.setStyle("-fx-text-fill: white; -fx-font-size: 15");
        this.searchField.setBackground(new Background(new BackgroundFill(Color.web("#2E2E2E"), new CornerRadii(10D), Insets.EMPTY)));

        HBox.setHgrow(this.searchField, Priority.ALWAYS);

        //TODO: Fix the ripple going to the corners, even when the corners are rounded.
        this.createButton = new MFXButton("Create", new MFXFontIcon(FontResources.PLUS.getDescription()));
        this.createButton.setBackground(new Background(new BackgroundFill(Color.web("#BB86FC"), new CornerRadii(10D), Insets.EMPTY)));
        this.createButton.setStyle("-fx-font-size:15");
        this.createButton.setPrefHeight(35D);
        this.createButton.setPrefWidth(100D);

        this.topBar.getChildren().addAll(this.searchField, this.createButton);

        this.contentRoot.setTop(this.topBar);
        this.contentRoot.setCenter(this.accountGrid);
    }

    @Override
    public Pane getRoot() {
        return contentRoot;
    }
}
