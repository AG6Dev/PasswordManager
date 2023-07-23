package dev.ag6.passwordmanager.view;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import lombok.Getter;

public class CreateAccountView extends View {
    private final BorderPane contentRoot;

    @Getter
    private final StackPane infoLayout;

    @Getter
    private final HBox bottomBar, mainDetailsBox;

    @Getter
    private final MFXTextField usernameField, passwordField;

    @Getter
    private final Button backButton, createButton;

    public CreateAccountView() {
        this.contentRoot = new BorderPane();

        this.bottomBar = new HBox();
        this.bottomBar.setAlignment(Pos.CENTER);
        this.bottomBar.setSpacing(10D);


        this.backButton = new MFXButton("Back");
        this.backButton.setPrefSize(100D, 35D);
        this.createButton = new MFXButton("Create");
        this.createButton.setPrefSize(100D, 35D);
        this.bottomBar.getChildren().addAll(this.backButton, this.createButton);

        this.infoLayout = new StackPane();
        this.infoLayout.setBackground(Background.EMPTY);

        this.mainDetailsBox = new HBox();
        this.usernameField = new MFXTextField();
        this.usernameField.setPromptText("Username");
        this.usernameField.setPrefSize(200D, 35D);

        this.passwordField = new MFXTextField();
        this.passwordField.setPromptText("Password");
        this.passwordField.setPrefSize(200D, 35D);

        this.mainDetailsBox.getChildren().addAll(this.usernameField, this.passwordField);

        addDebugLines(this.infoLayout, Color.RED);
        this.infoLayout.getChildren().add(this.mainDetailsBox);


        this.contentRoot.setCenter(this.infoLayout);
        this.contentRoot.setBottom(bottomBar);
    }

    @Override
    public Pane getRoot() {
        return contentRoot;
    }
}
