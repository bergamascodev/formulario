package com.bergamascodev.service.facade;

import com.bergamascodev.dto.RegistroFormularioDto;
import com.bergamascodev.service.RegistroFormularioService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class RegistroFormularioFacade {

    @Inject
    RegistroFormularioService registroFormularioService;

    @Transactional
    public RegistroFormularioDto criar(RegistroFormularioDto registroFormularioDto) {
        return registroFormularioService.criar(registroFormularioDto);
    }
}
