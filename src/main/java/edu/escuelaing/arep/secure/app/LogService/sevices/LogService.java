package edu.escuelaing.arep.secure.app.LogService.sevices;

import java.util.HashMap;
import java.util.Map;

import edu.escuelaing.arep.secure.app.LogService.Encrytp.Hash;
import edu.escuelaing.arep.secure.app.LogService.model.User;

/**
 * @author Alan Marin
 */
public class LogService {
    private Map<String , User> usersMap= new HashMap<String,User>();
    private boolean active= false;

    /**
     * Using a hash verify the authentication of the user
     * @param name
     * @param password
     * @return
     */
    public Boolean userAuth(String name , String password){
        String hashPassword = Hash.md5(password);
        if (usersMap.containsKey(name)) {
            if (usersMap.get(name).getPassword().equals(hashPassword)) {
                active = true;
                return true;  
            }
        }
        return false;
    }
    
    /**
     * Safe a new User on hashmap
     * @param user
     */
    public void addUser(User user){
     usersMap.put(user.getName(), user);  
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
