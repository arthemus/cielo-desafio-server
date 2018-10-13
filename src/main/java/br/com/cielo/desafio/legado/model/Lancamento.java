package br.com.cielo.desafio.legado.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Mapeamento gerado com auxilio do site <a>https://timboudreau.com/blog/json/read</a>
 */
public final class Lancamento {

    public final TotalControleLancamento totalControleLancamento;
    public final ListaControleLancamento listaControleLancamento[];
    public final long indice;
    public final long tamanhoPagina;
    public final long totalElements;

    @JsonCreator
    public Lancamento(@JsonProperty("totalControleLancamento") TotalControleLancamento totalControleLancamento,
                      @JsonProperty("listaControleLancamento") ListaControleLancamento[] listaControleLancamento,
                      @JsonProperty("indice") long indice,
                      @JsonProperty("tamanhoPagina") long tamanhoPagina,
                      @JsonProperty("totalElements") long totalElements) {
        this.totalControleLancamento = totalControleLancamento;
        this.listaControleLancamento = listaControleLancamento;
        this.indice = indice;
        this.tamanhoPagina = tamanhoPagina;
        this.totalElements = totalElements;
    }

    public static final class TotalControleLancamento {

        public final long quantidadeLancamentos;
        public final long quantidadeRemessas;
        public final double valorLancamentos;

        @JsonCreator
        public TotalControleLancamento(@JsonProperty("quantidadeLancamentos") long quantidadeLancamentos,
                                       @JsonProperty("quantidadeRemessas") long quantidadeRemessas,
                                       @JsonProperty("valorLancamentos") double valorLancamentos) {
            this.quantidadeLancamentos = quantidadeLancamentos;
            this.quantidadeRemessas = quantidadeRemessas;
            this.valorLancamentos = valorLancamentos;
        }
    }

    public static final class ListaControleLancamento {

        public final LancamentoContaCorrenteCliente lancamentoContaCorrenteCliente;
        public final String dataEfetivaLancamento;
        public final String dataLancamentoContaCorrenteCliente;
        public final long numeroEvento;
        public final String descricaoGrupoPagamento;
        public final String codigoIdentificadorUnico;
        public final String nomeBanco;
        public final long quantidadeLancamentoRemessa;
        public final String numeroRaizCNPJ;
        public final String numeroSufixoCNPJ;
        public final long valorLancamentoRemessa;
        public final long dateLancamentoContaCorrenteCliente;
        public final long dateEfetivaLancamento;

        @JsonCreator
        public ListaControleLancamento(@JsonProperty("lancamentoContaCorrenteCliente") LancamentoContaCorrenteCliente lancamentoContaCorrenteCliente,
                                       @JsonProperty("dataEfetivaLancamento") String dataEfetivaLancamento,
                                       @JsonProperty("dataLancamentoContaCorrenteCliente") String dataLancamentoContaCorrenteCliente,
                                       @JsonProperty("numeroEvento") long numeroEvento,
                                       @JsonProperty("descricaoGrupoPagamento") String descricaoGrupoPagamento,
                                       @JsonProperty("codigoIdentificadorUnico") String codigoIdentificadorUnico,
                                       @JsonProperty("nomeBanco") String nomeBanco,
                                       @JsonProperty("quantidadeLancamentoRemessa") long quantidadeLancamentoRemessa,
                                       @JsonProperty("numeroRaizCNPJ") String numeroRaizCNPJ,
                                       @JsonProperty("numeroSufixoCNPJ") String numeroSufixoCNPJ,
                                       @JsonProperty("valorLancamentoRemessa") long valorLancamentoRemessa,
                                       @JsonProperty("dateLancamentoContaCorrenteCliente") long dateLancamentoContaCorrenteCliente,
                                       @JsonProperty("dateEfetivaLancamento") long dateEfetivaLancamento) {
            this.lancamentoContaCorrenteCliente = lancamentoContaCorrenteCliente;
            this.dataEfetivaLancamento = dataEfetivaLancamento;
            this.dataLancamentoContaCorrenteCliente = dataLancamentoContaCorrenteCliente;
            this.numeroEvento = numeroEvento;
            this.descricaoGrupoPagamento = descricaoGrupoPagamento;
            this.codigoIdentificadorUnico = codigoIdentificadorUnico;
            this.nomeBanco = nomeBanco;
            this.quantidadeLancamentoRemessa = quantidadeLancamentoRemessa;
            this.numeroRaizCNPJ = numeroRaizCNPJ;
            this.numeroSufixoCNPJ = numeroSufixoCNPJ;
            this.valorLancamentoRemessa = valorLancamentoRemessa;
            this.dateLancamentoContaCorrenteCliente = dateLancamentoContaCorrenteCliente;
            this.dateEfetivaLancamento = dateEfetivaLancamento;
        }

        public static final class LancamentoContaCorrenteCliente {

            public final long numeroRemessaBanco;
            public final DadosAnaliticoLancamentoFinanceiroCliente dadosAnaliticoLancamentoFinanceiroCliente[];
            public final String nomeSituacaoRemessa;
            public final DadosDomicilioBancario dadosDomicilioBancario;
            public final String nomeTipoOperacao;

            @JsonCreator
            public LancamentoContaCorrenteCliente(@JsonProperty("numeroRemessaBanco") long numeroRemessaBanco,
                                                  @JsonProperty("dadosAnaliticoLancamentoFinanceiroCliente") DadosAnaliticoLancamentoFinanceiroCliente[] dadosAnaliticoLancamentoFinanceiroCliente,
                                                  @JsonProperty("nomeSituacaoRemessa") String nomeSituacaoRemessa,
                                                  @JsonProperty("dadosDomicilioBancario") DadosDomicilioBancario dadosDomicilioBancario,
                                                  @JsonProperty("nomeTipoOperacao") String nomeTipoOperacao) {
                this.numeroRemessaBanco = numeroRemessaBanco;
                this.dadosAnaliticoLancamentoFinanceiroCliente = dadosAnaliticoLancamentoFinanceiroCliente;
                this.nomeSituacaoRemessa = nomeSituacaoRemessa;
                this.dadosDomicilioBancario = dadosDomicilioBancario;
                this.nomeTipoOperacao = nomeTipoOperacao;
            }

            public static final class DadosAnaliticoLancamentoFinanceiroCliente {

                @JsonCreator
                public DadosAnaliticoLancamentoFinanceiroCliente() {
                }
            }

            public static final class DadosDomicilioBancario {

                public final long codigoBanco;
                public final long numeroAgencia;
                public final String numeroContaCorrente;

                @JsonCreator
                public DadosDomicilioBancario(@JsonProperty("codigoBanco") long codigoBanco,
                                              @JsonProperty("numeroAgencia") long numeroAgencia,
                                              @JsonProperty("numeroContaCorrente") String numeroContaCorrente) {
                    this.codigoBanco = codigoBanco;
                    this.numeroAgencia = numeroAgencia;
                    this.numeroContaCorrente = numeroContaCorrente;
                }
            }
        }
    }
}