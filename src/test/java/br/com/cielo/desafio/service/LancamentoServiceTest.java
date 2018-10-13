package br.com.cielo.desafio.service;

import br.com.cielo.desafio.controller.response.LancamentoResponse;
import br.com.cielo.desafio.legado.ControleLancamento;
import br.com.cielo.desafio.legado.model.Lancamento;
import br.com.cielo.desafio.util.MockUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LancamentoServiceTest {

    @Mock
    private ControleLancamento controleLancamento;

    @InjectMocks
    private LancamentoService lancamentoService;

    @Test
    public void test_buscar_lancamentos_sem_fonte_de_dados() {
        when(controleLancamento.buscarLancamento()).thenReturn(null);
        List<LancamentoResponse> lancamentos = lancamentoService.getControleLancamento();
        Assert.assertNotNull(lancamentos);
        Assert.assertTrue(lancamentos.isEmpty());
    }

    @Test
    public void test_buscar_lancamentos_com_sucesso() throws IOException {
        Lancamento lancamento = MockUtil.getMockObjectFromJsonFile("lancamento-conta-legado.json", Lancamento.class);
        when(controleLancamento.buscarLancamento()).thenReturn(lancamento);
        List<LancamentoResponse> lancamentos = lancamentoService.getControleLancamento();
        Assert.assertNotNull(lancamentos);
        Assert.assertFalse(lancamentos.isEmpty());
        Assert.assertEquals(2, lancamentos.size());
    }
}
