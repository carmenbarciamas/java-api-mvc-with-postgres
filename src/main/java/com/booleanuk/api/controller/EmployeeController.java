package com.booleanuk.api.controller;

import com.booleanuk.api.model.Employee;
import com.booleanuk.api.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    private EmployeeRepository employees;

    public EmployeeController() throws SQLException{
       this.employees = new EmployeeRepository();
    }

    @GetMapping
    public List<Employee> getAll() throws SQLException{
       return this.employees.getAll();
    }

    @GetMapping("/{id}")
    public Employee getOne(@PathVariable(name = "id") long id) throws SQLException{
        Employee employee = this.employees.get(id);
        if (employee == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "not found");
        }

        return employee;

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee create(@RequestBody Employee employee) throws SQLException{
        Employee theEmployee = this.employees.add(employee);
        if (theEmployee == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to create the specified employee");
        }
        return theEmployee;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee update(@PathVariable( "name" = id) long id, Employee employee) throws SQLException{
       Employee tobeUpdated  = this.employees.get(id);
       if (tobeUpdated == null){
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to update the specified employee")
       }
       return this.employees.update(id);
    }

    @DeleteMapping("/{id}")
    public Employee delete(@PathVariable(name = "id") long id) throws SQLException{
        Employee toBeDeleted = this.employees.get(id);
        if ( toBeDeleted == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to delete the specified employee");
        }
        return this.employees.delete(id);
    }

}