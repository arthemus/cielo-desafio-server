package br.com.cielo.desafio.controller;

import br.com.cielo.desafio.controller.response.LancamentoResponse;
import br.com.cielo.desafio.service.LancamentoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LancamentoController {

    private static final Logger log = LoggerFactory.getLogger(LancamentoController.class);

    @Autowired
    private LancamentoService lancamentoService;

    @GetMapping("/lancamentos")
    public ResponseEntity<List<LancamentoResponse>> getControleLancamento() {
        log.info("Listando lancamentos atuais.");
        return ResponseEntity.ok(lancamentoService.getControleLancamento());
    }
}
