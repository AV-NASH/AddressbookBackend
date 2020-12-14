package com.cg.addressbook.service;

import com.cg.addressbook.domain.ContactDetails;
import com.cg.addressbook.dto.ContactDetailsDto;
import com.cg.addressbook.exceptions.DetailsNotProvidedExceptions;
import com.cg.addressbook.exceptions.UserNotFound;
import com.cg.addressbook.repository.AddressbookRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AddressbookService {
    @Autowired
    private AddressbookRepository addressbookRepository;


    public ContactDetailsDto CreateUser(ContactDetailsDto contactDetailsDto){
        if(Objects.nonNull(contactDetailsDto.getName()) && Objects.nonNull(contactDetailsDto.getAddress())&&
                Objects.nonNull(contactDetailsDto.getCity())&&Objects.nonNull(contactDetailsDto.getState())&&
                Objects.nonNull(contactDetailsDto.getZip())&&Objects.nonNull(contactDetailsDto.getPhone())) {
            ContactDetails contactDetails = new ContactDetails(contactDetailsDto.getName(),contactDetailsDto.getAddress()
                    ,contactDetailsDto.getCity(),contactDetailsDto.getState(),contactDetailsDto.getZip(),contactDetailsDto.getPhone());
            return new ContactDetailsDto(addressbookRepository.save(contactDetails)); }

        throw new DetailsNotProvidedExceptions("Invalid Data");
    }

    public ContactDetailsDto UpdateUser(ContactDetailsDto employeePayrollDto){

        return addressbookRepository.findById(employeePayrollDto.getId()).map(contactDetails -> {
            if(Objects.nonNull(employeePayrollDto.getName())){
                contactDetails.setName(employeePayrollDto.getName());
            }
            if(Objects.nonNull(contactDetails.getAddress())){
                contactDetails.setAddress(contactDetails.getAddress());
            }
            if(Objects.nonNull(contactDetails.getCity())){
                contactDetails.setCity(contactDetails.getCity());
            }
            if(Objects.nonNull(contactDetails.getState())){
                contactDetails.setState(contactDetails.getState());
            }
            if(Objects.nonNull(contactDetails.getZip())){
                contactDetails.setZip(contactDetails.getZip());
            }
            if(Objects.nonNull(contactDetails.getPhone())){
                contactDetails.setPhone(contactDetails.getPhone());
            }
            return new ContactDetailsDto(addressbookRepository.save(contactDetails));
        }).orElseThrow(()-> new UserNotFound("UserNotFound"));
    }

    public ContactDetailsDto deleteUser(Long id){
        return addressbookRepository.findById(id).map(contactDetails -> {
            addressbookRepository.deleteById(contactDetails.getId());
            return new ContactDetailsDto(contactDetails);
        }).orElseThrow(()-> new UserNotFound("UserNotFound"));
    }


    public List<ContactDetailsDto> getAllUser(){
        return addressbookRepository.findAll()
                .stream()
                .map(contactDetails -> new ContactDetailsDto(contactDetails))
                .collect(Collectors.toList());
    }
}
