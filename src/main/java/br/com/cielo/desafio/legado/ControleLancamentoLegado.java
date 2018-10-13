package br.com.cielo.desafio.legado;

import br.com.cielo.desafio.legado.model.Lancamento;
import br.com.cielo.desafio.util.JSONUtils;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@Component
public class ControleLancamentoLegado implements ControleLancamento {

    private static final Logger log = LoggerFactory.getLogger(ControleLancamentoLegado.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public Lancamento buscarLancamento() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("static/lancamento-conta-legado.json");
        if (resourceAsStream == null) {
            log.error("Nao foi possivel carregar as informacoes de lancamento do sistema legado.");
            return null;
        }
        String json = JSONUtils.jsonFromStream(resourceAsStream);
        if (json == null) {
            log.error("A fonte de dados legada nao retornou dados validos.");
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            return objectMapper.readValue(json, Lancamento.class);
        } catch (IOException e) {
            log.error("Ocorreu um erro ao tentar realizar a leitura dos lancamentos legados.");
            return null;
        }
    }
}
