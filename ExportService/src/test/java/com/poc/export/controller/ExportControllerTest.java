package com.poc.export.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

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

import com.poc.export.domain.File;
import com.poc.export.entity.DBFile;
import com.poc.export.service.ExportService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { ExportController.class })
public class ExportControllerTest {

	@Autowired
	private ExportController exportController;

	@MockBean
	private ExportService exportService;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(exportController).build();
	}

	@Test
	public void shouldReturn200WhenExportFileIsCalled() throws Exception {

		MockMultipartFile file 
	      = new MockMultipartFile(
	        "file", 
	        "hello.txt", 
	        MediaType.TEXT_PLAIN_VALUE, 
	        "Hello, World!".getBytes()
	      );
		when(exportService.getFile(1L)).thenReturn(DBFile.builder()
				.fileName(file.getOriginalFilename()).fileType(file.getContentType()).data(file.getBytes()).build());
		mockMvc.perform(get("/exportFile/1")).andExpect(status().isOk());
	}
	
	@Test
	public void shouldReturn200WhenGetStoredFileIsCalled() throws Exception {

		when(exportService.listStoredFiles()).thenReturn(Collections.singletonList(File.builder().build()));
		mockMvc.perform(get("/listStoreFiles")).andExpect(status().isOk());
	}

}
