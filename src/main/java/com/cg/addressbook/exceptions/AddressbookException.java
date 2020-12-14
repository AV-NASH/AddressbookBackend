package com.cg.addressbook.exceptions;

public class AddressbookException extends RuntimeException{
    public ExceptionTypes exceptionTypes;

    public AddressbookException(ExceptionTypes exceptionTypes){
        this.exceptionTypes = exceptionTypes;
    }

    public enum ExceptionTypes{
        CONTACT_NOT_FOUND("Invalid Data.. Contact not found"),
        OTHER_EXCEPTION("other exceptions");
        public String errorMessage;

        ExceptionTypes(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }
}
