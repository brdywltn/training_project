package uk.gov.companieshouse.docsapp.web;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.gov.companieshouse.docsapp.dao.CompanyRegistry;
import uk.gov.companieshouse.docsapp.dao.InMemoryCompanyRegistry;
import uk.gov.companieshouse.docsapp.model.company.Company;

import java.util.List;

@RestController
public class CompanyController {
    /**
    * Create access to the repository within the controller
    * */
    @Autowired
    private CompanyRegistry reggie;


    /**
    * Get a list of all companies
    * */
    @GetMapping("/companies")
    public ResponseEntity<List<Company>> getCompanies() {
        List<Company> listOfCompanies = reggie.getCompanies();

        return ResponseEntity.ok(listOfCompanies);
    }

    /**
    * Add a new company to the database
    * */
    @PostMapping("/companies")
    public ResponseEntity<Company> createCompany(@RequestBody Company data) {
        if (data.getCompanyName() == null ||
            data.getRegisteredAddress() == null ) {
            return ResponseEntity.badRequest().build();
        }
        else {
            reggie.addCompany(data);
            return ResponseEntity.ok(data);
        }
    }

    /**
    * Get a single company
    * */
    @GetMapping("/companies/{registrationNumber}")
    public ResponseEntity<Company> getCompany(@PathVariable(required = true) String registrationNumber) {
        Company searchedFor = reggie.getCompany(String.valueOf(registrationNumber));

        return ResponseEntity.ok(searchedFor);
    }

    /**
    * Replace an existing company with a new company object
    * */
    @PutMapping("companies/{registrationNumber}")
    public ResponseEntity<Void> replaceCompany(@PathVariable(required = true) String registrationNumber, Company company) {
        Company toBeReplaced = reggie.getCompany(registrationNumber);

        if (toBeReplaced == null) {
            return ResponseEntity.badRequest().build();
        } else {
            reggie.editCompany(registrationNumber, company);
            return ResponseEntity.noContent().build();
        }

    }

    /**
    * Update the fields of an existing company
    * */
    @PatchMapping("companies/{registrationNumber}")
    public ResponseEntity<Void> updateCompany(@PathVariable(required = true) String registrationNumber, Company company) {
        if (registrationNumber == null) {
            return ResponseEntity.badRequest().build();
        } else {
            reggie.patchCompany(registrationNumber, company);
            return ResponseEntity.noContent().build();
        }
    }

    /**
     * Delete an existing company
     * */
    @DeleteMapping("companies/{registrationNumber}")
    public ResponseEntity<Void> deleteCompany(@PathVariable(required = true) String registrationNumber) {
        Company requestedForDelete = reggie.getCompany(registrationNumber);

        if (requestedForDelete == null) {
            return ResponseEntity.badRequest().build();
        } else {
            reggie.deleteCompany(registrationNumber);
            return ResponseEntity.noContent().build();
        }
    }
}
