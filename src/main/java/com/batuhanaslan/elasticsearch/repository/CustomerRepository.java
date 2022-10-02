package com.batuhanaslan.elasticsearch.repository;

import com.batuhanaslan.elasticsearch.entity.Customer;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends ElasticsearchRepository<Customer,String> {

    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    List<Customer> getByCustomerQuery(String search);

    List<Customer>  findByNameLikeOrSurNameLike(String name, String surName);
}
