package com.addressbookapplication.repository;

import com.addressbookapplication.model.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {
    //--------------------------------- Get Contact By City ---------------------------------
    @Query(value = "select * from address_book where id=id and city = :city", nativeQuery = true)
    List<AddressBook> findByCity(@Param("city") String city);

    //--------------------------------- Get Contact By State ---------------------------------
    @Query(value = "select * from address_book where id=id and state = :state", nativeQuery = true)
    List<AddressBook> findByState(@Param("state") String state);

    //--------------------------------- Sort Contact By City ---------------------------------
    @Query(value = "select * from address_book order by city asc ", nativeQuery = true)
    List<AddressBook> findAllByOrderByCity();

    //--------------------------------- Sort Contact By State ---------------------------------
    @Query(value = "select * from address_book order by state asc", nativeQuery = true)
    List<AddressBook> findAllByOrderByState();

}