package wmcp.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.ClientErrorException;
import java.sql.SQLException;

/**
 * Handles errors and builds responses for ClientErrorExceptions.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-25
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ClientErrorException.class)
    public String handleClientErrorException(HttpServletRequest request, Exception ex) {
        String message = "ClientErrorException occurred:: URL=" + request.getRequestURL();
        logger.info(message);
        return message;
    }

    @ExceptionHandler(SQLException.class)
    public String handleSQLException(HttpServletRequest request, Exception ex) {
        String message = "SQLException occurred:: URL=" + request.getRequestURL();
        logger.info(message);
        return message;
    }
}