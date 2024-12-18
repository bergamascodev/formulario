package com.bergamascodev.service.validator;

import com.bergamascodev.common.dto.enums.ResponseEnum;
import com.bergamascodev.dto.RegistroFormularioDto;
import com.bergamascodev.enums.MensagensErroEnum;
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
            throw gerarPerguntaException(MensagensErroEnum.REQUISICAO_INVALIDA, ResponseEnum.REQUISICAO_INVALIDA);
        }

        if(registroFormularioDto.getIdFormulario() == 0 || registroFormularioDto.getIdFormulario() == null) {
            throw gerarFormularioException(MensagensErroEnum.FORMULARIO_INVALIDO, ResponseEnum.REQUISICAO_INVALIDA);
        }

        if(registroFormularioDto.getIdPergunta() == 0 || registroFormularioDto.getIdPergunta() == null) {
            throw gerarPerguntaException(MensagensErroEnum.PERGUNTA_INVALIDA, ResponseEnum.REQUISICAO_INVALIDA);
        }
    }

    private BergamascoException gerarFormularioException(MensagensErroEnum mensagensErroEnum, ResponseEnum responseStatus){
        return new BergamascoException(mensagensErroEnum.getCodigo(), mensagensErroEnum.getMensagem(), responseStatus);
    }

    private BergamascoException gerarPerguntaException(MensagensErroEnum mensagensErroEnum, ResponseEnum responseStatus){
        return new BergamascoException(mensagensErroEnum.getCodigo(), mensagensErroEnum.getMensagem(), responseStatus);
    }

}
