package com.employeeapi.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

class EmployeeControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testRetrieveAllEmployee() throws Exception{
		mvc.perform( MockMvcRequestBuilders
			      .get("/employee/getEmployeesList")
			      .header("Authorization", "Bearer " + "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0dXNlciIsImV4cCI6MTU5NDkwMjA0OSwiaWF0IjoxNTk0ODg0MDQ5fQ.YZLVq5NVii547Oo6U_HrBbHbmBr_YKEe4lfbX1eNTaR__JMVo-OOEi4lFW1bZJ_4K1wTId7eXVzuxjgCam2BXw")
			      .accept(MediaType.APPLICATION_JSON))
			      .andDo(MockMvcResultHandlers.print())
			      .andExpect(MockMvcResultMatchers.status().isOk());
	}
	
//	private String obtainAccessToken() throws Exception {
//        JsonObject user = new JsonObject();
//        user.addProperty("username", "testuser");
//        user.addProperty("password", "password");

	  

//	    String content = result.getResponse().getContentAsString();
//	}

}
