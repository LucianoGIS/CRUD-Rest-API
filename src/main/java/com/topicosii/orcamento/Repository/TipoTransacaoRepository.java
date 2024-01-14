package com.topicosii.orcamento.Repository;

import com.topicosii.orcamento.Model.TipoTransacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTransacaoRepository extends JpaRepository<TipoTransacao, Integer> {
}
