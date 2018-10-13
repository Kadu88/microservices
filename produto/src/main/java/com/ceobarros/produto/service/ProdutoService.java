package com.ceobarros.produto.service;

import com.ceobarros.produto.dao.ProdutoDao;
import com.ceobarros.produto.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ProdutoService implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 4447928027024030782L;

    @Autowired
    private ProdutoDao produtoDao;

    public Iterable<Produto> findAll() {
        return produtoDao.findAll();
    }

    public void inserirProduto(Produto produto) {
        produtoDao.incluirProduto(produto);
    }

}

