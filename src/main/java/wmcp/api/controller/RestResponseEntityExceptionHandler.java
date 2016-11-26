package wmcp.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.ws.rs.ClientErrorException;
import java.sql.SQLException;

/**
 * Handles errors and builds responses for ClientErrorExceptions.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-25
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(RestResponseEntityExceptionHandler.class);

    @ExceptionHandler(ClientErrorException.class)
    protected ResponseEntity<Object> handleClientErrorException(ClientErrorException ex, WebRequest request) {
        String description = "ClientErrorException occurred:: " + request.getDescription(false);
        logger.info(description);
        return handleExceptionInternal(ex, request, new HttpHeaders(),
                HttpStatus.valueOf(ex.getResponse().getStatus()), request);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<Object> handleSQLException(SQLException ex, WebRequest request) {
        String description = "SQLException occurred:: " + request.getDescription(false);
        logger.info(description);
        return handleExceptionInternal(ex, description, new HttpHeaders(),
                HttpStatus.BAD_REQUEST, request);
    }
}