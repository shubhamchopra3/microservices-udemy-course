package com.spring.msscbreweryclient.web.client;

import com.spring.msscbreweryclient.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void getBeerById() {

        BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());
        assertNotNull(beerDto);
    }


    @Test
    void saveBeer() {

        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        URI uri = breweryClient.saveBeer(beerDto);
        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void updateBeer() {

        BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
        breweryClient.updateBeer(UUID.randomUUID(),beerDto);

    }
}