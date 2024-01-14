package com.topicosii.orcamento.Repository;

import com.topicosii.orcamento.Model.ObjetivoEstrategico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjetivoEstrategicoRepository extends JpaRepository<ObjetivoEstrategico, Integer> {
}
