package com.bergamascodev.service.converter;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteConverter {//implements Converter<Cliente, ClienteDto> {

    /*@Override
    public ClienteDto toDto(Cliente entity) {
        return ClienteDto.builder()
                .id(entity.getId())
                .cpf(entity.getCpf())
                .nome(entity.getNome())
                .status(entity.getStatus())
                .build();
    }

    @Override
    public Cliente toEntity(ClienteDto dto) {
        return Cliente.builder()
                .id(dto.getId())
                .cpf(dto.getCpf())
                .nome(dto.getNome())
                .status(dto.getStatus())
                .build();
    }

    @Override
    public List<ClienteDto> toDtoList(List<Cliente> clientes) {
        List<ClienteDto> clienteDtos = new ArrayList<>();
        clientes.forEach(cliente -> clienteDtos.add(toDto(cliente)));
        return clienteDtos;
    }

    @Override
    public ClienteDto toDtoFromOptionalEntity(Optional<Cliente> cliente) {
        return cliente.map(this::toDto).orElse(null);
    }

    @Override
    public Optional<ClienteDto> toOptionalDtoFromOptionalEntity(Optional<Cliente> cliente) {
        return Optional.ofNullable(toDtoFromOptionalEntity(cliente));
    }*/

}
