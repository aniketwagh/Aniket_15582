package com.ecom.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecom.dao.ICustomerRepository;
import com.ecom.dto.CustomerData;
import com.ecom.model.Customer;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;

	private Customer getCustomerEntity(CustomerData customerData) {
		Customer customer = new Customer();
		customer.setCustId(customerData.getCustId());
		customer.setCustName(customerData.getCustName());
		customer.setCustEmail(customerData.getCustEmail());
		customer.setCustAddress(customerData.getCustAddress());
		
		return customer;
	}

	private CustomerData getCustomerData(Customer customer) {
		CustomerData customerData = new CustomerData();
		customerData.setCustId(customer.getCustId());
		customerData.setCustName(customer.getCustName());
		customerData.setCustEmail(customer.getCustEmail());
		customerData.setCustAddress(customer.getCustAddress());
		return customerData;
	}

	public List<CustomerData> findAll() {
		List<CustomerData> customerDataList=new ArrayList<>();
		List<Customer> customer=customerRepository.findAll();
		for (Customer customer2 : customer) {
			customerDataList.add(getCustomerData(customer2));
		}
		return customerDataList;
	}

	public CustomerData findById(Long id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		if(customerOptional == null) {
			new EntityNotFoundException("CustomerNotFound");
		}
		return getCustomerData(customerOptional.get());
	}

	public CustomerData create(CustomerData customerData) {
		Customer customer=getCustomerEntity(customerData);
		return getCustomerData(customerRepository.save(customer));
	}

	public boolean delete(Long id) {
		Customer customer = customerRepository.findById(id).get();
		if(customer!=null) {
			customerRepository.deleteById(id);
			return true;
		}		
		return false;
	}

	public CustomerData update(Long id, CustomerData customerData) {
		Customer customer = new Customer();
		String customername = customerData.getCustName();
		String customeraddress = customerData.getCustAddress();
		String customeremail = customerData.getCustEmail();
		
		customerData = findById(id);
		customerData.setCustId(id);
		customerData.setCustName(customername);
		customerData.setCustEmail(customeremail);
		customerData.setCustAddress(customeraddress);
		
		customer.setCustId(customerData.getCustId());
		customer.setCustName(customerData.getCustName());
		customer.setCustEmail(customerData.getCustEmail());
		customer.setCustAddress(customerData.getCustAddress());
		return getCustomerData(customerRepository.save(customer));
		
		
	}
}
