package org.wso2.automation.ui.utils.test;

/**
 * Created by asankav on 10/31/16.
 */
public class User {



    private String userName;
    private String passWord;
    private String role;


    public User(String userName, String passWord,String role){
        this.userName=userName;
        this.passWord=passWord;
        this.role=role;
    }


    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getRole() {
        return role;
    }
}
