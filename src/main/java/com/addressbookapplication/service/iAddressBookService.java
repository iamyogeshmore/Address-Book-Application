package com.addressbookapplication.service;

import com.addressbookapplication.dto.AddressBookDTO;
import com.addressbookapplication.model.AddressBook;

import java.util.List;

public interface iAddressBookService {
    List<AddressBook> getAddressBook();

    AddressBook addAddressBook(AddressBookDTO addressBookDTO);

    AddressBook getAddressBookById(int id);

    AddressBook editAddressBook(int id, AddressBookDTO addressBookDTO);

    void deleteAddressBook(int id);

    List<AddressBook> getAddressBookByCity(String city);

    List<AddressBook> getAddressBookByState(String state);

    List<AddressBook> sortAddressBookByCity();

    List<AddressBook> sortAddressBookByState();

}