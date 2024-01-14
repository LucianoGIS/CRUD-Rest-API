package com.topicosii.orcamento.Repository;
import com.topicosii.orcamento.Model.UnidadeOrcamentaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeOrcamentariaRepository extends JpaRepository<UnidadeOrcamentaria, Integer> {
}
