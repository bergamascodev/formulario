package com.bergamascodev.resource;

import com.bergamascodev.dto.RegistroFormularioDto;
import com.bergamascodev.service.facade.RegistroFormularioFacade;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/cadastro/pergunta")
public class RegistroFormularioResource {

    @Inject
    RegistroFormularioFacade registroFormularioFacade;

    @POST
    public Response adicionarPergunta(@Valid RegistroFormularioDto registroFormularioDto) {
        return Response.ok(registroFormularioFacade.criar(registroFormularioDto)).build();
    }
}
