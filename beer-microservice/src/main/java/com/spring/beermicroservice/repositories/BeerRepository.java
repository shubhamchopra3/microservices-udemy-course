package com.spring.beermicroservice.repositories;

import com.spring.beermicroservice.domain.Beer;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.UUID;

//https://www.baeldung.com/spring-data-repositories

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
