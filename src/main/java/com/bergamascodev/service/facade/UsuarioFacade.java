package com.bergamascodev.service.facade;

import com.bergamascodev.dto.ChangeStatusDto;
import com.bergamascodev.dto.UsuarioDto;
import com.bergamascodev.service.UsuarioService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class UsuarioFacade {

    @Inject
    UsuarioService usuarioService;

    public UsuarioDto buscarPorId(Long id) {
        return usuarioService.buscarPorId(id);
    }

    @Transactional
    public UsuarioDto criar(UsuarioDto usuarioDto) {
        return usuarioService.criar(usuarioDto);
    }

    @Transactional
    public UsuarioDto alterar(Long id, UsuarioDto usuarioDto) {
        return usuarioService.alterar(id, usuarioDto);
    }

    @Transactional
    public UsuarioDto alterarStatus(Long id, ChangeStatusDto changeStatusDto) {
        return usuarioService.atualizarStatus(id, changeStatusDto);
    }
}
