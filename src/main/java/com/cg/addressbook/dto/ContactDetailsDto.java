package com.cg.addressbook.dto;

import com.cg.addressbook.domain.ContactDetails;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ContactDetailsDto {
    private Long id;
    @NotNull(message = "Please enter valid name")
    @NotEmpty(message = "Please enter valid name")
    @Pattern(regexp = "^[A-Za-z]{3,}$", message = "Please enter valid name")
    private String name;
    @Pattern(regexp = "([a-zA-Z0-9]){4,}",message = "Enter valid address")
    private String address;
    @Pattern(regexp = "([a-zA-Z0-9]){4,}",message = "Enter valid city")
    private String city;
    @Pattern(regexp = "([a-zA-Z0-9]){4,}",message = "Enter valid state")
    private String state;
    @Pattern(regexp = "(^[0-9]{3})([ ]{1})?([0-9]{3})",message = "Enter valid zip")
    private String zip;
    @Pattern(regexp = "^[0-9]{2}+[ ]{1}+[0-9]{10}", message = "please enter valid phone number")
    private String phone;

    public ContactDetailsDto() {
    }

    public ContactDetailsDto(ContactDetails contactDetails) {
        this.id = contactDetails.getId();
        this.name = contactDetails.getName();
        this.address = contactDetails.getAddress();
        this.city = contactDetails.getCity();
        this.state = contactDetails.getState();
        this.zip = contactDetails.getZip();
        this.phone = contactDetails.getPhone();
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
