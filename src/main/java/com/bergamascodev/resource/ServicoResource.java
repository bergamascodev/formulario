package com.bergamascodev.resource;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;

@ApplicationScoped
@Path("/cadastro/servico")
public class ServicoResource {

 /*   @Inject
    ServicoFacade servicoFacade;

    @GET
    @Path("/{servicoId}")
    public Response buscarServicoPorId(@PathParam("servicoId") Long id) {
        return Response.ok(servicoFacade.buscarPorId(id)).build();
    }

    @POST
    public Response novoServico(@Valid ServicoDto servicoDto) {
        return Response.ok(servicoFacade.criar(servicoDto)).build();
    }

    @POST
    @Path("/{servicoId}")
    public Response alterarServico(@PathParam("servicoId") Long id, @Valid ServicoDto servicoDto) {
        return Response.ok(servicoFacade.alterar(id, servicoDto)).build();
    }
*/
}
