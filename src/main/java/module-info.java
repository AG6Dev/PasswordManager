module PasswordManager {
    requires javafx.controls;
    requires javafx.fxml;

    opens dev.ag6.passwordmanager to javafx.base, javafx.fxml, javafx.controls;

    exports dev.ag6.passwordmanager;
}