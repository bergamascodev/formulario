package com.bergamascodev.repository;

import com.bergamascodev.entity.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormularioRepository extends JpaRepository<Formulario, Long> {

}
