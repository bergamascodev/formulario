package com.bergamascodev.resource;

import com.bergamascodev.dto.CategoriaDto;
import com.bergamascodev.service.facade.CategoriaFacade;
import org.springframework.web.context.annotation.ApplicationScope;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@ApplicationScope
@Path("/cadastro/categoria")
public class CategoriaResource {

    @Inject
    CategoriaFacade categoriaFacade;

    @GET
    @Path("/{categoriaId}")
    public Response buscarCategoriaPorId(@PathParam("categoriaId") Long id) {
        return Response.ok(categoriaFacade.buscarPorId(id)).build();
    }

    @POST
    public Response novaCategoria(@Valid CategoriaDto categoriaDto) {
        return Response.ok(categoriaFacade.criar(categoriaDto)).build();
    }

    @PUT
    @Path("/{perguntaId}")
    public Response alterarCategoria(@PathParam("categoriaId") Long id, @Valid CategoriaDto categoriaDto) {
        return Response.ok(categoriaFacade.alterar(id, categoriaDto)).build();
    }
}
