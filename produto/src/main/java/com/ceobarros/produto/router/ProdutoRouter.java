package com.ceobarros.produto.router;

import com.ceobarros.produto.dto.GenericRetornoDTO;
import com.ceobarros.produto.model.Produto;
import com.ceobarros.produto.service.ProdutoService;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProdutoRouter extends BaseRouterBuilder {

    private static final long serialVersionUID = -115276733991443938L;

    @Autowired
    private ProdutoService produtoService;

    @Override
    public void configure() throws Exception {
        rest("/produto/")
                    .get("/listar-produtos")
                .description("Serviço para Listar Produtos")
                .id("ms-produto-lista")
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .bindingMode(RestBindingMode.auto)
                .type(Produto.class)
                .to("direct:listar-produtos");
        from("direct:listar-produtos").process(processorProduto);

        rest("/produto/produto?bridgeEndpoint=true/")
                .post()
                .description("Serviço de inclusão de novo Produto")
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .bindingMode(RestBindingMode.auto)
                .type(Produto.class)
                .to("direct:incluir-produto");
        from("direct:incluir-produto").process(processorProdutoNovo);
    }


    /**
     * Busca o todos os produtos.
     */
    Processor processorProduto = new Processor() {
        @Override
        public void process(Exchange exchange) throws Exception {
            Optional<Iterable<Produto>> optional = Optional.ofNullable(produtoService.findAll());

            if (optional.isPresent()) {
                setBody(exchange, new GenericRetornoDTO<>(optional.get(), HttpStatus.OK.value()));
            } else {
                setBody(exchange, new GenericRetornoDTO<>(HttpStatus.NOT_FOUND.value()));
            }
        }
    };

    /**
     * Busca o todos os produtos.
     */
    Processor processorProdutoNovo = new Processor() {
        @Override
        public void process(Exchange exchange) throws Exception {

            Optional<Produto> optional = Optional.ofNullable(exchange.getIn().getHeader("cpf", Produto.class));

            if (optional.isPresent()) {
                produtoService.inserirProduto(optional.get());
                setBody(exchange, new GenericRetornoDTO<>(optional.get(), HttpStatus.OK.value()));
            } else {
                setBody(exchange, new GenericRetornoDTO<>(HttpStatus.NOT_FOUND.value()));
            }
        }
    };
}
