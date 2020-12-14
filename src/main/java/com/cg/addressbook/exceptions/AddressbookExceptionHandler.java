package com.cg.addressbook.exceptions;

import com.cg.addressbook.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class AddressbookExceptionHandler {
    @ExceptionHandler(AddressbookException.class)
    public ResponseEntity<ResponseDto> handleCMSException(AddressbookException addressbookException){
        //log.error(codinClubUserException.getMessage());
        return new ResponseEntity<ResponseDto>(new ResponseDto(null,null, addressbookException.exceptionTypes.errorMessage),
                HttpStatus.BAD_REQUEST);
    }
}
