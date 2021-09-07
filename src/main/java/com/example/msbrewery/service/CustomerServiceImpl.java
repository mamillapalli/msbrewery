package com.example.msbrewery.service;

import com.example.msbrewery.web.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {


    @Override
    public CustomerDTO findByCustomerId(UUID uuid) {
        return CustomerDTO.builder().uuid(UUID.randomUUID()).name("ravikanth").build();
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        return CustomerDTO.builder().uuid(customerDTO.getUuid()).name(customerDTO.getName()).build();
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        return CustomerDTO.builder().uuid(customerDTO.getUuid()).name(customerDTO.getName()).build();
    }

    @Override
    public void deleteById(UUID uuid) {
        log.debug("Implement the delete logic here");
    }
}
