package com.topicosii.orcamento.Repository;

import com.topicosii.orcamento.Model.Lancamentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentosRepository extends JpaRepository<Lancamentos, Integer> {
}
