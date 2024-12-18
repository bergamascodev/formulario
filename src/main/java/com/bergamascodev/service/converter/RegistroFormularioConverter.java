package com.bergamascodev.service.converter;

import com.bergamascodev.common.Converter;
import com.bergamascodev.dto.RegistroFormularioDto;
import com.bergamascodev.entity.Formulario;
import com.bergamascodev.entity.Pergunta;
import com.bergamascodev.entity.RegistroFormulario;
import com.bergamascodev.enums.MensagensErroEnum;
import com.bergamascodev.exception.BergamascoException;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class RegistroFormularioConverter implements Converter<RegistroFormulario, RegistroFormularioDto> {

    @Override
    public RegistroFormularioDto toDto(RegistroFormulario registroFormulario) {
        return RegistroFormularioDto.builder()
                .idFormulario(registroFormulario.getId())
                .idPergunta(registroFormulario.getId())
                .build();
    }

    @Override
    public RegistroFormulario toEntity(RegistroFormularioDto registroFormularioDto) {
        return RegistroFormulario.builder()
                .formulario(getFormulario(registroFormularioDto))
                .pergunta(getPergunta(registroFormularioDto))
                .build();
    }

    @Override
    public List<RegistroFormularioDto> toDtoList(List<RegistroFormulario> registroFormularios) {
        List<RegistroFormularioDto> registroFormularioDtos = new ArrayList<>();
        registroFormularios.forEach(registroFormulario -> registroFormularioDtos.add(toDto(registroFormulario)));
        return registroFormularioDtos;
    }

    @Override
    public RegistroFormularioDto toDtoFromOptionalEntity(Optional<RegistroFormulario> registroFormulario) {
        return registroFormulario.map(this::toDto).orElse(null);
    }

    @Override
    public Optional<RegistroFormularioDto> toOptionalDtoFromOptionalEntity(Optional<RegistroFormulario> registroFormulario) {
        return Optional.ofNullable(toDtoFromOptionalEntity(registroFormulario));
    }

    private Formulario getFormulario(RegistroFormularioDto registroFormularioDto) {
        if(registroFormularioDto.getIdFormulario() == null) {
            throw new BergamascoException(MensagensErroEnum.FORMULARIO_INVALIDO.getCodigo(), MensagensErroEnum.FORMULARIO_INVALIDO.getMensagem());
        }
        return Formulario.builder().id(registroFormularioDto.getIdFormulario()).build();
    }

    private Pergunta getPergunta(RegistroFormularioDto registroFormularioDto) {
        if(registroFormularioDto.getIdPergunta() == null) {
            throw new BergamascoException(MensagensErroEnum.PERGUNTA_INVALIDA.getCodigo(), MensagensErroEnum.PERGUNTA_INVALIDA.getMensagem());
        }
        return Pergunta.builder().id(registroFormularioDto.getIdPergunta()).build();
    }

}
