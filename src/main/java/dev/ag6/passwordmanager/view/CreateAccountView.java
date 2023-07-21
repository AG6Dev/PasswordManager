package dev.ag6.passwordmanager.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CreateAccountView extends View {
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

        this.formBox = new VBox();
        this.formBox.setSpacing(10.0D);

        this.usernameField = new TextField();
        this.usernameField.setPromptText("Enter Username");

        this.passwordField = new TextField();
        this.passwordField.setPromptText("Enter Password");

        this.websiteNameField = new TextField();
        this.websiteNameField.setPromptText("Enter Website Name");

        this.websiteUrlField = new TextField();
        this.websiteUrlField.setPromptText("Enter Website URL");

        this.notesArea = new TextArea();
        this.notesArea.setPromptText("Extra Notes...");

        this.formBox.getChildren().addAll(usernameField, passwordField, websiteNameField, websiteUrlField, notesArea);

        this.buttonBox = new HBox();
        this.buttonBox.setSpacing(10.0D);

        this.saveButton = new Button();
        this.saveButton.setText("Save");

        this.cancelButton = new Button();
        this.cancelButton.setText("Cancel");

        this.buttonBox.getChildren().addAll(saveButton, cancelButton);

        this.root.setCenter(formBox);
        this.root.setBottom(buttonBox);
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
