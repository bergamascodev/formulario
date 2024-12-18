package com.bergamascodev.resource;

import com.bergamascodev.dto.TimeDto;
import com.bergamascodev.service.facade.TimeFacade;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/cadastro/time")
public class TimeResource {

    @Inject
    TimeFacade timeFacade;

    @GET
    @Path("/{timeId}")
    public Response buscarTimePorId(@PathParam("timeId") Long id) {
        return Response.ok(timeFacade.buscarPorId(id)).build();
    }

    @POST
    public Response novoTime(@Valid TimeDto timeDto) {
        return Response.ok(timeFacade.criar(timeDto)).build();
    }

    @PUT
    @Path("/{timeId}")
    public Response alterarTime(@PathParam("timeId") Long id, @Valid TimeDto timeDto) {
        return Response.ok(timeFacade.alterar(id, timeDto)).build();
    }
}
