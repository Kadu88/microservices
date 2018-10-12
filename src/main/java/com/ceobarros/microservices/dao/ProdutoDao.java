package com.ceobarros.microservices.dao;

import com.ceobarros.microservices.model.Produto;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;

@Component
public class ProdutoDao {

    @PersistenceContext
    protected EntityManager entityManager;

    /**
     *
     * @return Iterable<Produto>
     */
    public Iterable<Produto> findAll() {
        Iterable<Produto> listaProdutos;
        try {
            listaProdutos = (Iterable<Produto>) entityManager.createNativeQuery("SELECT pro.id_produto, pro.nome, pro.descricao, pro.categoria, pro.quantidade FROM tb_produto pro ").getResultList();
        } catch (NoResultException | NonUniqueResultException e) {
            listaProdutos = null;
        }
        return listaProdutos;
    }
}
