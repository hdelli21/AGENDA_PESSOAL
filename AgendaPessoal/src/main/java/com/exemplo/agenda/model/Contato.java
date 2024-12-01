package com.exemplo.agenda.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;


/**
 * Classe que representa a entidade Contato.
 * 
 * Esta classe é mapeada para a tabela 'contatos' no banco de dados.
 */
@Entity
@Table(name = "contatos")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nome;
    
    private String telefone;

    /**
     * Obtém o ID do contato.
     *
     * @return o ID do contato.
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do contato.
     *
     * @param id o novo ID do contato.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o nome do contato.
     *
     * @return o nome do contato.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do contato.
     *
     * @param nome o novo nome do contato.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o telefone do contato.
     *
     * @return o telefone do contato.
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o telefone do contato.
     *
     * @param telefone o novo telefone do contato.
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
