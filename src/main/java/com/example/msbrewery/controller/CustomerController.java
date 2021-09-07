package com.example.msbrewery.controller;

import com.example.msbrewery.service.CustomerService;
import com.example.msbrewery.web.model.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable(name="customerId") UUID uuid)
    {
        return new ResponseEntity<CustomerDTO>(customerService.findByCustomerId(uuid), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> saveCustomer(@RequestBody CustomerDTO customerDTO)
    {
        CustomerDTO savedCustomer = customerService.saveCustomer(customerDTO);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location","/api/v1/customers/"+ savedCustomer.getUuid());
        return new ResponseEntity(savedCustomer,httpHeaders,HttpStatus.OK);
    }

    @PutMapping(path="/{customerId}")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO)
    {
        CustomerDTO modifiedCustomer = customerService.updateCustomer(customerDTO);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("location","/api/v1/customers/"+ modifiedCustomer.getUuid());
        return new ResponseEntity(modifiedCustomer,httpHeaders,HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable(name="customerId") UUID uuid)
    {
        customerService.deleteById(uuid);
    }



}
