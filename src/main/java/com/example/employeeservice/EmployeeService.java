package com.example.employeeservice;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService() {
        this.employeeRepository = new EmployeeRepository();
    }

    private List<Employee> getAllEmployees(){
        return employeeRepository.getAllEmployees();
    }

    private List<Employee> getEmployeeById(Long id){
        return employeeRepository.getEmployeeById(id);
    }

    private void addEmployee(Employee employee){
        employeeRepository.addEmployee(employee);
    }

    private void updateEmployee(Employee employee){
        employeeRepository.updateEmployee(employee);
    }

    public List<Employee> getEmployee(HttpServletRequest request){
        List<Employee> employees;

        if(request.getParameter("emp_id") == null){
            employees = getAllEmployees();
        }
        else{
            Long id = Long.valueOf(request.getParameter("emp_id"));
            employees = getEmployeeById(id);
        }
        return employees;
    }

    public void manageEmployee(HttpServletRequest request){
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String occupation = request.getParameter("occupation");

        Employee employee = new Employee();
        employee.setName(name);
        employee.setSurname(surname);
        employee.setOccupation(occupation);

        if(request.getParameter("put") == null){
            addEmployee(employee);
        }
        else{
            Long id = Long.valueOf(request.getParameter("id"));
            employee.setId(id);
            updateEmployee(employee);
        }
    }
}
