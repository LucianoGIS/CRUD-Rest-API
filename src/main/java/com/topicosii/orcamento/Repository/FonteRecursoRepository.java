package com.topicosii.orcamento.Repository;

import com.topicosii.orcamento.Model.FonteRecurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FonteRecursoRepository extends JpaRepository<FonteRecurso, Integer> {

}
