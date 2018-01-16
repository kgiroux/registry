package com.giroux.kevin.dofustuff.persistences.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "user")
public class UserEntity {
    /**
     * Id for the user
     */
    @Id
    @Column(columnDefinition="text")
    private String id;

    /**
     * User login
     */
    @Column
    private String login;

    /**
     * Password login
     */
    @Column
    private String password;

    /**
     * Email login
     */
    @Column
    private String email;

    /**
     * Timestamp last connexion
     */
    @Column
    private Timestamp lastConnexion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getLastConnexion() {
        return lastConnexion;
    }

    public void setLastConnexion(Timestamp lastConnexion) {
        this.lastConnexion = lastConnexion;
    }
}
