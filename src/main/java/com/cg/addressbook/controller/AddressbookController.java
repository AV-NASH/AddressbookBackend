package com.cg.addressbook.controller;

import com.cg.addressbook.domain.ContactDetails;
import com.cg.addressbook.dto.ContactDetailsDto;
import com.cg.addressbook.dto.ResponseDto;
import com.cg.addressbook.exceptions.AddressbookException;
import com.cg.addressbook.exceptions.UserNotFound;
import com.cg.addressbook.service.AddressbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")

public class AddressbookController {
    @Autowired
    AddressbookService addressbookservice;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createUser(@RequestBody @Valid ContactDetailsDto user){
        try{

            ContactDetailsDto contactDetailsDto = addressbookservice.CreateUser(user);

            return new ResponseEntity<ResponseDto> ( new ResponseDto("Contact created successfully","200",contactDetailsDto),HttpStatus.CREATED);
        } catch (UserNotFound e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateUser(@RequestBody @Valid ContactDetailsDto user){
        try{

            ContactDetailsDto contactDetailsDto = addressbookservice.UpdateUser(user);

            return new ResponseEntity<ResponseDto> ( new ResponseDto("Contact updated successfully","200",contactDetailsDto),HttpStatus.CREATED);
        } catch (UserNotFound e){
            throw new AddressbookException(AddressbookException.ExceptionTypes.CONTACT_NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto> deleteUser(@PathVariable("id")Long id){
        try{
            ContactDetailsDto contactDetailsDto = addressbookservice.deleteUser(id);

            return new ResponseEntity<ResponseDto> ( new ResponseDto(" Deleted Contact successfully","200",contactDetailsDto),HttpStatus.CREATED);
        } catch (UserNotFound e){
            throw new AddressbookException(AddressbookException.ExceptionTypes.CONTACT_NOT_FOUND);
        }
    }

    @GetMapping("/get")
    public ResponseEntity<List<ContactDetailsDto>> getAllUser(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(addressbookservice.getAllUser());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
