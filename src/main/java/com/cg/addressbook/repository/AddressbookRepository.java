package com.cg.addressbook.repository;

import com.cg.addressbook.domain.ContactDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressbookRepository extends JpaRepository<ContactDetails,Long> {
}
