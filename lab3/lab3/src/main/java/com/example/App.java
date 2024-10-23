/*
@author   $Rostyslav_Daskaliuk
@project   $Practice 3. Company service. 20 tests.
@class  $444B
@since 19.10.2024 - 15.54
*/

package com.example;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Company {
    private Company parent;       
    private long employeeCount;   

    public Company getParent() {
        return parent;
    }

    public void setParent(Company parent) {
        this.parent = parent;
    }

    public long getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(long employeeCount) {
        this.employeeCount = employeeCount;
    }
}

interface ICompanyService {
    Company getTopLevelParent(Company child);

    long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies);
}

class CompanyServiceImpl implements ICompanyService {

    @Override
    public Company getTopLevelParent(Company child) {
        if (child == null) {
            return null;
        }
        Company current = child;
        Set<Company> visited = new HashSet<>();  
        while (current.getParent() != null) {
            if (!visited.add(current)) {
                throw new IllegalStateException("Cyclic reference detected");
            }
            current = current.getParent();
        }
        return current;
    }

    @Override
    public long getEmployeeCountForCompanyAndChildren(Company company, List<Company> companies) {
        if (company == null || companies == null) {
            return 0;
        }
        Set<Company> visited = new HashSet<>();
        return getEmployeeCountForCompanyAndChildrenHelper(company, companies, visited);
    }

    private long getEmployeeCountForCompanyAndChildrenHelper(Company company, List<Company> companies, Set<Company> visited) {
        if (company == null || visited.contains(company)) {
            return 0;
        }
        visited.add(company); 
        long totalEmployees = company.getEmployeeCount();

        for (Company childCompany : companies) {
            if (childCompany != null && childCompany.getParent() == company) {
                totalEmployees += getEmployeeCountForCompanyAndChildrenHelper(childCompany, companies, visited);
            }
        }

        return totalEmployees;
    }
}

public class App {
    public static void main(String[] args) {

        Company companyA = new Company();
        companyA.setEmployeeCount(100);

        Company companyB = new Company();
        companyB.setParent(companyA);
        companyB.setEmployeeCount(50);

        Company companyC = new Company();
        companyC.setParent(companyB);
        companyC.setEmployeeCount(25);

        CompanyServiceImpl service = new CompanyServiceImpl();

        Company topLevelParent = service.getTopLevelParent(companyC);
        System.out.println("Top level parent: " + (topLevelParent == companyA));

        List<Company> companies = List.of(companyA, companyB, companyC);
        long totalEmployeeCount = service.getEmployeeCountForCompanyAndChildren(companyA, companies);
        System.out.println("Total employee count for company A and its children: " + totalEmployeeCount);
    }
}