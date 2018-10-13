package com.ceobarros.produto.model;

import com.ceobarros.produto.resolvers.EntityIdResolver;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;


/**
 * The persistent class for the TB_PRODUTO database table.
 *
 */
@Entity
@Table(name = "tb_produto", schema = "pet_data_produto")
@JsonInclude(content = Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idProduto", resolver = EntityIdResolver.class, scope = Produto.class)
public class Produto implements Serializable {

    private static final long serialVersionUID = -5342709144819307964L;

    @Id
    @Column(name = "id_produto")
    @SequenceGenerator(name = "sq_produto", sequenceName = "sq_produto", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_produto")
    private Long idProduto;

    @Column(name = "nome")
    @Size(max = 150, min = 0, message = "Tamanho máximo do campo Nome é 150")
    private String nome;

    @Column(name = "descricao")
    @Size(max = 300, min = 0, message = "Tamanho máximo do campo Descrição é 300")
    private String descricao;

    @Column(name = "categoria")
    @Size(max = 200, min = 0, message = "Tamanho máximo do campo Categoria é 200")
    private String categoria;

    @Id
    @Column(name = "quantidade")
    @NotNull(message = "O campo Município é obrigatório")
    @Size(max = 999999999, min = 0, message = "Tamanho máximo do campo Localidade é 999999999")
    private Long quantidade;

    //TODO Incluir imagem blob


    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Long quantidade) {
        this.quantidade = quantidade;
    }
}
