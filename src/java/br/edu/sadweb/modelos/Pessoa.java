/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.sadweb.modelos;

import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.IndexColumn;

/**
 *
 * @author Birche
 */
@Entity
@Table(name = "pessoa", schema = "public")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_pessoa")
    private Integer id;
    private String nome;
    private String sobrenome;
    @Column(unique = true)
    private String email;
    @Column(name = "resposta_seguranca")
    private String respostaSeguranca;
    
    
    @OneToMany(fetch = FetchType.EAGER)
    @Cascade(CascadeType.ALL)
    @JoinTable(name="pessoa_telefone", schema="public", 
            joinColumns=@JoinColumn(name="id_pessoa"), 
            inverseJoinColumns=@JoinColumn(name="id_telefone"))
    @IndexColumn(name="posicao")
    private List<Telefone> telefones;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name="pessoa_usuario", schema="public",
            joinColumns=@JoinColumn(name="id_pessoa"),
            inverseJoinColumns=@JoinColumn(name="id_usuario"))
    @Cascade(CascadeType.ALL)
    private Set<Usuario> usuarios;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRespostaSeguranca() {
        return respostaSeguranca;
    }

    public void setRespostaSeguranca(String respostaSeguranca) {
        this.respostaSeguranca = respostaSeguranca;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Pessoa() {
    }
}
