package com.bergamascodev.service.validator;

import com.bergamascodev.common.dto.enums.ResponseEnum;
import com.bergamascodev.dto.UsuarioDto;
import com.bergamascodev.enums.MensagemErroEnum;
import com.bergamascodev.exception.BergamascoException;
import com.bergamascodev.repository.UsuarioRepository;
import com.bergamascodev.service.converter.UsuarioConverter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class UsuarioValidator {

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    UsuarioConverter usuarioConverter;

    public void validarUsuario(UsuarioDto usuarioDto) {
        validarUsuario(null, usuarioDto);
    }

    public void validarUsuario(Long id, UsuarioDto usuarioDto) {
        validarIdETime(usuarioDto);
    }

    public void validarIdETime(UsuarioDto usuarioDto) {

        if (usuarioDto.getId() != null) {
            throw gerarUsuarioException(MensagemErroEnum.REQUISICAO_INVALIDA, ResponseEnum.REQUISICAO_INVALIDA);
        }

        if (usuarioDto.getTimeId() == 0 || usuarioDto.getTimeId() == null) {
            throw gerarUsuarioException(MensagemErroEnum.TIME_NAO_ENCONTRADO, ResponseEnum.REQUISICAO_INVALIDA);
        }
    }

    private BergamascoException gerarUsuarioException(MensagemErroEnum mensagensErroEnum, ResponseEnum responseStatus) {
        return new BergamascoException(mensagensErroEnum.getCodigo(), mensagensErroEnum.getMensagem(), responseStatus);
    }
}
