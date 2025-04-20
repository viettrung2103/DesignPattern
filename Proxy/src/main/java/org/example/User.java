package org.example;

public class User {
    private String username;

    public User(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isSameUser(User user) {
        return this.username.equals(user.getUsername());
    }

    @Override
    public String toString(){
        return username;
    }
}
