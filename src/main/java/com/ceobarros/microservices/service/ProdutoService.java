package com.ceobarros.microservices.service;
import java.io.Serializable;
import java.util.List;

import com.ceobarros.microservices.dao.ProdutoDao;
import com.ceobarros.microservices.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

