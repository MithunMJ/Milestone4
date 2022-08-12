package com.mindtree.studentservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.xml.ws.Response;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindtree.studentservice.Entity.Student;

@SpringBootTest
class StudentServiceApplicationTests 
{

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	ObjectMapper om=new ObjectMapper();
	
	@Before(value = "")
	public void setUp()
	{
		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void addEmployeeTest() throws Exception
	{
		Student studente=new Student();
		
		studente.setName("Mithun");
		studente.setRollNo(24);
		studente.setGender("male");
		studente.setAge(25);
		studente.setClg_id(4);
		studente.setStream("Mechanical");
		
		String jsonRequest=om.writeValueAsString(studente);
		
		MvcResult result=mockMvc.perform(post("/student").content(jsonRequest).content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		
		String resultContent=result.getResponse().getContentAsString();
		
		Response response=om.readValue(resultContent, Response.class);
		
		Assert.assertTrue(response.isStatus() == Boolean.TRUE);
		
		
	}
	
	@Test
	public void getEmployeeTest() throws Exception
	{
		Student studente=new Student();
		
		studente.setName("Jyo");
		studente.setRollNo(25);
		studente.setGender("female");
		studente.setAge(26);
		studente.setClg_id(4);
		studente.setStream("ec");
		
		String jsonRequest=om.writeValueAsString(studente);
		
		MvcResult result=mockMvc.perform(get("/student").content(jsonRequest).content(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		
		String resultContent=result.getResponse().getContentAsString();
		
		Response response=om.readValue(resultContent, Response.class);
		
		Assert.assertTrue(response.isStatus() == Boolean.TRUE);
		
		
	}


}
