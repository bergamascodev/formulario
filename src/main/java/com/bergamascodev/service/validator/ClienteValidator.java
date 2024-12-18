package com.bergamascodev.service.validator;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteValidator {

    /*@Inject
    ClienteRepository clienteRepository;

    @Inject
    ClienteConverter converter;

    public void validarCliente(ClienteDto clienteDto) {
        validarCliente(null, clienteDto);
    }

    public void validarCliente(Long id, ClienteDto clienteDto) {
        validarId(clienteDto);
//        validarCpf(clienteDto);
    }

    public void validarId(ClienteDto clienteDto) {
        if(clienteDto.getId() != null) {
            throw gerarClienteException(MensagensErroEnum.REQUISICAO_INVALIDA, ResponseEnum.REQUISICAO_INVALIDA);
        }
    }

 //   public void validarCpf(ClienteDto clienteDto) {
 //       if(clienteDto.getCpf() == null){
 //           throw gerarClienteException(MensagensErroEnum.REQUISICAO_INVALIDA, ResponseEnum.REQUISICAO_INVALIDA);
 //       }
 //   }

    private BergamascoException gerarClienteException(MensagensErroEnum mensagensErroEnum, ResponseEnum responseStatus){
        return new BergamascoException(mensagensErroEnum.getCodigo(), mensagensErroEnum.getMensagem(), responseStatus);
    }*/

}
