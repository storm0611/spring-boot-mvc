package net.javaguides.springmvc.helloworld.sevice;

import java.util.List;
import net.javaguides.springmvc.helloworld.exception.ResourceNotFoundException;
import net.javaguides.springmvc.helloworld.model.HelloWorld;

public interface HelloWorldService {

    public List<HelloWorld> getAllEmployees();

    public void saveEmployee(HelloWorld theEmployee);

    public HelloWorld getEmployee(int theId) throws ResourceNotFoundException;

    public void deleteEmployee(int theId);

}
