package blog.api.exeptions.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import blog.api.exeptions.ExeptionMessage;
import blog.api.exeptions.UnsuportedDataError;
@ControllerAdvice
@RestController
public class CustomEntityHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExeptionMessage> handlerAllExeption(Exception ex, WebRequest request) {
        ExeptionMessage response = new ExeptionMessage(
            new Date(),
            ex.getMessage(),
            request.getDescription(false)
        );

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UnsuportedDataError.class)
    public final ResponseEntity<ExeptionMessage> handlerBadRequestExeption(Exception ex, WebRequest request) {
        ExeptionMessage response = new ExeptionMessage(
            new Date(),
            ex.getMessage(),
            request.getDescription(false)
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
