package dev.ag6.passwordmanager.view;

import dev.ag6.passwordmanager.components.AccountView;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class MainView {
    private final BorderPane root;

    private final ListView<AccountView> accountList;

    private final HBox topBox;
    private final TextField searchField;
    private final Button addButton;

    public MainView() {
        this.root = new BorderPane();

        accountList = new ListView<>();
        accountList.setMinWidth(500);
        accountList.setMinHeight(500);

        topBox = new HBox();
        searchField = new TextField();
        searchField.setPromptText("Search...");
        addButton = new Button();
        addButton.setText("Add Account");

        topBox.getChildren().addAll(searchField, addButton);

        root.setTop(topBox);
        root.setCenter(accountList);
    }

    public BorderPane getRoot() {
        return root;
    }

    public ListView<AccountView> getAccountList() {
        return accountList;
    }

    public Button getAddButton() {
        return addButton;
    }

    public TextField getSearchField() {
        return searchField;
    }
}