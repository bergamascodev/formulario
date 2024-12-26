package com.bergamascodev.service.converter;

import com.bergamascodev.common.Converter;
import com.bergamascodev.dto.CategoriaDto;
import com.bergamascodev.entity.Categoria;
import lombok.Builder;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Builder
public class CategoriaConverter implements Converter<Categoria, CategoriaDto> {

    @Override
    public CategoriaDto toDto(Categoria categoria) {
        return CategoriaDto.builder()
                .id(categoria.getId())
                .descricao(categoria.getDescricao())
                .build();
    }

    @Override
    public Categoria toEntity(CategoriaDto categoriaDto) {
        return Categoria.builder()
                .id(categoriaDto.getId())
                .descricao(categoriaDto.getDescricao())
                .build();
    }

    @Override
    public List<CategoriaDto> toDtoList(List<Categoria> categorias) {
        List<CategoriaDto> categoriaDtos = new ArrayList<>();
        categorias.forEach(categoria -> categoriaDtos.add(toDto(categoria)));
        return categoriaDtos;
    }

    @Override
    public CategoriaDto toDtoFromOptionalEntity(Optional<Categoria> categoria) {
        return categoria.map(this::toDto).orElse(null);
    }

    @Override
    public Optional<CategoriaDto> toOptionalDtoFromOptionalEntity(Optional<Categoria> categoria) {
        return Optional.ofNullable(toDtoFromOptionalEntity(categoria));
    }
}
