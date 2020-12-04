package com.spring.msscbrewery.services;

import com.spring.msscbrewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {

    public BeerDto getBearById(UUID beerId);

    BeerDto saveNewBeer(BeerDto beerDto);

    void updateBeer(UUID beerId, BeerDto beerDto);

    void deleteById(UUID beerId);
}
