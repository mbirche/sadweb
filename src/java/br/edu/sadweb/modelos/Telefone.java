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
@Table(name = "telefone", schema = "public")

public class Telefone {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_telefone")
    private Integer id;
    @Column(name = "codigo_pais")
    private String codPais;
    @Column(name = "codigo_estado")
    private String codEstado;
    private String numero;
    private String ramal;
    
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "id_pessoa",
//    insertable = true, updatable = true)
//    @Fetch(FetchMode.JOIN)
//    @Cascade(CascadeType.SAVE_UPDATE)
//    private Pessoa pessoa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodPais() {
        return codPais;
    }

    public void setCodPais(String codPais) {
        this.codPais = codPais;
    }

    public String getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(String codEstado) {
        this.codEstado = codEstado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public Telefone() {
    }
}
