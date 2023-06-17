package com.addressbookapplication.Controller;

import com.addressbookapplication.dto.AddressBookDTO;
import com.addressbookapplication.dto.ResponseDTO;
import com.addressbookapplication.model.AddressBook;
import com.addressbookapplication.service.iAddressBookService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/addressBook")
public class AddressBookController {
    @Autowired
    iAddressBookService addressBookService;

    //--------------------------------- Add New Contact ---------------------------------
    @PostMapping("/add_UserData")
    public ResponseEntity<ResponseDTO> createAddressBook(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBook addressBook = addressBookService.addAddressBook(addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("User created in address book successfully.", addressBook);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //--------------------------------- Get Contact By Id ---------------------------------
    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseDTO> getAddressBookById(@PathVariable int id) {
        AddressBook addressBook = addressBookService.getAddressBookById(id);
        ResponseDTO responseDTO = new ResponseDTO("User data get by Id.", addressBook);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //--------------------------------- Get All Contact ---------------------------------
    @GetMapping("/Show_All_AddressBook_Data")
    public ResponseEntity<ResponseDTO> getAddressBookData() {
        List<AddressBook> addressBookList = addressBookService.getAddressBook();
        ResponseDTO responseDTO = new ResponseDTO("Show all address book data.", addressBookList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }


    //--------------------------------- Update Contact ---------------------------------
    @PutMapping("/update_AddressBook/{id}")
    public ResponseEntity<ResponseDTO> editAddressBook(@PathVariable int id, @Valid @RequestBody AddressBookDTO addressBookDTO) {
        AddressBook addressBook = addressBookService.editAddressBook(id, addressBookDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updated address book data successfully.", addressBook);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //--------------------------------- Delete Contact ---------------------------------
    @DeleteMapping("/delete_AddressBook/{id}")
    public ResponseEntity<ResponseDTO> deleteAddressBook(@PathVariable int id) {
        addressBookService.deleteAddressBook(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully", "Deleted for id: " + id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    //--------------------------------- Get Contact By City ---------------------------------
    @GetMapping("/getByCity/{city}")
    public ResponseEntity<ResponseDTO> getAddressBookByCity(@PathVariable String city) {
        List<AddressBook> addressBook = addressBookService.getAddressBookByCity(city);
        ResponseDTO responseDTO = new ResponseDTO("Get data by city name successful.", addressBook);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //--------------------------------- Get Contact By State ---------------------------------
    @GetMapping("/getByState/{state}")
    public ResponseEntity<ResponseDTO> getAddressBookByState(@PathVariable String state) {
        List<AddressBook> addressBook = addressBookService.getAddressBookByState(state);
        ResponseDTO responseDTO = new ResponseDTO("Get data by state name successful.", addressBook);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //--------------------------------- Sort Contact By City ---------------------------------
    @GetMapping("/sortByCity")
    public ResponseEntity<ResponseDTO> sortAddressBookByCity() {
        List<AddressBook> addressBook = addressBookService.sortAddressBookByCity();
        ResponseDTO responseDTO = new ResponseDTO("Get sorted data by city name successful.", addressBook);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //--------------------------------- Sort Contact By State ---------------------------------
    @GetMapping("/sortByState")
    public ResponseEntity<ResponseDTO> sortAddressBookByState() {
        List<AddressBook> addressBook = addressBookService.sortAddressBookByState();
        ResponseDTO responseDTO = new ResponseDTO("Get sorted data by state name successful.", addressBook);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}


