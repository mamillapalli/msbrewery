package com.example.msbrewery.controller;

import com.example.msbrewery.service.BeerService;
import com.example.msbrewery.web.model.BeerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beers")
public class BeerController {

    @Autowired
    BeerService beerService;
    @GetMapping(path = "/{beerId}")
    public ResponseEntity<BeerDTO> getBeerById( @PathVariable(name = "beerId") UUID uuid)
    {
        return new ResponseEntity<BeerDTO>(beerService.getBeerById(uuid),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity saveBeer(@RequestBody BeerDTO beerDTO)
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        BeerDTO savedBeerDTO = beerService.saveBeer(beerDTO);
        httpHeaders.add("locaiton","/api/v1/beers/"+savedBeerDTO.getId().toString());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{beerId}")
    public ResponseEntity updateBeer(@PathVariable(name="beerId") UUID uuid, @RequestBody BeerDTO beerDTO)
    {
        beerService.updateBeer(uuid,beerDTO);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable (name="beerId") UUID uuid)
    {
        beerService.deleteById(uuid);
    }
}
