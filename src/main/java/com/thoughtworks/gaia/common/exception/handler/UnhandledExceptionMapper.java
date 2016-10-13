package com.thoughtworks.gaia.common.exception.handler;

import com.thoughtworks.gaia.common.exception.ErrorCode;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;

@Provider
public class UnhandledExceptionMapper implements ExceptionMapper<RuntimeException> {
    private static final Logger LOG = Logger.getLogger(UnhandledExceptionMapper.class);

    @Override
    public Response toResponse(RuntimeException exception) {
        if (exception instanceof WebApplicationException) {
            WebApplicationException webApplicationException = (WebApplicationException) exception;
            if (webApplicationException.getResponse() != null) {
                return webApplicationException.getResponse();
            }
        }

        String fullStackTrace = ExceptionUtils.getFullStackTrace(exception);
        LOG.warn(fullStackTrace);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
            .entity(new ErrorEntity(ErrorCode.UNKNOWN, fullStackTrace))
            .type(APPLICATION_JSON_TYPE)
            .build();
    }
}
