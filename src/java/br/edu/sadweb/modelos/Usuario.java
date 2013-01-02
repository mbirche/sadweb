/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.sadweb.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Birche
 */
@Entity
@Table(name="usuario", schema="public")
public class Usuario {
    
    @Id
    @Column(name="id_usuario")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String login;
    private String senha;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
