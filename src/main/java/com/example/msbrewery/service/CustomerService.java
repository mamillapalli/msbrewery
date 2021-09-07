package com.example.msbrewery.service;

import com.example.msbrewery.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {

    CustomerDTO findByCustomerId(UUID uuid);

    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteById(UUID uuid);
}
