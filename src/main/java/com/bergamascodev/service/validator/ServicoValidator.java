package com.bergamascodev.service.validator;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ServicoValidator {

 /*   @Inject
    ServicoRepository servicoRepository;

    @Inject
    ServicoConverter converter;

    public void validarServico(ServicoDto servicoDto) {
        validarServico(null, servicoDto);
    }

    public void validarServico(Long id, ServicoDto servicoDto) {
        validarId(servicoDto);
    }

    public void validarId(ServicoDto servicoDto) {
        if(servicoDto.getId() != null) {
            throw gerarClienteException(MensagensErroEnum.REQUISICAO_INVALIDA, ResponseEnum.REQUISICAO_INVALIDA);
        }
    }

    private BergamascoException gerarClienteException(MensagensErroEnum mensagensErroEnum, ResponseEnum responseStatus){
        return new BergamascoException(mensagensErroEnum.getCodigo(), mensagensErroEnum.getMensagem(), responseStatus);
    }*/

}
