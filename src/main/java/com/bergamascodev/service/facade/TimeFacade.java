package com.bergamascodev.service.facade;

import com.bergamascodev.dto.TimeDto;
import com.bergamascodev.service.TimeService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class TimeFacade {

    @Inject
    TimeService timeService;

    public TimeDto buscarPorId(Long id) {
        return timeService.buscarPorId(id);
    }

    @Transactional
    public TimeDto criar(TimeDto timeDto) {
        return timeService.criar(timeDto);
    }

    @Transactional
    public TimeDto alterar(Long id, TimeDto timeDto) {
        return timeService.alterar(id, timeDto);
    }
}
