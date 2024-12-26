package com.bergamascodev.repository;

import com.bergamascodev.entity.Pergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerguntaRepository extends JpaRepository<Pergunta, Long> {

}
