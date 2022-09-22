package pro.sky.cousrse2.employeelist.Service;

import org.springframework.stereotype.Service;
import pro.sky.cousrse2.employeelist.Class.Employee;
import pro.sky.cousrse2.employeelist.Exception.EmployeeAlreadyAddedException;
import pro.sky.cousrse2.employeelist.Exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final List<Employee> employees = new ArrayList<>();

    @Override
    public Employee add(String firstname, String lastname) {
        try {
            if (find(firstname, lastname) != null) {
                throw new EmployeeAlreadyAddedException("Сотрудник уже добавлен!");
            }
        } catch (EmployeeAlreadyAddedException e) {
            e.printStackTrace();
            return null;
        }
        employees.add(new Employee(firstname, lastname));
        return new Employee(firstname, lastname);
    }


    @Override
    public Employee remove(String firstname, String lastname) {
        try {
            if (find(firstname, lastname) != null) {
                throw new EmployeeNotFoundException("Сотрудник не найден!");
            }
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        employees.remove(new Employee(firstname, lastname));
        return new Employee(firstname, lastname);
    }

    @Override
    public Employee find(String firstname, String lastname) {
        Employee temp = new Employee(firstname, lastname);
        for (Employee employee : employees) {
            if (employee.equals(temp)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public List<Employee> print() {
        return employees;
    }
}
