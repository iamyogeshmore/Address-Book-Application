package com.addressbookapplication.service;

import com.addressbookapplication.dto.AddressBookDTO;
import com.addressbookapplication.exception.AddressBookException;
import com.addressbookapplication.model.AddressBook;
import com.addressbookapplication.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AddressBookService implements iAddressBookService {
    @Autowired
    private AddressBookRepository repository;

    public void isEmpty(List<AddressBook> addressBookList) {
        if (addressBookList.isEmpty())
            throw new AddressBookException("Address Book is empty!");
    }

    //--------------------------------- Add New Contact ---------------------------------
    @Override
    public AddressBook addAddressBook(AddressBookDTO addressBookDTO) {
        AddressBook addressBook = new AddressBook(addressBookDTO);
        log.debug("Address Book data: " + addressBook.toString());
        return repository.save(addressBook);
    }

    //--------------------------------- Get Contact By Id ---------------------------------
    @Override
    public AddressBook getAddressBookById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new AddressBookException("Address Book with id " + id + " not found!"));
    }

    //--------------------------------- Get All By Contact ---------------------------------
    @Override
    public List<AddressBook> getAddressBook() {
        List<AddressBook> addressBookList = repository.findAll();
        isEmpty(addressBookList);
        return addressBookList;
    }

    //--------------------------------- Update Contact ---------------------------------
    @Override
    public AddressBook editAddressBook(int id, AddressBookDTO addressBookDTO) {
        AddressBook addressBook = this.getAddressBookById(id);
        addressBook.updateData(addressBookDTO);
        log.debug("Address Book data: " + addressBook.toString());
        return repository.save(addressBook);
    }

    //--------------------------------- Delete Contact ---------------------------------
    @Override
    public void deleteAddressBook(int id) {
        AddressBook addressBook = this.getAddressBookById(id);
        repository.delete(addressBook);
    }

    //--------------------------------- Get Contact By City ---------------------------------
    @Override
    public List<AddressBook> getAddressBookByCity(String city) {
        List<AddressBook> addressBookList = repository.findByCity(city);
        if (addressBookList.isEmpty()) {
            throw new AddressBookException("Address Book with city " + city + " not found!");
        }
        return addressBookList;
    }

    //--------------------------------- Get Contact By State ---------------------------------
    @Override
    public List<AddressBook> getAddressBookByState(String state) {
        List<AddressBook> addressBookList = repository.findByState(state);
        if (addressBookList.isEmpty()) {
            throw new AddressBookException("Address Book with state " + state + " not found!");
        }
        return addressBookList;
    }

    //--------------------------------- Sort Contact By City ---------------------------------
    @Override
    public List<AddressBook> sortAddressBookByCity() {
        List<AddressBook> addressBookList = repository.findAllByOrderByCity();
        isEmpty(addressBookList);
        return addressBookList;
    }

    //--------------------------------- Sort Contact By State ---------------------------------
    @Override
    public List<AddressBook> sortAddressBookByState() {
        List<AddressBook> addressBookList = repository.findAllByOrderByState();
        isEmpty(addressBookList);
        return addressBookList;
    }
}