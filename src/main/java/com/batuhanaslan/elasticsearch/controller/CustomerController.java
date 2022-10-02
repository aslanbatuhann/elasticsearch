package com.batuhanaslan.elasticsearch.controller;

import com.batuhanaslan.elasticsearch.entity.Customer;
import com.batuhanaslan.elasticsearch.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepository customerRepository;

    @PostConstruct
    public void init(){
        Customer customer = new Customer();
        customer.setName("batuhan");
        customer.setSurName("aslan");
        customer.setAddress("test");
        customer.setBirthday(Calendar.getInstance().getTime());
        customer.setId("C32423");
        customerRepository.save(customer);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<Customer>> getCustomer(@PathVariable String search){
        List<Customer> customerList = customerRepository.findByNameLikeOrSurNameLike(search, search);
        return ResponseEntity.ok(customerList);
    }


}
