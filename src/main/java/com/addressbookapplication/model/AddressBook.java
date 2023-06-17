package com.addressbookapplication.model;

import com.addressbookapplication.dto.AddressBookDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class AddressBook {
    @Id
    @GeneratedValue
    private int id;
    private String fullName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNo;

    public AddressBook(AddressBookDTO addressBookDTO) {
        this.updateData(addressBookDTO);
    }

    public void updateData(AddressBookDTO addressBookDTO) {
        this.fullName = addressBookDTO.fullName;
        this.address = addressBookDTO.address;
        this.city = addressBookDTO.city;
        this.state = addressBookDTO.state;
        this.zipCode = addressBookDTO.zipCode;
        this.phoneNo = addressBookDTO.phoneNo;
    }
}