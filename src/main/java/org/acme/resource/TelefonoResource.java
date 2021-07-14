package org.acme.resource;

import org.acme.dto.ResponseDTO;
import org.acme.dto.consulta.ConsultaDTO;
import org.acme.entity.Telefono;
import org.acme.repository.TelefonoRepository;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("telefono")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TelefonoResource {

    @Inject
    TelefonoRepository telefonoRepository;

    @Transactional
    @POST
    public Telefono save(Telefono telefono) {
        return telefonoRepository.save(telefono);
    }

    @GET
    public Response filtro(ConsultaDTO consultaDTO) {
        return Response.status(200).entity(new ResponseDTO(false, 200,
                "La info se obtuvo", telefonoRepository.get(consultaDTO, false))).build();
    }
}
