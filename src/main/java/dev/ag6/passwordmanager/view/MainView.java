package dev.ag6.passwordmanager.view;

import dev.ag6.passwordmanager.components.AccountView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class MainView extends View {
    private final BorderPane root;

    private final ListView<AccountView> accountList;

    private final HBox topBox;
    private final TextField searchField;
    private final Button addButton;

    public MainView() {
        this.root = new BorderPane();

        this.accountList = new ListView<>();
        this.accountList.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));

        this.topBox = new HBox();
        this.topBox.setAlignment(Pos.TOP_CENTER);
        this.topBox.setPadding(new Insets(10D));
        this.topBox.setSpacing(10D);

        this.searchField = new TextField();
        this.searchField.setPromptText("Search...");
        this.searchField.setPrefWidth(200D);
        this.addButton = new Button();
        this.addButton.setText("Add Account");

        this.topBox.getChildren().addAll(searchField, addButton);

        this.root.setTop(topBox);
        this.root.setCenter(accountList);
    }

    @Override
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