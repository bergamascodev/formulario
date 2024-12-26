package com.bergamascodev.service.validator;

import com.bergamascodev.common.dto.enums.ResponseEnum;
import com.bergamascodev.dto.CategoriaDto;
import com.bergamascodev.enums.MensagemErroEnum;
import com.bergamascodev.exception.BergamascoException;
import com.bergamascodev.repository.CategoriaRepository;
import com.bergamascodev.service.converter.CategoriaConverter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CategoriaValidator {

    @Inject
    CategoriaRepository categoriaRepository;

    @Inject
    CategoriaConverter categoriaConverter;

    public void validarCategoria(CategoriaDto categoriaDto) {
        validarCategoria(null, categoriaDto);
    }

    public void validarCategoria(Long id, CategoriaDto categoriaDto) {
        validarId(categoriaDto);
    }

    public void validarId(CategoriaDto categoriaDto) {
        if (categoriaDto.getId() != null) {
            throw gerarCategoriaException(MensagemErroEnum.REQUISICAO_INVALIDA, ResponseEnum.REQUISICAO_INVALIDA);
        }
    }

    private BergamascoException gerarCategoriaException(MensagemErroEnum mensagensErroEnum, ResponseEnum responseStatus){
        return new BergamascoException(mensagensErroEnum.getCodigo(), mensagensErroEnum.getMensagem(), responseStatus);
    }
}
