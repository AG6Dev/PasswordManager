package dev.ag6.passwordmanager.model;

import javafx.beans.property.SimpleStringProperty;

public class Account {
    private final SimpleStringProperty username = new SimpleStringProperty("");
    private final SimpleStringProperty password = new SimpleStringProperty("");
    private final SimpleStringProperty websiteName = new SimpleStringProperty("");
    private final SimpleStringProperty websiteUrl = new SimpleStringProperty("");
    private final SimpleStringProperty notes = new SimpleStringProperty("");

    public Account(String username, String password, String websiteUrl, String websiteName, String notes) {
        this.username.set(username);
        this.password.set(password);
        this.websiteUrl.set(websiteUrl);
        this.websiteName.set(websiteName);
        this.notes.set(notes);
    }

    public Account() {

    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getWebsiteUrl() {
        return websiteUrl.get();
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl.set(websiteUrl);
    }

    public String getNotes() {
        return notes.get();
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }

    public String getWebsiteName() {
        return this.websiteName.get();
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName.set(websiteName);
    }
}
