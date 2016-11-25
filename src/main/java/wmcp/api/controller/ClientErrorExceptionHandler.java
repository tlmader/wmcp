package wmcp.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.ClientErrorException;

/**
 * Handles errors and builds responses for ClientErrorExceptions.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-25
 */
@ControllerAdvice
public class ClientErrorExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ClientErrorExceptionHandler.class);

    @ExceptionHandler(ClientErrorException.class)
    public String handleSQLException(HttpServletRequest request, Exception ex) {
        String message = "ClientErrorException Occured:: URL=" + request.getRequestURL();
        logger.info(message);
        return message;
    }
}