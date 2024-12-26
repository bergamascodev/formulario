package com.bergamascodev.service.validator;

import com.bergamascodev.common.dto.enums.ResponseEnum;
import com.bergamascodev.dto.RegistroFormularioDto;
import com.bergamascodev.enums.MensagemErroEnum;
import com.bergamascodev.exception.BergamascoException;
import com.bergamascodev.repository.RegistroFormularioRepository;
import com.bergamascodev.service.converter.RegistroFormularioConverter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class RegistroFormularioValidator {

    @Inject
    RegistroFormularioRepository registroFormularioRepository;

    @Inject
    RegistroFormularioConverter registroFormularioConverter;

    public void validarRegistro(RegistroFormularioDto registroFormularioDto) {
        validarRegistro(null, registroFormularioDto);
    }

    public void validarRegistro(Long id, RegistroFormularioDto registroFormularioDto) {
        validarIdFormularioPergunta(registroFormularioDto);
    }

    public void validarIdFormularioPergunta(RegistroFormularioDto registroFormularioDto) {

        if (registroFormularioDto.getId() != null) {
            throw gerarPerguntaException(MensagemErroEnum.REQUISICAO_INVALIDA, ResponseEnum.REQUISICAO_INVALIDA);
        }

        if(registroFormularioDto.getIdFormulario() == 0 || registroFormularioDto.getIdFormulario() == null) {
            throw gerarFormularioException(MensagemErroEnum.FORMULARIO_INVALIDO, ResponseEnum.REQUISICAO_INVALIDA);
        }

        if(registroFormularioDto.getIdPergunta() == 0 || registroFormularioDto.getIdPergunta() == null) {
            throw gerarPerguntaException(MensagemErroEnum.PERGUNTA_INVALIDA, ResponseEnum.REQUISICAO_INVALIDA);
        }
    }

    private BergamascoException gerarFormularioException(MensagemErroEnum mensagensErroEnum, ResponseEnum responseStatus){
        return new BergamascoException(mensagensErroEnum.getCodigo(), mensagensErroEnum.getMensagem(), responseStatus);
    }

    private BergamascoException gerarPerguntaException(MensagemErroEnum mensagensErroEnum, ResponseEnum responseStatus){
        return new BergamascoException(mensagensErroEnum.getCodigo(), mensagensErroEnum.getMensagem(), responseStatus);
    }

}
