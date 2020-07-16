package com.employeeapi.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
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
	public void testGetEmployeesList() throws Exception{
		
//		String token = this.obtainAccessToken();
		String token = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ0ZXN0dXNlciIsImV4cCI6MTU5NDkyMjc1NywiaWF0IjoxNTk0OTA0NzU3fQ.jY0Otsq4FX2jWm90yqht115rv_KtghG7886edcuufM8N6k_fPj5KvPQDv1zz9AW9WYpJQ91QhALTLLmGUaC-1w";
		mvc.perform( MockMvcRequestBuilders
			      .get("/employee/getEmployeesList")
			      .header("Authorization", "Bearer " + token)
			      .accept(MediaType.APPLICATION_JSON))
			      .andDo(MockMvcResultHandlers.print())
			      .andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	private String obtainAccessToken() throws Exception {
		String jsonString = "{"+"\"username\": \"testuser\","+"\"password\":\"password\""+"}";

		MvcResult result = mvc.perform(
				MockMvcRequestBuilders.post("/authenticate")
	                    .contentType(MediaType.APPLICATION_JSON)
	                    .content(jsonString))
	            .andExpect(MockMvcResultMatchers.status().isOk())
	            .andReturn();
	    String content = result.getResponse().getContentAsString();
		return content;
	}

}
