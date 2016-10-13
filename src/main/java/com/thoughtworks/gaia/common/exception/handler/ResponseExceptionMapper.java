package com.thoughtworks.gaia.common.exception.handler;

import com.thoughtworks.gaia.common.exception.BaseResponseException;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.log4j.Logger;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON_TYPE;

@Provider
public class ResponseExceptionMapper implements ExceptionMapper<BaseResponseException> {
    private static final Logger LOG = Logger.getLogger(ResponseExceptionMapper.class);

    @Override
    public Response toResponse(BaseResponseException exception) {
        String fullStackTrace = ExceptionUtils.getFullStackTrace(exception);
        LOG.warn("ResponseException with status: " + exception.getStatus());
        LOG.warn(fullStackTrace);

        return Response.status(exception.getStatus())
            .entity((new ErrorEntity(exception.getErrorCode(),
                    exception.getErrorMessages(), fullStackTrace)).toJson())
            .type(APPLICATION_JSON_TYPE)
            .build();
    }
}
