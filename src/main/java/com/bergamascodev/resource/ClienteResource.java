package com.bergamascodev.resource;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;

@ApplicationScoped
@Path("/cadastro/cliente")
public class ClienteResource {

/*    @Inject
    ClienteFacade clienteFacade;

    @GET
    @Path("/{clienteId}")
    public Response buscarClientePorId(@PathParam("clienteId") Long id) {
        return Response.ok(clienteFacade.buscarPorId(id)).build();
    }

    @POST
    public Response novoCliente(@Valid ClienteDto clienteDto) {
        return Response.ok(clienteFacade.criar(clienteDto)).build();
    }

    @POST
    @Path("/{clienteId}")
    public Response alterarCliente(@PathParam("clienteId") Long id, @Valid ClienteDto clienteDto) {
        return Response.ok(clienteFacade.alterar(id, clienteDto)).build();
    }

    @POST
    @Path("/{clienteId}/change-status")
    public Response changeStatus(@PathParam("clienteId") Long id, @Valid ChangeStatusDto changeStatusDto) {
        return Response.ok(clienteFacade.atualizarStatus(id, changeStatusDto)).build();
    }
*/
}
