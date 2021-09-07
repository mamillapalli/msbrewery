package com.example.msbrewery.service;

import com.example.msbrewery.web.model.BeerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;


public interface BeerService {

    public BeerDTO getBeerById(UUID uuid);

    public BeerDTO saveBeer(BeerDTO beerDTO);

    void updateBeer(UUID uuid, BeerDTO beerDTO);

    void deleteById(UUID uuid);
}
