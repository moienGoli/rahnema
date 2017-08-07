package com.rahnema.exception;

import org.apache.log4j.Logger;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Handles default (unexpected) exception
 * Created by moien.
 */
@Provider
public class DefaultExceptionHandler implements ExceptionMapper<Exception> {


    private static Logger logger = Logger.getLogger(DefaultExceptionHandler.class);

    @SuppressWarnings("ThrowableResultOfMethodCallIgnored")
    public Response toResponse(Exception e) {
        AppException appException = getAppException(e);
        if (appException != null) {
            logger.info("AppException : " + appException.getMessage());
            //instead of passing the raw message of exception it is better to use msg util and extract the appropriate message
            ExceptionResponse response = new ExceptionResponse(Response.Status.BAD_REQUEST, appException.getMessage(), appException.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(response).type(MediaType.APPLICATION_JSON).build();
        } else {
            logger.error("exception unhandled: ", e);
            return Response.serverError().build();
        }
    }

    private AppException getAppException(Exception e) {

        if (e == null)
            return null;

        if (e instanceof AppException)
            return (AppException) e;

        Throwable cause = e.getCause();
        while (cause != null && !(cause instanceof AppException)) {
            cause = cause.getCause();
        }
        return (AppException) cause;
    }

    public class ExceptionResponse {

        public ExceptionResponse(Response.Status status, String message, String localMessage) {
            this.status = status;
            this.message = message;
            this.localMessage = localMessage;
        }

        public Response.Status status;
        public String message;
        public String localMessage;
    }

}