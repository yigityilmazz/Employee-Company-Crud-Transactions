package com.example.hello_world.controller;


import com.example.hello_world.entity.Company;
import com.example.hello_world.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping("/save")
    public ResponseEntity<String> saveCompany(@Valid @RequestBody Company company){
        companyService.saveCompany(company);
        return ResponseEntity.ok("Company saved");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Company>> getAllCompany(){
        List<Company> allCompany = companyService.getAllCompany();
        return new ResponseEntity<List<Company>>(allCompany, HttpStatus.OK);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Company> updateCompanyById(@RequestBody Company company){
        Company updatedCompany = companyService.updateCompany(company);
        return new ResponseEntity<Company>(updatedCompany, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCompanyById(@PathVariable(name = "id") Long companyId){
        companyService.deleteCompanyById(companyId);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

}
