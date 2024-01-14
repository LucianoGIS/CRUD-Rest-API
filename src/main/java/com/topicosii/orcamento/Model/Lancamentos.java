package com.topicosii.orcamento.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lancamentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean lancamentoInvalido;
    @ManyToOne
    @JoinColumn(name = "solicitante_id")
    private Solicitante solicitante;
    private int tipoLancamento;
    private Date dataLancamento;
    private int idLancamentoPai;
    @ManyToOne
    @JoinColumn(name = "id_unidade")
    private Unidade unidade;
    private String descricao;
    @ManyToOne
    @JoinColumn(name = "unidade_orcamentaria_id")
    private UnidadeOrcamentaria unidadeOrcamentaria;
    @ManyToOne
    @JoinColumn(name = "programa_id")
    private Programa programa;
    @ManyToOne
    @JoinColumn(name = "acao_id")
    private Acao acao;
    @ManyToOne
    @JoinColumn(name = "fonte_recurso_id")
    private FonteRecurso fonteRecurso;
    @ManyToOne
    @JoinColumn(name = "grupo_despesa_id")
    private GrupoDespesa grupoDespesa;
    @ManyToOne
    @JoinColumn(name = "modalidade_aplicacao_id")
    private ModalidadeAplicacao modalidadeAplicacao;
    @ManyToOne
    @JoinColumn(name = "elemento_despesa_id")
    private ElementoDespesa elementoDespesa;
    private String ged;
    private String contratado;
    @ManyToOne
    @JoinColumn(name = "objetivo_estrategico_id")
    private ObjetivoEstrategico objetivoEstrategico;
    private float Valor;
    @ManyToOne
    @JoinColumn(name = "tipo_transacao_id")
    private TipoTransacao tipoTransacao;
    private Date dacaCadastro;
    private Date dataAlteracao;
    private Integer anoOrcamento;
}
