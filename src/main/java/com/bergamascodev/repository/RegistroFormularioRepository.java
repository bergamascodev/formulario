package com.bergamascodev.repository;

import com.bergamascodev.entity.RegistroFormulario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroFormularioRepository extends JpaRepository<RegistroFormulario, Long> {

}
