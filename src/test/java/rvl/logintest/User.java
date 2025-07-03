package rvl.logintest;

public class User {
    private String email;
    private String password;
    private boolean isValidUser;

    public User(String email, String password, boolean isValidUser) {
        this.email = email;
        this.password = password;
        this.isValidUser = isValidUser;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public boolean isValidUser() {
        return isValidUser;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setValidUser(boolean isValidUser) {
        this.isValidUser = isValidUser;
    }
}
