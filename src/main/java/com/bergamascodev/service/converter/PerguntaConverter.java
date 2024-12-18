package com.bergamascodev.service.converter;

import com.bergamascodev.common.Converter;
import com.bergamascodev.dto.PerguntaDto;
import com.bergamascodev.entity.Categoria;
import com.bergamascodev.entity.Pergunta;
import com.bergamascodev.enums.MensagensErroEnum;
import com.bergamascodev.exception.BergamascoException;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class PerguntaConverter implements Converter<Pergunta, PerguntaDto> {

    @Override
    public PerguntaDto toDto(Pergunta pergunta) {
        return PerguntaDto.builder()
                .id(pergunta.getId())
                .categoriaId(pergunta.getCategoria().getId())
                .descricao(pergunta.getDescricao())
                .pontuacao(pergunta.getPontuacao())
                .build();
    }

    @Override
    public Pergunta toEntity(PerguntaDto perguntaDto) {
        return Pergunta.builder()
                .id(perguntaDto.getId())
                .categoria(getCategoria(perguntaDto))
                .descricao(perguntaDto.getDescricao())
                .pontuacao(perguntaDto.getPontuacao())
                .build();
    }

    @Override
    public List<PerguntaDto> toDtoList(List<Pergunta> perguntas) {
        List<PerguntaDto> perguntaDtos = new ArrayList<>();
        perguntas.forEach(pergunta -> perguntaDtos.add(toDto(pergunta)));
        return perguntaDtos;
    }

    @Override
    public PerguntaDto toDtoFromOptionalEntity(Optional<Pergunta> pergunta) {
        return pergunta.map(this::toDto).orElse(null);
    }

    @Override
    public Optional<PerguntaDto> toOptionalDtoFromOptionalEntity(Optional<Pergunta> pergunta) {
        return Optional.ofNullable(toDtoFromOptionalEntity(pergunta));
    }

    private Categoria getCategoria(PerguntaDto perguntaDto) {
        if(perguntaDto.getCategoriaId() == null) {
            throw new BergamascoException(MensagensErroEnum.PERGUNTA_INVALIDA.getCodigo(), MensagensErroEnum.PERGUNTA_INVALIDA.getMensagem());
        }
        return Categoria.builder().id(perguntaDto.getCategoriaId()).build();
    }
}
