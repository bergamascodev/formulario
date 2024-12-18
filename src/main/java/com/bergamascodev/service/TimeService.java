package com.bergamascodev.service;

import com.bergamascodev.common.dto.enums.ResponseEnum;
import com.bergamascodev.dto.TimeDto;
import com.bergamascodev.entity.Time;
import com.bergamascodev.enums.MensagensErroEnum;
import com.bergamascodev.exception.BergamascoException;
import com.bergamascodev.repository.TimeRepository;
import com.bergamascodev.service.converter.TimeConverter;
import com.bergamascodev.service.validator.TimeValidator;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@ApplicationScoped
public class TimeService {

    @Inject
    TimeRepository timeRepository;

    @Inject
    TimeConverter timeConverter;

    @Inject
    TimeValidator timeValidator;

    public TimeDto criar(TimeDto timeDto) {
        timeValidator.validarTime(timeDto);
        try {
            Time time = timeConverter.toEntity(timeDto);
            timeRepository.saveAndFlush(time);
            return timeConverter.toDto(time);
        } catch (Exception e) {
            throw gerarTimeExcpetion(MensagensErroEnum.FALHA_SALVAR_CATEGORIA);
        }
    }

    public TimeDto alterar(Long id, TimeDto timeDto) {
        timeValidator.validarTime(id, timeDto);
        Time time = recuperarTime(id);
        try {
            atribuirValoresTime(time, timeConverter.toEntity(timeDto));
            timeRepository.saveAndFlush(time);
            return timeConverter.toDto(time);
        } catch (Exception e) {
            throw gerarTimeExcpetion(MensagensErroEnum.FALHA_SALVAR_CATEGORIA);
        }
    }

    public TimeDto buscarPorId(Long id) {
        Optional<Time> timeOptional = timeRepository.findById(id);
        if (timeOptional.isEmpty()){
            throw gerarTimeExcpetion(MensagensErroEnum.TIME_NAO_ENCONTRADO, ResponseEnum.REQUISICAO_INVALIDA);
        }
        return  timeConverter.toDtoFromOptionalEntity(timeOptional);
    }

    private Time recuperarTime(Long id) {
        Time time = timeRepository.getById(id);
        if (time == null) {
            throw gerarTimeExcpetion(MensagensErroEnum.TIME_NAO_ENCONTRADO, ResponseEnum.REQUISICAO_INVALIDA);
        }
        return time;
    }

    private Time atribuirValoresTime(Time timeOriginal, Time timeAlterado){
        timeOriginal.setDescricao(timeAlterado.getDescricao());
        return timeOriginal;
    }

    private BergamascoException gerarTimeExcpetion(MensagensErroEnum mensagensErroEnum) {
        return new BergamascoException(mensagensErroEnum.getCodigo(), mensagensErroEnum.getMensagem());
    }

    private BergamascoException gerarTimeExcpetion(MensagensErroEnum mensagensErroEnum, ResponseEnum responseStatus) {
        return new BergamascoException(mensagensErroEnum.getCodigo(), mensagensErroEnum.getMensagem(), responseStatus);
    }
}
