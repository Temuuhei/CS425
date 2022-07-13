package finalexam.gdm.service.impl;

import finalexam.gdm.model.Customer;
import finalexam.gdm.service.CustomerService;
import finalexam.gdm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer addNewCustomer(Customer customer) {
        var newCustomer = customerRepository.save(customer);
        return newCustomer;
    }

    @Override
    public List<Customer> getAllCutomers() {
        var customers = customerRepository.getCustomersByAscName();
        return customers;
    }
}
