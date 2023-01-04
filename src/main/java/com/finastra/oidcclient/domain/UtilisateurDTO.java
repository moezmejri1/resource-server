package com.finastra.oidcclient.domain;

import lombok.Data;

@Data
public class UtilisateurDTO {

    private String firstName;
    private String lastName;
    private String login;
    private String email;
    private String password;

    public UtilisateurDTO(){

    }

    public UtilisateurDTO(String firstName,String lastName,String login,String email,String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.email = email;
        this.password = password;
    }
    @Override
    public String toString(){
        return "firstName: "+this.firstName+", lastName:"+this.lastName;
    }

}
