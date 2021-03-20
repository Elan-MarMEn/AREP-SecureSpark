package edu.escuelaing.arep.secure.app.LogService.model;

import edu.escuelaing.arep.secure.app.LogService.Encrytp.Hash;

/**
 * @author Alan Marin
 */
public class User {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = Hash.md5(password);
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getPassword() {
        return password;
    }  
}
