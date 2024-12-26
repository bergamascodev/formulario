package com.bergamascodev.service;

import com.bergamascodev.common.dto.enums.ResponseEnum;
import com.bergamascodev.dto.CategoriaDto;
import com.bergamascodev.entity.Categoria;
import com.bergamascodev.enums.MensagemErroEnum;
import com.bergamascodev.exception.BergamascoException;
import com.bergamascodev.repository.CategoriaRepository;
import com.bergamascodev.service.converter.CategoriaConverter;
import com.bergamascodev.service.validator.CategoriaValidator;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@ApplicationScoped
public class CategoriaService {

    @Inject
    CategoriaRepository categoriaRepository;

    @Inject
    CategoriaConverter categoriaConverter;

    @Inject
    CategoriaValidator categoriaValidator;

    public CategoriaDto criar(CategoriaDto categoriaDto) {
        categoriaValidator.validarCategoria(categoriaDto);
        try {
            Categoria categoria = categoriaConverter.toEntity(categoriaDto);
            categoriaRepository.saveAndFlush(categoria);
            return categoriaConverter.toDto(categoria);
        } catch (Exception e) {
            throw gerarCategoriaExcpetion(MensagemErroEnum.FALHA_SALVAR_CATEGORIA);
        }
    }

    public CategoriaDto alterar(Long id, CategoriaDto categoriaDto) {
        categoriaValidator.validarCategoria(id, categoriaDto);
        Categoria categoria = recuperarCategoria(id);
        try {
            atribuirValoresCategoria(categoria, categoriaConverter.toEntity(categoriaDto));
            categoriaRepository.saveAndFlush(categoria);
            return categoriaConverter.toDto(categoria);
        } catch (Exception e) {
            throw gerarCategoriaExcpetion(MensagemErroEnum.FALHA_SALVAR_CATEGORIA);
        }
    }

    public CategoriaDto buscarPorId(Long id) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        if (categoriaOptional.isEmpty()){
            throw gerarCategoriaExcpetion(MensagemErroEnum.CATEGORIA_NAO_ENCONTRADA, ResponseEnum.REQUISICAO_INVALIDA);
        }
        return  categoriaConverter.toDtoFromOptionalEntity(categoriaOptional);
    }

    private Categoria recuperarCategoria(Long id) {
        Categoria categoria = categoriaRepository.getById(id);
        if (categoria == null) {
            throw gerarCategoriaExcpetion(MensagemErroEnum.CATEGORIA_NAO_ENCONTRADA, ResponseEnum.REQUISICAO_INVALIDA);
        }
        return categoria;
    }

    private Categoria atribuirValoresCategoria(Categoria categoriaOriginal, Categoria categoriaAlterada){
        categoriaOriginal.setDescricao(categoriaAlterada.getDescricao());
        return categoriaOriginal;
    }

    private BergamascoException gerarCategoriaExcpetion(MensagemErroEnum mensagemErroEnum) {
        return new BergamascoException(mensagemErroEnum.getCodigo(), mensagemErroEnum.getMensagem());
    }

    private BergamascoException gerarCategoriaExcpetion(MensagemErroEnum mensagemErroEnum, ResponseEnum responseStatus) {
        return new BergamascoException(mensagemErroEnum.getCodigo(), mensagemErroEnum.getMensagem(), responseStatus);
    }
}
