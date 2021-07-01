package org.acme.resource;

import org.acme.dto.consulta.ConsultaDTO;
import org.acme.dto.ResponseDTO;
import org.acme.entity.Proveedor;
import org.acme.repository.ProveedorRepository;
import org.acme.util.Utilities;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Set;

@Path("proveedor")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProveedorResource {

    @Inject
    ProveedorRepository proveedorRepository;

    @Inject
    Validator validator;

    @POST
    public Response save(Proveedor proveedor) {
        /*Set<ConstraintViolation<Proveedor>> violations = validator.validate(proveedor);
        if (!violations.isEmpty()) {
            return Response.status(400).entity(new ResponseDTO(false, 400,
                    Utilities.getMensajeError(violations),
                    null)).build();
        }*/
        return Response.status(200).entity(new ResponseDTO(true, 200,
                "El proveedor se ha registrado con éxito", proveedorRepository.save(proveedor))).build();
    }

    @GET
    public Response filtro(ConsultaDTO consultaDTO) {
        return Response.status(200).entity(new ResponseDTO(false, 200,
                "La info se obtuvo", proveedorRepository.get(Proveedor.class, consultaDTO))).build();
    }

    @PUT
    public Response update(Proveedor proveedor){
        return Response.status(200).entity(new ResponseDTO(true, 200,
                "El proveedor se ha registrado con éxito", proveedorRepository.update(proveedor))).build();
    }
}
