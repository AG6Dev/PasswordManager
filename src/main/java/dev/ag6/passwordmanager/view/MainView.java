package dev.ag6.passwordmanager.view;

import dev.ag6.passwordmanager.components.AccountView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class MainView {
    private final BorderPane root;

    private final ListView<AccountView> accountList;

    private final HBox topBox;
    private final TextField searchField;
    private final Button addButton;

    public MainView() {
        this.root = new BorderPane();

        accountList = new ListView<>();


        topBox = new HBox();
        topBox.setAlignment(Pos.TOP_CENTER);
        topBox.setPadding(new Insets(10D));
        topBox.setSpacing(10D);


        searchField = new TextField();
        searchField.setPromptText("Search...");
        searchField.setPrefWidth(200D);
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