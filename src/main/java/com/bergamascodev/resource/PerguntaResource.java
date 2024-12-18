package com.bergamascodev.resource;

import com.bergamascodev.dto.PerguntaDto;
import com.bergamascodev.service.facade.PerguntaFacade;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/cadastro/pergunta")
public class PerguntaResource {

    @Inject
    PerguntaFacade perguntaFacade;

    @GET
    @Path("/{perguntaId}")
    public Response buscarPerguntaPorId(@PathParam("perguntaId") Long id) {
        return Response.ok(perguntaFacade.buscarPorId(id)).build();
    }
    
    @POST
    public Response novaPergunta(@Valid PerguntaDto perguntaDto){
        return Response.ok(perguntaFacade.criar(perguntaDto)).build();
    }
    
    @PUT
    @Path("/{perguntaId}")
    public Response alterarPergunta(@PathParam("perguntaId") Long id, @Valid PerguntaDto perguntaDto) {
        return Response.ok(perguntaFacade.alterar(id, perguntaDto)).build();
    }
}
