package br.com.cielo.desafio.service;

import br.com.cielo.desafio.controller.response.LancamentoResponse;
import br.com.cielo.desafio.legado.ControleLancamento;
import br.com.cielo.desafio.legado.model.Lancamento;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class LancamentoService {

    private static final Logger log = LoggerFactory.getLogger(LancamentoService.class);

    @Autowired
    private ControleLancamento controleLancamento;

    public List<LancamentoResponse> getControleLancamento() {
        Lancamento lancamento = controleLancamento.buscarLancamento();
        if (lancamento == null) {
            log.warn("Nao foi possivel obter os lancamentos.");
            return Collections.emptyList();
        }
        return Stream.of(lancamento.listaControleLancamento)
                .map(LancamentoResponse::new)
                .collect(Collectors.toList());
    }
}
