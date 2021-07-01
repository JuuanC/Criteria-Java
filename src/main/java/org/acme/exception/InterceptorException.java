package org.acme.exception;

import org.acme.dto.ResponseDTO;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author Juan Carlos Dominguez
 * @version 3.0
 * @since 03/11/2020
 * <h1>Clase para interceptar las excepciones de la clase CustomException</h1>
 */
@Provider
public class InterceptorException implements ExceptionMapper<CustomException> {

    @Override
    public Response toResponse(CustomException exception) {

        ResponseDTO responseDTO = new ResponseDTO(
                false, 400, exception.getMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(responseDTO).build();
    }
}
