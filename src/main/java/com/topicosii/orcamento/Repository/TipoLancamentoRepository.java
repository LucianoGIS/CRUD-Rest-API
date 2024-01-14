package com.topicosii.orcamento.Repository;
import com.topicosii.orcamento.Model.TipoLancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoLancamentoRepository extends JpaRepository<TipoLancamento, Integer> {
}
