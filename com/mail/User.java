package com.mail;

public class User {
    String user_name;
    String pwd;
    String email;

    public User(String user_name, String email, String pwd) {

        this.user_name = user_name;
        this.pwd = pwd;
        this.email = email;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
