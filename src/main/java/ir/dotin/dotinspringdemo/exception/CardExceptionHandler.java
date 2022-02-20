package ir.dotin.dotinspringdemo.exception;


import ir.dotin.dotinspringdemo.controller.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.ZonedDateTime;

@ControllerAdvice
public class CardExceptionHandler {


    @ExceptionHandler({CardNotFoundException.class})
    public ResponseEntity<ErrorResponse> handleCardNotFound(CardNotFoundException exception, HttpServletRequest
            httpServletRequest){



        return new ResponseEntity( ErrorResponse.ErrorResponseBuilder.anErrorResponse().withMessage(exception.getMessage())
                .withStatusCode(HttpStatus.NOT_FOUND.value())
                .withTime(ZonedDateTime.now()).build() ,HttpStatus.INTERNAL_SERVER_ERROR);

    }


    @ExceptionHandler
    public ResponseEntity<ErrorResponse> generalHandler(Exception exception, HttpServletRequest
                                                        httpServletRequest){


        return new ResponseEntity( ErrorResponse.ErrorResponseBuilder.anErrorResponse().withMessage(exception.getMessage())
                .withStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .withTime(ZonedDateTime.now()).build() ,HttpStatus.BAD_REQUEST);

    }




}
