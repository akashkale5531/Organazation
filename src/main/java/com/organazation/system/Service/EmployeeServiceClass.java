package com.organazation.system.Service;

import com.organazation.system.Entity.Country;
import com.organazation.system.Entity.Employee;
import com.organazation.system.Repository.CountryRepo;
import com.organazation.system.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EmployeeServiceClass {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private CountryRepo countryRepo;

    public String addCountry(Country country){
        countryRepo.save(country);
        return "Add the country details";
    }

    public String updateCountry(Country country,long cid){
        Optional<Country> existingCountry=countryRepo.findById(cid);
        if(existingCountry.isPresent()){
            Country updateCountry=existingCountry.get();
            updateCountry.setCname(country.getCname());
            countryRepo.save(updateCountry);
            return "Country details has been update";
        }
        return "Country Not Found";
    }

    public String deleteCountry(long cid){
        if(countryRepo.existsById(cid)){
            countryRepo.deleteById(cid);
            return "Country details has been deleted";
        }
        return "Country not found";
    }

    public List<Country> allCountry(){
        return countryRepo.findAll();
    }

    public Country getCountryById(long cid){
        return countryRepo.findById(cid).orElse(null);
    }

    public String addEmployee(Employee employee){
        employeeRepo.save(employee);
        return "Employee details is added";
    }

    public String updateEmployee(Employee employee, long id) {
        Optional<Employee> checkEmp = employeeRepo.findById(id);
        if (checkEmp.isPresent()) {
            Employee updateEmp = checkEmp.get();
            updateEmp.setName(employee.getName());
            updateEmp.setSalary(employee.getSalary());
            updateEmp.setEmailid(employee.getEmailid());
            employeeRepo.save(updateEmp);
            return "Employee details has been updated";
        }
        return "Not Found";
    }

    public Map login(Employee employee){
        if(employeeRepo.existsById(employee.getId())){
            return Map.of("message", "Login successful", "status", "success");
        }else{
            return Map.of("message", "Invalid credentials", "status", "error");
        }
    }

    public List<Employee> salaryRange(double startSalary, double endSalary){
        return employeeRepo.findBySalaryBetween(startSalary,endSalary);
    }


}
