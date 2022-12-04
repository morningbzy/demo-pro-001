package com.example.demoproweb.jpa.user;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class User {

    @Id
    private String pk;

    @Column(unique = true)
    private String account;
    private String password;

}
