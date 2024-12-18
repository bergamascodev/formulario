package com.bergamascodev.service.validator;

import com.bergamascodev.common.dto.enums.ResponseEnum;
import com.bergamascodev.dto.PerguntaDto;
import com.bergamascodev.enums.MensagensErroEnum;
import com.bergamascodev.exception.BergamascoException;
import com.bergamascodev.repository.PerguntaRepository;
import com.bergamascodev.service.converter.PerguntaConverter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class PerguntaValidator {

    @Inject
    PerguntaRepository perguntaRepository;

    @Inject
    PerguntaConverter perguntaConverter;

    public void validarPergunta(PerguntaDto perguntaDto) {
        validarPergunta(null, perguntaDto);
    }

    public void validarPergunta(Long id, PerguntaDto perguntaDto) {
        validarIdECategoria(perguntaDto);
    }

    public void validarIdECategoria(PerguntaDto perguntaDto) {

        if (perguntaDto.getId() != null) {
            throw gerarPerguntaException(MensagensErroEnum.REQUISICAO_INVALIDA, ResponseEnum.REQUISICAO_INVALIDA);
        }

        if (perguntaDto.getCategoriaId() == 0 || perguntaDto.getCategoriaId() == null) {
            throw gerarPerguntaException(MensagensErroEnum.CATEGORIA_NAO_ENCONTRADA, ResponseEnum.REQUISICAO_INVALIDA);
        }
    }

    private BergamascoException gerarPerguntaException(MensagensErroEnum mensagensErroEnum, ResponseEnum responseStatus){
        return new BergamascoException(mensagensErroEnum.getCodigo(), mensagensErroEnum.getMensagem(), responseStatus);
    }
}
