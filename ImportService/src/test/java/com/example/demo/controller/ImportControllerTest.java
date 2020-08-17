package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.service.ImportService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ImportController.class })
public class ImportControllerTest {

	@Autowired
	private ImportController importController;

	@MockBean
	private ImportService importService;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(importController).build();
	}

	@Test
	public void shouldReturn200WhenImportFileIsCalled() throws Exception {

		 MockMultipartFile file 
	      = new MockMultipartFile(
	        "file", 
	        "hello.txt", 
	        MediaType.TEXT_PLAIN_VALUE, 
	        "Hello, World!".getBytes()
	      );
		 mockMvc.perform(multipart("/importFile").file(file))
	      .andExpect(status().isOk());
	}

}
