package com.bergamascodev.service;

import com.bergamascodev.common.dto.enums.ResponseEnum;
import com.bergamascodev.dto.ChangeStatusDto;
import com.bergamascodev.dto.UsuarioDto;
import com.bergamascodev.entity.Time;
import com.bergamascodev.entity.Usuario;
import com.bergamascodev.enums.MensagemErroEnum;
import com.bergamascodev.exception.BergamascoException;
import com.bergamascodev.repository.TimeRepository;
import com.bergamascodev.repository.UsuarioRepository;
import com.bergamascodev.service.converter.UsuarioConverter;
import com.bergamascodev.service.validator.UsuarioValidator;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@ApplicationScoped
public class UsuarioService {

    @Inject
    UsuarioRepository usuarioRepository;

    @Inject
    UsuarioConverter usuarioConverter;

    @Inject
    TimeRepository timeRepository;

    @Inject
    UsuarioValidator usuarioValidator;

    public UsuarioDto criar(UsuarioDto usuarioDto) {
        usuarioValidator.validarUsuario(usuarioDto);
        try {
            Usuario usuario = usuarioConverter.toEntity(usuarioDto);
            Time time = timeRepository.getById(usuario.getTime().getId());
            usuario.setTime(time);
            usuarioRepository.saveAndFlush(usuario);
            return usuarioConverter.toDto(usuario);
        } catch (Exception e) {
            throw gerarUsuarioException(MensagemErroEnum.FALHA_SALVAR_USUARIO);
        }
    }

    public UsuarioDto alterar(Long id, UsuarioDto usuarioDto) {
        usuarioValidator.validarUsuario(id, usuarioDto);
        Usuario usuario = recuperarUsuario(id);
        try {
            atribuirValoresUsuario(usuario, usuarioConverter.toEntity(usuarioDto));
            usuarioRepository.saveAndFlush(usuario);
            return usuarioConverter.toDto(usuario);
        } catch (Exception e) {
            throw gerarUsuarioException(MensagemErroEnum.FALHA_SALVAR_USUARIO);
        }
    }

    public UsuarioDto buscarPorId(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isEmpty()){
            throw gerarUsuarioException(MensagemErroEnum.USUARIO_NAO_ENCONTRADO, ResponseEnum.REQUISICAO_INVALIDA);
        }
        return  usuarioConverter.toDtoFromOptionalEntity(usuarioOptional);
    }

    public UsuarioDto atualizarStatus(Long id, ChangeStatusDto changeStatusDto) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (id == null || usuarioOptional.isEmpty()) {
            throw gerarUsuarioException(MensagemErroEnum.REQUISICAO_INVALIDA, ResponseEnum.REQUISICAO_INVALIDA);
        }
        if (changeStatusDto.getStatus() == null) {
            throw gerarUsuarioException(MensagemErroEnum.STATUS_INVALIDO, ResponseEnum.REQUISICAO_INVALIDA);
        }
        try {
            Usuario usuario = usuarioOptional.get();
            usuario.setAtivo(changeStatusDto.getStatus());
            usuarioRepository.saveAndFlush(usuario);
            return usuarioConverter.toDto(usuario);
        } catch (Exception e) {
            throw gerarUsuarioException(MensagemErroEnum.FALHA_SALVAR_STATUS);
        }
    }

    private Usuario recuperarUsuario(Long id) {
        Usuario usuario = usuarioRepository.getById(id);
        if (usuario == null) {
            throw gerarUsuarioException(MensagemErroEnum.USUARIO_NAO_ENCONTRADO, ResponseEnum.REQUISICAO_INVALIDA);
        }
        return usuario;
    }

    private Usuario atribuirValoresUsuario(Usuario usuarioOriginal, Usuario usuarioAlterado){
        Time time = timeRepository.getById(usuarioAlterado.getTime().getId());
        usuarioOriginal.setTime(time);
        usuarioOriginal.setAtivo(usuarioAlterado.getAtivo());
        usuarioOriginal.setCpf(usuarioAlterado.getCpf());
        usuarioOriginal.setNome(usuarioAlterado.getNome());
        usuarioOriginal.setEmail(usuarioAlterado.getEmail());
        return usuarioOriginal;
    }

    private BergamascoException gerarUsuarioException(MensagemErroEnum mensagensErroEnum) {
        return new BergamascoException(mensagensErroEnum.getCodigo(), mensagensErroEnum.getMensagem());
    }

    private BergamascoException gerarUsuarioException(MensagemErroEnum mensagensErroEnum, ResponseEnum responseStatus) {
        return new BergamascoException(mensagensErroEnum.getCodigo(), mensagensErroEnum.getMensagem(), responseStatus);
    }
}
