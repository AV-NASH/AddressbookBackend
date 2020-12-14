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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")

public class AddressbookController {
    @Autowired
    AddressbookService addressbookservice;

    @PostMapping("/create")
    public ResponseEntity<ContactDetailsDto> createUser(@RequestBody ContactDetailsDto user){
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(addressbookservice.CreateUser(user));
        } catch (UserNotFound e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ContactDetailsDto> updateUser(@RequestBody ContactDetailsDto user){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(addressbookservice.UpdateUser(user));
        } catch (UserNotFound e){
            throw new AddressbookException(AddressbookException.ExceptionTypes.CONTACT_NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ContactDetailsDto> deleteUser(@PathVariable("id")Long id){
        try{
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(addressbookservice.deleteUser(id));
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
