package com.bergamascodev.resource;

import com.bergamascodev.dto.ChangeStatusDto;
import com.bergamascodev.dto.UsuarioDto;
import com.bergamascodev.service.facade.UsuarioFacade;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/cadastro/usuario")
public class UsuarioResource {

    @Inject
    UsuarioFacade usuarioFacade;

    @GET
    @Path("/{usuarioId}")
    public Response buscarUsuarioPorId(@PathParam("usuarioId") Long id) {
        return Response.ok(usuarioFacade.buscarPorId(id)).build();
    }

    @POST
    public Response novoUsuario(@Valid UsuarioDto usuarioDto) {
        return Response.ok(usuarioFacade.criar(usuarioDto)).build();
    }

    @PUT
    @Path("/{usuarioId}")
    public Response alterarUsuario(@PathParam("usuarioId") Long id, @Valid UsuarioDto usuarioDto) {
        return Response.ok(usuarioFacade.alterar(id, usuarioDto)).build();
    }

    @PUT
    @Path("/{usuarioId}/change-status")
    public Response alterarStatus(@PathParam("usuarioId") Long id, @Valid ChangeStatusDto changeStatusDto) {
        return Response.ok(usuarioFacade.alterarStatus(id, changeStatusDto)).build();
    }
}
