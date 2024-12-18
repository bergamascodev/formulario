package com.bergamascodev.service.facade;

import com.bergamascodev.dto.PerguntaDto;
import com.bergamascodev.service.PerguntaService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class PerguntaFacade {

    @Inject
    PerguntaService perguntaService;

    public PerguntaDto buscarPorId(Long id) {
        return perguntaService.buscarPorId(id);
    }

    @Transactional
    public PerguntaDto criar(PerguntaDto perguntaDto) {
        return perguntaService.criar(perguntaDto);
    }

    @Transactional
    public PerguntaDto alterar(Long id, PerguntaDto perguntaDto) {
        return perguntaService.alterar(id, perguntaDto);
    }
}
