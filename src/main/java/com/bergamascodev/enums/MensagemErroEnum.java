package com.bergamascodev.enums;

import lombok.Getter;

@Getter
public enum MensagemErroEnum {

    FALHA_SALVAR_PERGUNTA(1, "Falha ao salvar pergunta"),
    REQUISICAO_INVALIDA(2, "Dados inválidos"),
    FALHA_SALVAR_STATUS(3,"Falha ao salvar status"),
    STATUS_INVALIDO(4, "Status informado inválido"),
    FORMULARIO_INVALIDO(5,"Formulario invalido"),
    CATEGORIA_INVALIDA(6, "Categoria invalida"),
    PERGUNTA_NAO_ENCONTRADA(7, "Pergunta não encontrada"),
    PERGUNTA_INVALIDA(8, "Pergunta inválida"),
    CATEGORIA_NAO_ENCONTRADA(9, "Categoria não encontrada"),
    FALHA_SALVAR_CATEGORIA(10, "Falha ao salvar categoria"),
    TIME_NAO_ENCONTRADO(11, "Time não encontrado"),
    TIME_INVALIDO(12,"Time inválido"),
    USUARIO_NAO_ENCONTRADO(13, "Usuário não encontrado"),
    FALHA_SALVAR_USUARIO(14,"Falha ao salvar usuário"),
    REGISTRO_INVALIDO(15, "Registro invalido");


    private Integer codigo;
    private String mensagem;

    MensagemErroEnum(Integer codigo, String mensagem) {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getMensagem() {
        return mensagem;
    }
}
