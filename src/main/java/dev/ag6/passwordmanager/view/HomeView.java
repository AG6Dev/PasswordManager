package dev.ag6.passwordmanager.view;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.font.FontResources;
import io.github.palexdev.materialfx.font.MFXFontIcon;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
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
        this.contentRoot.getStylesheets().add("css/view/home.css");

        this.accountGrid = new GridPane();

        this.topBar = new HBox();
        this.topBar.getStyleClass().add("top-bar-hbox");

        this.searchField = new TextField();
        this.searchField.getStyleClass().add("search-field");
        this.searchField.setPromptText("Search for Account...");

        HBox.setHgrow(this.searchField, Priority.ALWAYS);

        //TODO: Fix the ripple going to the corners, even when the corners are rounded.
        this.createButton = new MFXButton("Create", new MFXFontIcon(FontResources.PLUS.getDescription()));
        this.createButton.getStyleClass().add("create-button");

        this.topBar.getChildren().addAll(this.searchField, this.createButton);

        this.contentRoot.setTop(this.topBar);
        this.contentRoot.setCenter(this.accountGrid);
    }

    @Override
    public Pane getRoot() {
        return contentRoot;
    }
}
