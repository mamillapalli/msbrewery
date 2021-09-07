package com.example.msbrewery.service;

import com.example.msbrewery.web.model.BeerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {


    @Override
    public BeerDTO getBeerById(UUID uuid) {
        return BeerDTO.builder().id(UUID.randomUUID()).name("Vindhok").style("local").build();
    }

    @Override
    public BeerDTO saveBeer(BeerDTO beerDTO) {
        return BeerDTO.builder().id(beerDTO.getId()).name(beerDTO.getName()).build();
    }

    @Override
    public void updateBeer(UUID uuid, BeerDTO beerDTO) {
        // implementation to update Beer
    }

    @Override
    public void deleteById(UUID uuid) {
      log.debug("deleting beer with id" + uuid.toString());
    }
}
