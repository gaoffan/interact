package org.sacc.interact.entity;

public class DoPassword {
    User user;
    public void setUser(User user) {
        this.user=user;
    }
    public String getPassword(){
        return user.password;
    }
    public User setPassword(String password){
        this.user.password=password;
        return user;
    }
}
