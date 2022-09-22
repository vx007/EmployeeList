package pro.sky.cousrse2.employeelist.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.cousrse2.employeelist.Class.Employee;
import pro.sky.cousrse2.employeelist.Service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeCtrl {
    private final EmployeeService employeeService;

    public EmployeeCtrl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee answerAdd(@RequestParam("firstname") String firstname,
                              @RequestParam("lastname") String lastname) {
        return employeeService.add(firstname, lastname);
    }

    @GetMapping("/remove")
    public Employee answerRemove(@RequestParam("firstname") String firstname,
                                 @RequestParam("lastname") String lastname) {
        return employeeService.remove(firstname, lastname);
    }

    @GetMapping("/find")
    public Employee answerFind(@RequestParam("firstname") String firstname,
                               @RequestParam("lastname") String lastname) {
        return employeeService.find(firstname, lastname);
    }

    @GetMapping("/print")
    public List<Employee> answerPrint() {
        return employeeService.print();
    }
}
