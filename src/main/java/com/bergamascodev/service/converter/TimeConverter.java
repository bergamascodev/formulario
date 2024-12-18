package com.bergamascodev.service.converter;

import com.bergamascodev.common.Converter;
import com.bergamascodev.dto.TimeDto;
import com.bergamascodev.entity.Time;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class TimeConverter implements Converter<Time, TimeDto> {

    @Override
    public TimeDto toDto(Time time) {
        return TimeDto.builder()
                .id(time.getId())
                .descricao(time.getDescricao())
                .build();
    }

    @Override
    public Time toEntity(TimeDto timeDto) {
        return Time.builder()
                .id(timeDto.getId())
                .descricao(timeDto.getDescricao())
                .build();
    }

    @Override
    public List<TimeDto> toDtoList(List<Time> times) {
        List<TimeDto> timeDtos = new ArrayList<>();
        times.forEach(time -> timeDtos.add(toDto(time)));
        return timeDtos;
    }

    @Override
    public TimeDto toDtoFromOptionalEntity(Optional<Time> time) {
        return time.map(this::toDto).orElse(null);
    }

    @Override
    public Optional<TimeDto> toOptionalDtoFromOptionalEntity(Optional<Time> time) {
        return Optional.ofNullable(toDtoFromOptionalEntity(time));
    }
}
