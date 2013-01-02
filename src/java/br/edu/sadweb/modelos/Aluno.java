/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.sadweb.modelos;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Birche
 */
@Entity
@Table(name = "aluno", schema = "public")
@PrimaryKeyJoinColumn(name = "id_aluno")
public class Aluno extends Pessoa {

    private String ra;

    public Aluno() {
    }

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }
}
