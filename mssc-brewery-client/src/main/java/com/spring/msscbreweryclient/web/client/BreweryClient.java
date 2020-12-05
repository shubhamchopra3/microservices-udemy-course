package com.spring.msscbreweryclient.web.client;

import com.spring.msscbreweryclient.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery",ignoreUnknownFields = false)  // this acts as a prefix in application.properties
public class BreweryClient {

    private String apiHost;  // will be injected from value sfg.brewery.apiHost in application.properties
    public final String BEER_PATH_V1 = "/api/v1/beer/";  //coming from brewery service
    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public BeerDto getBeerById(UUID id) {

        return restTemplate.getForObject(apiHost+BEER_PATH_V1+id.toString(),BeerDto.class);
    }

    public URI saveBeer(BeerDto beerDto)
    {
        return restTemplate.postForLocation(apiHost+BEER_PATH_V1,beerDto);
    }



}
