package com.example.hello_world.service;

import com.example.hello_world.entity.Company;
import com.example.hello_world.entity.Employee;
import com.example.hello_world.repository.CompanyRepository;
import com.example.hello_world.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public Company saveCompany(Company company){
        return companyRepository.save(company);
    }

    public List<Company> getAllCompany(){
        return companyRepository.findAll();
    }

    public Company updateCompany(Company company){
        return companyRepository.save(company);
    }

    public void deleteCompanyById(Long companyId){
        companyRepository.deleteById(companyId);
    }
}
