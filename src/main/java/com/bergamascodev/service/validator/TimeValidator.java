package com.bergamascodev.service.validator;

import com.bergamascodev.common.dto.enums.ResponseEnum;
import com.bergamascodev.dto.TimeDto;
import com.bergamascodev.enums.MensagensErroEnum;
import com.bergamascodev.exception.BergamascoException;
import com.bergamascodev.repository.TimeRepository;
import com.bergamascodev.service.converter.TimeConverter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class TimeValidator {

    @Inject
    TimeRepository timeRepository;

    @Inject
    TimeConverter timeConverter;

    public void validarTime(TimeDto timeDto) {
        validarTime(null, timeDto);
    }

    public void validarTime(Long id, TimeDto timeDto) {
        validarId(timeDto);
    }

    public void validarId(TimeDto timeDto) {
        if(timeDto.getId() != null) {
            throw gerarTimeException(MensagensErroEnum.REQUISICAO_INVALIDA, ResponseEnum.REQUISICAO_INVALIDA);
        }
    }

    private BergamascoException gerarTimeException(MensagensErroEnum mensagensErroEnum, ResponseEnum responseStatus){
        return new BergamascoException(mensagensErroEnum.getCodigo(), mensagensErroEnum.getMensagem(), responseStatus);
    }
}
