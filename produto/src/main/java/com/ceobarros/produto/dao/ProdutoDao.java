package com.ceobarros.produto.dao;

import com.ceobarros.produto.model.Produto;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

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
//            List<Produto> listProdutos = entityManager.createNativeQuery("SELECT pro.id_produto, pro.nome, pro.descricao, pro.categoria, pro.quantidade FROM tb_produto pro ").getResultList();

            List<Produto> listProdutos = entityManager.createNativeQuery("SELECT pro.id_produto, pro.nome, pro.descricao, pro.categoria, pro.quantidade FROM tb_produto pro ").getResultList();
            listaProdutos =  listProdutos.isEmpty() ? null : listProdutos;
        } catch (NoResultException | NonUniqueResultException e) {
            listaProdutos = null;
        }
        return listaProdutos;
    }

    public void incluirProduto(Produto produto) {
        try {
            entityManager.createQuery("insert into Produto (nome, descricao, categoria, quantidade) =: nome, =: descricao, =: categoria, =: quantidade ")
                    .setParameter("nome", produto.getNome())
                    .setParameter("descricao", produto.getDescricao())
                    .setParameter("categoria", produto.getCategoria())
                    .setParameter("quantidade", produto.getQuantidade())
                    .executeUpdate();

        }catch (NoResultException | NonUniqueResultException e) {
            //TODO TRATAR EXCEPTONS
        }
    }

}
