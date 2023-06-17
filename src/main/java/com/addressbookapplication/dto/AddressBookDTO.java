package com.addressbookapplication.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor

public @ToString class AddressBookDTO {
    @NotNull(message = "Full Name cannot be null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Full Name Invalid")
    public String fullName;
    @NotNull(message = "Phone No cannot be null")
    @Pattern(regexp = "^[0-9]{2}\\s{0,1}[0-9]{10}$", message = "Phone No Is Invalid")
    public String phoneNo;

    @NotNull(message = "City cannot be null")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "City Is Invalid")
    public String city;

    @NotNull(message = "State cannot be null")
    @Pattern(regexp = "^[a-zA-Z\\s]{2,}$", message = "State Is Invalid")
    public String state;

    @NotNull(message = "ZipCode Cannot Be Empty")
    @Pattern(regexp = "^[0-9]{3}\\s{0,1}[0-9]{3}$", message = "Zip Code Is Invalid")
    public String zipCode;

    @NotNull(message = "Address Cannot Be Empty")
    @Pattern(regexp = "^((.){1,}(\\d){1,}(.){0,})$", message = "Address Is Invalid")
    public String address;
}