package finalexam.gdm.service;

import finalexam.gdm.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCutomers();
    Customer addNewCustomer(Customer customer);


}

