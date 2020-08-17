package com.example.demo.service;

import static org.mockito.Mockito.verify;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import com.example.demo.entity.DBFile;
import com.example.demo.repository.ImportRepository;

@RunWith(MockitoJUnitRunner.class)
public class ImportServiceTest {

	@InjectMocks
	private ImportService importService;

	@Mock
	private ImportRepository importRepository;

	@Test
	public void importServiceTest() throws IOException {

		MockMultipartFile fileMultipart = new MockMultipartFile("file", "contract.jpeg", MediaType.IMAGE_JPEG_VALUE,
				"<<jpeg data>>".getBytes(StandardCharsets.UTF_8));

		importService.uploadFileService(fileMultipart);
		verify(importRepository).save(DBFile.builder().fileName(fileMultipart.getOriginalFilename())
				.fileType(fileMultipart.getContentType()).build());
	}

}
