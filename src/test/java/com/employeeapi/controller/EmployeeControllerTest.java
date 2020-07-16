package com.employeeapi.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

@RestController
public class EmployeeControllerTest {

	@Test
	public void testRetrieveAllEmployee() {
		fail("Not yet implemented");
	}
	
	 
    @Test
    public void testRetrieveAllEmployee() 
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         
//        when(employeeDAO.addEmployee(any(Employee.class))).thenReturn(true);
         
        Employee employee = new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com");
        ResponseEntity<Object> responseEntity = employeeController.addEmployee(employee);
         
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
    }

}
