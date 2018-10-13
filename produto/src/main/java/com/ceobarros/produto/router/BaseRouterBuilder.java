package com.ceobarros.produto.router;

import com.ceobarros.produto.dto.GenericRetornoDTO;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

import java.io.Serializable;


@SuppressWarnings("all")
public abstract class BaseRouterBuilder extends RouteBuilder implements Serializable {

    @Override
    public void configure() throws Exception {
    }

    /**
     * Seta o corpo da requisição juntamente com o status.
     *
     * @param exchange
     * @param retorno
     * @param status
     */
    @SuppressWarnings("rawtypes")
    protected void setBody(Exchange exchange, GenericRetornoDTO retorno) {
        exchange.getOut().setBody(retorno);
    }
}

