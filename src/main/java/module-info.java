module PasswordManager {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hildan.fxgson;

    opens dev.ag6.passwordmanager to javafx.base, javafx.fxml, javafx.controls, org.hildan.fxgson;

    exports dev.ag6.passwordmanager;
}