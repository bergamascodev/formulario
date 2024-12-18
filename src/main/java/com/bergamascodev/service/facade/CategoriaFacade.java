package com.bergamascodev.service.facade;

import com.bergamascodev.dto.CategoriaDto;
import com.bergamascodev.service.CategoriaService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class CategoriaFacade {

    @Inject
    CategoriaService categoriaService;

    public CategoriaDto buscarPorId(Long id) {
        return categoriaService.buscarPorId(id);
    }

    @Transactional
    public CategoriaDto criar(CategoriaDto categoriaDto) {
        return categoriaService.criar(categoriaDto);
    }

    @Transactional
    public CategoriaDto alterar(Long id, CategoriaDto categoriaDto) {
        return categoriaService.alterar(id, categoriaDto);
    }
}
