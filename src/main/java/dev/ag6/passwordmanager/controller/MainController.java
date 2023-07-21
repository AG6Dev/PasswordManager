package dev.ag6.passwordmanager.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.ag6.passwordmanager.PasswordManager;
import dev.ag6.passwordmanager.model.Account;
import dev.ag6.passwordmanager.view.CreateAccountView;
import dev.ag6.passwordmanager.view.MainView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainController extends Controller<MainView> {
    static final ObservableList<Account> accounts = FXCollections.observableArrayList();
    private static final Gson GSON = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
    private static final Path ACCOUNTS_PATH = Paths.get(System.getProperty("user.home"), "Documents", "PasswordManager", "accounts.json");

    public MainController(MainView view) {
        super(view);

        /*loadAccounts();*/
    }

    public void initialize() {
        view.getAddButton().setOnAction(actionEvent -> {
            var createAccountView = new CreateAccountView();
            var createAccountController = new CreateAccountController(createAccountView);
            PasswordManager.changeView(createAccountView, createAccountController);
        });

        view.getSearchField().textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.isEmpty()) {
                view.getAccountList().setItems(accounts);
            } else {
                ObservableList<Account> filteredAccounts = FXCollections.observableArrayList();
                for (Account account : accounts) {
                    if (account.getWebsiteName().toLowerCase().contains(newValue.toLowerCase())) {
                        filteredAccounts.add(account);
                    }
                }
                view.getAccountList().setItems(filteredAccounts);
            }
        });
        view.getAccountList().setItems(accounts);
    }

    public void saveAccounts() {
        try {
            if (ACCOUNTS_PATH.toFile().exists()) {
                BufferedWriter writer = Files.newBufferedWriter(ACCOUNTS_PATH, StandardCharsets.UTF_8);
                GSON.toJson(accounts, writer);
            } else {
                createRequiredFiles();
                saveAccounts();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*public void loadAccounts() {
        try {
            if (ACCOUNTS_PATH.toFile().exists()) {
                var reader = Files.newBufferedReader(ACCOUNTS_PATH, StandardCharsets.UTF_8);

                System.out.println(Arrays.toString(accountViews));


                accounts.addAll(accountViews.stream().map(AccountView::new).toList());
            } else {
               createRequiredFiles();
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }*/

    private void createRequiredFiles() throws Exception {
        Files.createDirectories(ACCOUNTS_PATH.getParent());
        Files.createFile(ACCOUNTS_PATH);
        Files.write(ACCOUNTS_PATH, "{[]}".getBytes());
    }
}
