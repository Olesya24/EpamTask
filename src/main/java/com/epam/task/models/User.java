package com.epam.task.models;

public class User {

    private long userId;
    private String userName;
    private String userSurname;
    private String userEmail;
    private String userCategory;

    public User(long userId, String userName, String userSurname, String userCategory) {}

    public User(long userId, String userName, String userSurname, String userEmail, String userCategory) {
        this.userId = userId;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userEmail = userEmail;
        this.userCategory = userCategory;
    }

    public User(User object) {
        this(object.getUserId(), object.getUserName(), object.getUserSurname(), object.getUserCategory());
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }


    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserCategory(String userCategory) {
        this.userCategory = userCategory;
    }

    public String getUserCategory() {
        return userCategory;
    }

}
