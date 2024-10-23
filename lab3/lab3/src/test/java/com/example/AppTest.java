/*
@author   $Rostyslav_Daskaliuk
@project   $Practice 3. Company service. 20 tests.
@class  $444B
@since 19.10.2024 - 15.54
*/



package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class AppTest {

    @Test
    void testTopLevelParentForSingleCompany() {
        Company company = new Company();
        company.setEmployeeCount(50);

        CompanyServiceImpl service = new CompanyServiceImpl();
        assertEquals(company, service.getTopLevelParent(company));
    }

    @Test
    void testTopLevelParentWithParent() {
        Company companyA = new Company();
        Company companyB = new Company();
        companyB.setParent(companyA);

        CompanyServiceImpl service = new CompanyServiceImpl();
        assertEquals(companyA, service.getTopLevelParent(companyB));
    }

    @Test
    void testTopLevelParentWithNullParent() {
        Company companyA = new Company();
        companyA.setParent(null);

        CompanyServiceImpl service = new CompanyServiceImpl();
        assertEquals(companyA, service.getTopLevelParent(companyA));
    }

    @Test
    void testTopLevelParentForNestedCompany() {
        Company companyA = new Company();
        Company companyB = new Company();
        companyB.setParent(companyA);
        Company companyC = new Company();
        companyC.setParent(companyB);

        CompanyServiceImpl service = new CompanyServiceImpl();
        assertEquals(companyA, service.getTopLevelParent(companyC));
    }

    @Test
    void testEmployeeCountForSingleCompany() {
        Company company = new Company();
        company.setEmployeeCount(50);

        CompanyServiceImpl service = new CompanyServiceImpl();
        assertEquals(50, service.getEmployeeCountForCompanyAndChildren(company, List.of(company)));
    }

    @Test
    void testEmployeeCountWithNoChildren() {
        Company companyA = new Company();
        companyA.setEmployeeCount(100);

        CompanyServiceImpl service = new CompanyServiceImpl();
        assertEquals(100, service.getEmployeeCountForCompanyAndChildren(companyA, List.of(companyA)));
    }

    @Test
    void testEmployeeCountWithOneChild() {
        Company companyA = new Company();
        companyA.setEmployeeCount(100);

        Company companyB = new Company();
        companyB.setParent(companyA);
        companyB.setEmployeeCount(50);

        CompanyServiceImpl service = new CompanyServiceImpl();
        assertEquals(150, service.getEmployeeCountForCompanyAndChildren(companyA, List.of(companyA, companyB)));
    }

    @Test
    void testEmployeeCountWithMultipleChildren() {
        Company companyA = new Company();
        companyA.setEmployeeCount(100);

        Company companyB = new Company();
        companyB.setParent(companyA);
        companyB.setEmployeeCount(50);

        Company companyC = new Company();
        companyC.setParent(companyA);
        companyC.setEmployeeCount(25);

        CompanyServiceImpl service = new CompanyServiceImpl();
        assertEquals(175, service.getEmployeeCountForCompanyAndChildren(companyA, List.of(companyA, companyB, companyC)));
    }

    @Test
    void testEmployeeCountWithNestedChildren() {
        Company companyA = new Company();
        companyA.setEmployeeCount(100);

        Company companyB = new Company();
        companyB.setParent(companyA);
        companyB.setEmployeeCount(50);

        Company companyC = new Company();
        companyC.setParent(companyB);
        companyC.setEmployeeCount(25);

        CompanyServiceImpl service = new CompanyServiceImpl();
        assertEquals(175, service.getEmployeeCountForCompanyAndChildren(companyA, List.of(companyA, companyB, companyC)));
    }

    @Test
    void testEmployeeCountWithNoCompanies() {
        CompanyServiceImpl service = new CompanyServiceImpl();
        assertEquals(0, service.getEmployeeCountForCompanyAndChildren(null, null));
    }

    @Test
    void testTopLevelParentForNullCompany() {
        CompanyServiceImpl service = new CompanyServiceImpl();
        assertNull(service.getTopLevelParent(null));
    }

    @Test
    void testEmployeeCountWithUnrelatedCompanies() {
        Company companyA = new Company();
        companyA.setEmployeeCount(100);

        Company companyB = new Company();
        companyB.setEmployeeCount(50);

        CompanyServiceImpl service = new CompanyServiceImpl();
        assertEquals(100, service.getEmployeeCountForCompanyAndChildren(companyA, List.of(companyA, companyB)));
    }

    @Test
    void testEmployeeCountWithDeepHierarchy() {
        Company companyA = new Company();
        companyA.setEmployeeCount(100);

        Company companyB = new Company();
        companyB.setParent(companyA);
        companyB.setEmployeeCount(50);

        Company companyC = new Company();
        companyC.setParent(companyB);
        companyC.setEmployeeCount(25);

        Company companyD = new Company();
        companyD.setParent(companyC);
        companyD.setEmployeeCount(10);

        CompanyServiceImpl service = new CompanyServiceImpl();
        assertEquals(185, service.getEmployeeCountForCompanyAndChildren(companyA, List.of(companyA, companyB, companyC, companyD)));
    }

    @Test
    void testEmployeeCountForGrandChildren() {
        Company companyA = new Company();
        companyA.setEmployeeCount(200);

        Company companyB = new Company();
        companyB.setParent(companyA);
        companyB.setEmployeeCount(100);

        Company companyC = new Company();
        companyC.setParent(companyB);
        companyC.setEmployeeCount(50);

        CompanyServiceImpl service = new CompanyServiceImpl();
        assertEquals(350, service.getEmployeeCountForCompanyAndChildren(companyA, List.of(companyA, companyB, companyC)));
    }

    @Test
    void testTopLevelParentWithDeepHierarchy() {
        Company companyA = new Company();
        Company companyB = new Company();
        companyB.setParent(companyA);

        Company companyC = new Company();
        companyC.setParent(companyB);

        Company companyD = new Company();
        companyD.setParent(companyC);

        CompanyServiceImpl service = new CompanyServiceImpl();
        assertEquals(companyA, service.getTopLevelParent(companyD));
    }

    @Test
    void testEmployeeCountWithDisconnectedHierarchy() {
        Company companyA = new Company();
        companyA.setEmployeeCount(100);

        Company companyB = new Company();
        companyB.setEmployeeCount(50);

        Company companyC = new Company();
        companyC.setEmployeeCount(25);

        CompanyServiceImpl service = new CompanyServiceImpl();
        assertEquals(100, service.getEmployeeCountForCompanyAndChildren(companyA, List.of(companyA, companyB, companyC)));
    }

    @Test
    void testEmployeeCountForNonChildCompany() {
        Company companyA = new Company();
        companyA.setEmployeeCount(100);

        Company companyB = new Company();
        companyB.setEmployeeCount(50);

        CompanyServiceImpl service = new CompanyServiceImpl();
        assertEquals(100, service.getEmployeeCountForCompanyAndChildren(companyA, List.of(companyA, companyB)));
    }


    @Test
    void testTopLevelParentWithGrandChild() {
        Company companyA = new Company();
        Company companyB = new Company();
        companyB.setParent(companyA);

        Company companyC = new Company();
        companyC.setParent(companyB);

        CompanyServiceImpl service = new CompanyServiceImpl();
        assertEquals(companyA, service.getTopLevelParent(companyC));
    }

    @Test
    void testEmployeeCountWithCyclicReference() {
        Company companyA = new Company();
        companyA.setEmployeeCount(100);

        Company companyB = new Company();
        companyB.setParent(companyA);
        companyB.setEmployeeCount(50);

        companyA.setParent(companyB);

        CompanyServiceImpl service = new CompanyServiceImpl();

        assertThrows(IllegalStateException.class, () -> {
            service.getTopLevelParent(companyA);
        });
    }

    @Test
    void testEmployeeCountWithSelfReference() {
        Company companyA = new Company();
        companyA.setEmployeeCount(100);

        companyA.setParent(companyA);

        CompanyServiceImpl service = new CompanyServiceImpl();
        assertEquals(100, service.getEmployeeCountForCompanyAndChildren(companyA, List.of(companyA)));
    }

    @Test
    void testEmployeeCountWithNullCompany() {
        CompanyServiceImpl service = new CompanyServiceImpl();
        assertEquals(0, service.getEmployeeCountForCompanyAndChildren(null, List.of()));
    }

    @Test
    void testEmployeeCountWithEmptyCompanyList() {
        Company companyA = new Company();
        companyA.setEmployeeCount(100);

        CompanyServiceImpl service = new CompanyServiceImpl();
        assertEquals(100, service.getEmployeeCountForCompanyAndChildren(companyA, List.of()));
    }

}
