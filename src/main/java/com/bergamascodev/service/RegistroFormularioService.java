package com.bergamascodev.service;

import com.bergamascodev.common.dto.enums.ResponseEnum;
import com.bergamascodev.dto.RegistroFormularioDto;
import com.bergamascodev.entity.Formulario;
import com.bergamascodev.entity.Pergunta;
import com.bergamascodev.entity.RegistroFormulario;
import com.bergamascodev.enums.MensagemErroEnum;
import com.bergamascodev.exception.BergamascoException;
import com.bergamascodev.repository.FormularioRepository;
import com.bergamascodev.repository.PerguntaRepository;
import com.bergamascodev.repository.RegistroFormularioRepository;
import com.bergamascodev.service.converter.RegistroFormularioConverter;
import com.bergamascodev.service.validator.RegistroFormularioValidator;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class RegistroFormularioService {

    @Inject
    RegistroFormularioRepository registroFormularioRepository;

    @Inject
    RegistroFormularioConverter registroFormularioConverter;

    @Inject
    RegistroFormularioValidator registroFormularioValidator;

    @Inject
    PerguntaRepository perguntaRepository;

    @Inject
    FormularioRepository formularioRepository;

    public RegistroFormularioDto criar(RegistroFormularioDto registroFormularioDto) {
        registroFormularioValidator.validarRegistro(registroFormularioDto);
        try {
            RegistroFormulario registroFormulario = registroFormularioConverter.toEntity(registroFormularioDto);
            Pergunta pergunta = perguntaRepository.getById(registroFormulario.getPergunta().getId());
            Formulario formulario = formularioRepository.getById(registroFormulario.getFormulario().getId());
            registroFormulario.setPergunta(pergunta);
            registroFormulario.setFormulario(formulario);
            registroFormularioRepository.saveAndFlush(registroFormulario);
            return registroFormularioConverter.toDto(registroFormulario);
        } catch (Exception e) {
            throw gerarRegistroException(MensagemErroEnum.REGISTRO_INVALIDO);
        }
    }

    private BergamascoException gerarRegistroException(MensagemErroEnum mensagensErroEnum) {
        return new BergamascoException(mensagensErroEnum.getCodigo(), mensagensErroEnum.getMensagem());
    }

    private BergamascoException gerarRegistroException(MensagemErroEnum mensagensErroEnum, ResponseEnum responseStatus) {
        return new BergamascoException(mensagensErroEnum.getCodigo(), mensagensErroEnum.getMensagem(), responseStatus);
    }
}
