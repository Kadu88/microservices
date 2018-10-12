package com.ceobarros.microservices.process;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class ProcessorServico implements Processor {

    private String role;

    public ProcessorServico(String role) {
        this.role = role;
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        String moduloKey = (String) exchange.getIn().getHeader("Authorization-Module");
//        if (moduloKey != null) {
//            ModuloPapelVO moduloPapelVO = controleAcessoService.buscarPorSenha(moduloKey);
//            if (moduloPapelVO != null && moduloPapelVO.getRoles().contains(role)) {
//                controleAcessoService.inspector(exchange, true, moduloPapelVO);
//            } else {
//                controleAcessoService.inspector(exchange, false, moduloPapelVO);
//                throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
//            }
//        } else {
//            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
//        }
    }

}