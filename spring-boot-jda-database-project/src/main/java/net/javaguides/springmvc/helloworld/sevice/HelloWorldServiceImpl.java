package net.javaguides.springmvc.helloworld.sevice;

import java.util.List;
import net.javaguides.springmvc.helloworld.exception.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.javaguides.springmvc.helloworld.model.HelloWorld;
import net.javaguides.springmvc.helloworld.repository.EmployeeRepository;
import net.javaguides.springmvc.helloworld.sevice.HelloWorldService;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {

	@Autowired
	private EmployeeRepository repository;
	
	@Override
	@Transactional
	public List<HelloWorld> getAllEmployees() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void saveEmployee(HelloWorld theEmployee) {
		repository.save(theEmployee);
	}

	@Override
	@Transactional
	public HelloWorld getEmployee(int id) throws ResourceNotFoundException {
		return repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException(id));
	}

	@Override
	@Transactional
	public void deleteEmployee(int theId) {
		repository.deleteById(theId);
	}
}





