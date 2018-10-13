package br.com.cielo.desafio.controller.response;

import br.com.cielo.desafio.legado.model.Lancamento;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.TimeZone;

public class LancamentoResponse implements Serializable {

    private LocalDateTime dataLancamento;

    private String descricao;

    private long numero;

    private String situacao;

    private LocalDateTime dataConfirmacao;

    private String dadosBancarios;

    private double valorFinal;

    public LancamentoResponse(Lancamento.ListaControleLancamento lancamento) {
        ZoneId zoneId = TimeZone.getDefault().toZoneId();

        this.dataLancamento = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(lancamento.dateLancamentoContaCorrenteCliente), zoneId);

        Lancamento.ListaControleLancamento.LancamentoContaCorrenteCliente contaCorrente =
                lancamento.lancamentoContaCorrenteCliente;
        this.descricao = contaCorrente.nomeTipoOperacao;

        this.numero = contaCorrente.numeroRemessaBanco;

        this.situacao = contaCorrente.nomeSituacaoRemessa;

        this.dataConfirmacao = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(lancamento.dateEfetivaLancamento), zoneId);

        Lancamento.ListaControleLancamento.LancamentoContaCorrenteCliente.DadosDomicilioBancario domicilioBancario =
                contaCorrente.dadosDomicilioBancario;
        this.dadosBancarios = String.format("%s Ag %s CC %s", lancamento.nomeBanco.trim(),
                domicilioBancario.numeroAgencia, domicilioBancario.numeroContaCorrente);

        this.valorFinal = lancamento.valorLancamentoRemessa;
    }

    public LocalDateTime getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDateTime dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public LocalDateTime getDataConfirmacao() {
        return dataConfirmacao;
    }

    public void setDataConfirmacao(LocalDateTime dataConfirmacao) {
        this.dataConfirmacao = dataConfirmacao;
    }

    public String getDadosBancarios() {
        return dadosBancarios;
    }

    public void setDadosBancarios(String dadosBancarios) {
        this.dadosBancarios = dadosBancarios;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }
}
