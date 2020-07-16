package com.employeeapi.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.employeeapi.model.Employee;
import com.employeeapi.repository.EmployeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServicesTest {
	
	private EmployeeServices employeeServices;

    @Mock
    private EmployeeRepository employeeRepository;
    
    
	@Test
	public void testServicesRetrieveAllEmployee() {

		List<Employee> result = employeeServices.retrieveAllEmployee();
        //Assert
        assertNotNull(result);

//        when(employeeRepository.findAll()).thenReturn();
	}


	@Test
	void testCreateEmployee() {
//		fail("Not yet implemented");
//		//Arrange
//		Employee employee = new Employee(10004l, "Tony", "Stark", "CEO");
//		when(employeeServices.createMember(Employee.class)).thenReturn(employee);
//
//        //Act
//        ResultActions result = mockMvc.perform(post("/members")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsBytes(member)));
//
//        //Assert
//        result.andExpect(status().isCreated())
//                .andExpect(jsonPath("$.name", is("cherprang")));
//        verify(memberService).createMember(any(Member.class));
//       
//        ResponseEntity<Object> responseEntity = employeeServices.createEmployee(employee);
	}

	
}
