package com.bergamascodev.service;

import com.bergamascodev.common.dto.enums.ResponseEnum;
import com.bergamascodev.dto.PerguntaDto;
import com.bergamascodev.entity.Categoria;
import com.bergamascodev.entity.Pergunta;
import com.bergamascodev.enums.MensagensErroEnum;
import com.bergamascodev.exception.BergamascoException;
import com.bergamascodev.repository.CategoriaRepository;
import com.bergamascodev.repository.PerguntaRepository;
import com.bergamascodev.service.converter.PerguntaConverter;
import com.bergamascodev.service.validator.PerguntaValidator;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@ApplicationScoped
public class PerguntaService {

    @Inject
    PerguntaRepository perguntaRepository;

    @Inject
    PerguntaConverter perguntaConverter;

    @Inject
    CategoriaRepository categoriaRepository;

    @Inject
    PerguntaValidator perguntaValidator;

    public PerguntaDto criar(PerguntaDto perguntaDto) {
        perguntaValidator.validarPergunta(perguntaDto);
        try {
            Pergunta pergunta = perguntaConverter.toEntity(perguntaDto);
            Categoria categoria = categoriaRepository.getById(pergunta.getCategoria().getId());
            pergunta.setCategoria(categoria);
            perguntaRepository.saveAndFlush(pergunta);
            return perguntaConverter.toDto(pergunta);
        } catch (Exception e) {
            throw gerarPerguntaException(MensagensErroEnum.FALHA_SALVAR_PERGUNTA);
        }
    }

    public PerguntaDto alterar(Long id, PerguntaDto perguntaDto) {
        perguntaValidator.validarPergunta(id, perguntaDto);
        Pergunta pergunta = recuperarPergunta(id);
        try {
            atribuirValoresPergunta(pergunta, perguntaConverter.toEntity(perguntaDto));
            perguntaRepository.saveAndFlush(pergunta);
            return perguntaConverter.toDto(pergunta);
        } catch (Exception e) {
            throw gerarPerguntaException(MensagensErroEnum.FALHA_SALVAR_PERGUNTA);
        }
    }

    public PerguntaDto buscarPorId(Long id) {
        Optional<Pergunta> perguntaOptional = perguntaRepository.findById(id);
        if (perguntaOptional.isEmpty()){
            throw gerarPerguntaExcpetion(MensagensErroEnum.PERGUNTA_NAO_ENCONTRADA, ResponseEnum.REQUISICAO_INVALIDA);
        }
        return  perguntaConverter.toDtoFromOptionalEntity(perguntaOptional);
    }

    private Pergunta recuperarPergunta(Long id) {
        Pergunta pergunta = perguntaRepository.getById(id);
        if (pergunta == null) {
            throw gerarPerguntaExcpetion(MensagensErroEnum.PERGUNTA_NAO_ENCONTRADA, ResponseEnum.REQUISICAO_INVALIDA);
        }
        return pergunta;
    }

    private Pergunta atribuirValoresPergunta(Pergunta perguntaOriginal, Pergunta perguntaAlterada){
        Categoria categoria = categoriaRepository.getById(perguntaAlterada.getCategoria().getId());
        perguntaOriginal.setCategoria(categoria);
        perguntaOriginal.setDescricao(perguntaAlterada.getDescricao());
        perguntaOriginal.setPontuacao(perguntaAlterada.getPontuacao());
        return perguntaOriginal;
    }

    private BergamascoException gerarPerguntaException(MensagensErroEnum mensagensErroEnum) {
        return new BergamascoException(mensagensErroEnum.getCodigo(), mensagensErroEnum.getMensagem());
    }

    private BergamascoException gerarPerguntaExcpetion(MensagensErroEnum mensagensErroEnum, ResponseEnum responseStatus) {
        return new BergamascoException(mensagensErroEnum.getCodigo(), mensagensErroEnum.getMensagem(), responseStatus);
    }
}
