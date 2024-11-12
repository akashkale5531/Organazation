package com.organazation.system.Controller;

import com.organazation.system.Entity.Country;
import com.organazation.system.Entity.Employee;
import com.organazation.system.Service.EmployeeServiceClass;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/organisation")
public class ResourceController {

    @Autowired
    private EmployeeServiceClass serviceClass;

    @PostMapping("/add/country")
    public ResponseEntity<String> addCountry(@RequestBody Country c){
        String add= serviceClass.addCountry(c);
        return ResponseEntity.ok(add);
    }

    @PutMapping("/update/country/{id}")
    public ResponseEntity<String> updateCountry(@RequestBody Country c,@PathVariable long id){
        String update= serviceClass.updateCountry(c,id);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/delete/country/{id}")
    public ResponseEntity<String> deleteCountry(@PathVariable long id){
        String delete= serviceClass.deleteCountry(id);
        return ResponseEntity.ok(delete);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Country>> getAll(){
        List<Country> all=serviceClass.allCountry();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/getcountry/id/{id}")
    public ResponseEntity<Country> getById(@PathVariable long id){
        Country country=serviceClass.getCountryById(id);
        return ResponseEntity.status(HttpStatus.OK).body(country);
    }

    @PostMapping("/add/employee")
    public ResponseEntity<String> addEmp(@RequestBody Employee employee){
        String add= serviceClass.addEmployee(employee);
        return ResponseEntity.ok(add);
    }

    @PutMapping("/update/employee/{id}")
    public ResponseEntity<String> updateEmp(@RequestBody Employee employee, @PathVariable long id){
        String update= serviceClass.updateEmployee(employee,id);
        return ResponseEntity.ok(update);
    }

    @PostMapping("/login")
    public ResponseEntity<Map> login(@RequestBody Employee employee){
        Map map=serviceClass.login(employee);
        return ResponseEntity.ok(map);
    }

    @PostMapping("/salary/employee")
    public ResponseEntity<List<Employee>> salaryRange(@PathVariable double startSalary, @PathVariable double endSalary){
        List<Employee> listSalary=serviceClass.salaryRange(startSalary,endSalary);
        return ResponseEntity.ok(listSalary);
    }


}
