/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.sadweb.modelos;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Birche
 */
@Entity
public class Curso {

    @Id
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
