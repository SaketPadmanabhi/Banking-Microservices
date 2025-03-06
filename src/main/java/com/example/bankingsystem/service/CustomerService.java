package com.example.bankingsystem.service;

import com.example.bankingsystem.exception.CustomerNotFoundException;
import com.example.bankingsystem.repository.CustomerRepository;
import com.example.bankingsystem.model.Customer;
import com.example.bankingsystem.dto.CustomerDTO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        if (customerRepository.findByEmail(customerDTO.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already exists");
        }

        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());

        Customer savedCustomer = customerRepository.save(customer);
        return new CustomerDTO(savedCustomer.getId(), savedCustomer.getName(), savedCustomer.getEmail(), savedCustomer.getPhone());

    }

    public List<CustomerDTO> getAllCustomers(){
        return customerRepository.findAll().stream()
                .map(customer -> new CustomerDTO(customer.getId(), customer.getName(), customer.getEmail(), customer.getPhone()))
                .collect(Collectors.toList());
    }

    public CustomerDTO getCustomerById(Long id){
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Customer not found with ID: " + id));

        return new CustomerDTO(customer.getId(), customer.getName(), customer.getEmail(), customer.getPhone());
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

}
