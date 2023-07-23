package dev.ag6.passwordmanager.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import dev.ag6.passwordmanager.PasswordManager;
import dev.ag6.passwordmanager.model.Account;
import dev.ag6.passwordmanager.view.OldCreateAccountView;
import dev.ag6.passwordmanager.view.OldMainView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class OldMainController extends Controller<OldMainView> {
    static final ObservableList<Account> accounts = FXCollections.observableArrayList();
    private static final Gson GSON = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
    private static final Path ACCOUNTS_PATH = Paths.get(System.getProperty("user.home"), "Documents", "PasswordManager", "accounts.json");

    public OldMainController(OldMainView view) {
        super(view);
    }

    public void initialize() {
        createRequiredFiles();
        List<Account> l = loadAccounts();

        view.getAddButton().setOnAction(actionEvent -> {
            var createAccountView = new OldCreateAccountView();
            var createAccountController = new OldCreateAccountController(createAccountView);
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

    public void saveAccount(Account account) {
        try (BufferedWriter writer = Files.newBufferedWriter(ACCOUNTS_PATH, StandardCharsets.UTF_8)) {
            JsonArray jsonArray = GSON.toJsonTree(accounts).getAsJsonArray();
            jsonArray.add(GSON.toJsonTree(account));
            GSON.toJson(jsonArray, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveAllAccounts() {
        try (BufferedWriter writer = Files.newBufferedWriter(ACCOUNTS_PATH, StandardCharsets.UTF_8)) {
            GSON.toJson(accounts, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Account> loadAccounts() {
        try (BufferedReader reader = Files.newBufferedReader(ACCOUNTS_PATH, StandardCharsets.UTF_8)) {
            Account[] accountsList = GSON.fromJson(reader, Account[].class);
            return List.of(accountsList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return List.of();
    }

    public void createRequiredFiles() {
        try {
            if (!ACCOUNTS_PATH.toFile().exists()) {
                Files.createDirectories(ACCOUNTS_PATH.getParent());
                Files.createFile(ACCOUNTS_PATH);
                Files.writeString(ACCOUNTS_PATH, "[]", StandardOpenOption.CREATE);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
