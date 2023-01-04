package com.finastra.oidcclient.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.finastra.oidcclient.utils.FieldEncryptor;
import lombok.Data;

import javax.persistence.*;

@Entity
    @Data
    @Table(name = "utilisateur")
    public class Utilisateur {
      //  @GeneratedValue(strategy = GenerationType.AUTO)
      //  private Long id;

        @Id
        @Column(name = "login")
        private String login;

        //@Convert(converter = FieldEncryptor.class)
        @Column(name = "password")
        private String password;

    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "email")
    private String email;



    }
