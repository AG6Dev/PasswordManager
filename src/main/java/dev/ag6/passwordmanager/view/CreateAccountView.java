package dev.ag6.passwordmanager.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CreateAccountView {
    private final BorderPane root;

    private final VBox formBox;
    private final TextField usernameField;
    private final TextField passwordField;
    private final TextField websiteNameField;
    private final TextField websiteUrlField;
    private final TextArea notesArea;

    private final HBox buttonBox;
    private final Button saveButton;
    private final Button cancelButton;

    public CreateAccountView() {
        this.root = new BorderPane();

        formBox = new VBox();
        this.formBox.setSpacing(10.0D);

        usernameField = new TextField();
        this.usernameField.setPromptText("Enter Username");

        passwordField = new TextField();
        this.passwordField.setPromptText("Enter Password");

        websiteNameField = new TextField();
        this.websiteNameField.setPromptText("Enter Website Name");

        websiteUrlField = new TextField();
        this.websiteUrlField.setPromptText("Enter Website URL");

        notesArea = new TextArea();
        this.notesArea.setPromptText("Extra Notes...");

        formBox.getChildren().addAll(usernameField, passwordField, websiteNameField, websiteUrlField, notesArea);

        buttonBox = new HBox();
        this.buttonBox.setSpacing(10.0D);

        saveButton = new Button();
        this.saveButton.setText("Save");

        cancelButton = new Button();
        this.cancelButton.setText("Cancel");

        buttonBox.getChildren().addAll(saveButton, cancelButton);

        root.setCenter(formBox);
        root.setBottom(buttonBox);
    }

    public BorderPane getRoot() {
        return root;
    }

    public TextField getUsernameField() {
        return usernameField;
    }

    public TextField getPasswordField() {
        return passwordField;
    }

    public TextField getWebsiteNameField() {
        return websiteNameField;
    }

    public TextField getWebsiteUrlField() {
        return websiteUrlField;
    }

    public TextArea getNotesArea() {
        return notesArea;
    }

    public Button getSaveButton() {
        return saveButton;
    }

    public Button getCancelButton() {
        return cancelButton;
    }
}
