package com.topicosii.orcamento.Repository;

import com.topicosii.orcamento.Model.ElementoDespesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementoDespesaRepository extends JpaRepository<ElementoDespesa, Integer> {
}
