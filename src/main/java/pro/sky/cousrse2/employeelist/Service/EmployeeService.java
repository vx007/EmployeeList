package pro.sky.cousrse2.employeelist.Service;

import pro.sky.cousrse2.employeelist.Class.Employee;
import pro.sky.cousrse2.employeelist.Exception.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {
    Employee add(String firstname, String lastname);

    Employee remove(String firstname, String lastname);

    Employee find(String firstname, String lastname);

    List<Employee> print();
}
