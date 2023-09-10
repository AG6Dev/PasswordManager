package dev.ag6.passwordmanager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import dev.ag6.passwordmanager.model.Account;
import dev.ag6.passwordmanager.util.CryptoUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public final class AccountManager {

    public static final AccountManager INSTANCE = new AccountManager();

    private static final Path ACCOUNTS_LOCATION = Path.of(System.getProperty("user.home"), ".pwm");
    private static final Gson GSON = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    @Getter
    private final ObservableList<Account> accounts = FXCollections.observableArrayList();


    public boolean login(String enteredPassword, boolean firstTime) {
        try {
            if (firstTime) {
                createNeededFiles();
                String hashEnter = CryptoUtils.hashPassword(enteredPassword);
                Files.writeString(ACCOUNTS_LOCATION.resolve("master.pwm"), hashEnter);

                return true;
            }

            String storedMaster = Files.readString(ACCOUNTS_LOCATION.resolve("master.pwm"));
            boolean correctPassword = CryptoUtils.checkInputVStored(enteredPassword, storedMaster);

            if (correctPassword) {
                //decrypt
                byte[] data = Files.readAllBytes(ACCOUNTS_LOCATION.resolve("accounts.pwm"));
                String decryptedJson = CryptoUtils.decryptDataAES(new String(data), CryptoUtils.hashPassword(enteredPassword));

                JsonArray passwordArray = GSON.fromJson(decryptedJson, JsonArray.class);
                List<Account> acc = passwordArray.asList().stream().map(jsonElement -> GSON.fromJson(jsonElement, Account.class)).toList();
                this.accounts.addAll(acc);

                return true;
            }
            return false;
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void saveAllAccounts() {
        try {
            String storedMaster = Files.readString(ACCOUNTS_LOCATION.resolve("master.pwm"));
            String toEncrypt = GSON.toJson(accounts);
            String encryptedData = CryptoUtils.encryptDataAES(toEncrypt, storedMaster);

            Files.writeString(ACCOUNTS_LOCATION.resolve("accounts.pwm"), encryptedData);
        } catch (Exception e) {
            saveAllAccounts();
            throw new RuntimeException("Error saving accounts, trying again: " + e);
        }
    }


    public boolean isFirstTime() {
        return !Files.exists(ACCOUNTS_LOCATION.resolve("master.pwm"));
    }

    private void createNeededFiles() {
        try {
            Files.createDirectories(ACCOUNTS_LOCATION.getParent());
            Files.setAttribute(ACCOUNTS_LOCATION.getFileName(), "dos:hidden", true);
            Files.createFile(ACCOUNTS_LOCATION.resolve("master.pwm"));
            Files.createFile(ACCOUNTS_LOCATION.resolve("accounts.pwm"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private AccountManager() {

    }
}
