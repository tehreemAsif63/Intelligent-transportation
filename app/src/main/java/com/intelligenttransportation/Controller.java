package com.intelligenttransportation;

import java.util.ArrayList;

public class Controller {
    public static ArrayList<User> usersList = new ArrayList<>();

    public Controller() {
        usersList = new ArrayList<>();
    }

    public static void addUser(String name, String password, String type) {
        User user = new User(name, password, type);
        usersList.add(user);
    }

    public static void isLoggedIn(User user) {
        String title = "Logged in";
    }

    public static void notLoggedIn(User user) {
        String title = "Not logged in";

    }

    // get the logged in user Info
    public static User getLoggedInUser() {
        for (User aUser : usersList) {
            if (aUser.getLoginStatus().equals("logged in")) {
                return aUser;
            }
        }
        return null;
    }

    // Verify the receiver's credentials to connect as a user
    public static boolean verifyUserCredentials(String name, String password, String type) {
        for (User user : usersList) {
            if ((user.getUserName().equals(name)) && (user.getPassWord().equals(password) &&
                    (user.getType().equals(type)))) {
                user.setLoginStatus("logged in");
                return true;
            }
        }
        return false;

    }

    public static boolean verifyAdminCredentials(String name, String password, String type) {
        for (User user : usersList) {
            if ((user.getUserName().equals(name)) && (user.getPassWord().equals(password) &&
                    (user.getType().equals("Admin")))) {
                user.setLoginStatus("logged in");
                return true;
            }
        }
        return false;

    }
}
