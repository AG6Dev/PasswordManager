package dev.ag6.passwordmanager.model;

import javafx.beans.property.SimpleStringProperty;

public class Account {
    private final SimpleStringProperty username = new SimpleStringProperty("");
    private final SimpleStringProperty password = new SimpleStringProperty("");
    private final SimpleStringProperty website = new SimpleStringProperty("");
    private final SimpleStringProperty notes = new SimpleStringProperty("");

    public Account(String username, String password, String website, String notes) {
        this.username.set(username);
        this.password.set(password);
        this.website.set(website);
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

    public String getWebsite() {
        return website.get();
    }

    public void setWebsite(String website) {
        this.website.set(website);
    }

    public String getNotes() {
        return notes.get();
    }

    public void setNotes(String notes) {
        this.notes.set(notes);
    }
}
