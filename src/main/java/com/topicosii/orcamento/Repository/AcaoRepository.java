package com.topicosii.orcamento.Repository;
import com.topicosii.orcamento.Model.Acao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcaoRepository extends JpaRepository<Acao, Integer> {
}
