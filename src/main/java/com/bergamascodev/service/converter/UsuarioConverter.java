package com.bergamascodev.service.converter;

import com.bergamascodev.common.Converter;
import com.bergamascodev.dto.UsuarioDto;
import com.bergamascodev.entity.Time;
import com.bergamascodev.entity.Usuario;
import com.bergamascodev.enums.MensagemErroEnum;
import com.bergamascodev.exception.BergamascoException;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UsuarioConverter implements Converter<Usuario, UsuarioDto> {

    @Override
    public UsuarioDto toDto(Usuario usuario) {
        return UsuarioDto.builder()
                .id(usuario.getId())
                .ativo(usuario.getAtivo())
                .cpf(usuario.getCpf())
                .email(usuario.getEmail())
                .nome(usuario.getNome())
                .timeId(usuario.getTime().getId())
                .build();
    }

    @Override
    public Usuario toEntity(UsuarioDto usuarioDto) {
        return Usuario.builder()
                .id(usuarioDto.getId())
                .ativo(usuarioDto.getAtivo())
                .cpf(usuarioDto.getCpf())
                .email(usuarioDto.getEmail())
                .nome(usuarioDto.getNome())
                .time(getTime(usuarioDto))
                .build();
    }

    @Override
    public List<UsuarioDto> toDtoList(List<Usuario> usuarios) {
        List<UsuarioDto> usuarioDtos = new ArrayList<>();
        usuarios.forEach(usuario -> usuarioDtos.add(toDto(usuario)));
        return usuarioDtos;
    }

    @Override
    public UsuarioDto toDtoFromOptionalEntity(Optional<Usuario> usuario) {
        return usuario.map(this::toDto).orElse(null);
    }

    @Override
    public Optional<UsuarioDto> toOptionalDtoFromOptionalEntity(Optional<Usuario> usuario) {
        return Optional.ofNullable(toDtoFromOptionalEntity(usuario));
    }

    private Time getTime(UsuarioDto usuarioDto) {
        if(usuarioDto.getTimeId() == null) {
            throw new BergamascoException(MensagemErroEnum.TIME_INVALIDO.getCodigo(), MensagemErroEnum.TIME_INVALIDO.getMensagem());
        }
        return Time.builder().id(usuarioDto.getTimeId()).build();
    }
}
