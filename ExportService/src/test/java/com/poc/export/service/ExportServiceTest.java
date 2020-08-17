package com.poc.export.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.poc.export.domain.File;
import com.poc.export.entity.DBFile;
import com.poc.export.repository.ExportRepository;


@RunWith(MockitoJUnitRunner.class)
public class ExportServiceTest {

	@InjectMocks
	private ExportService exportService;

	@Mock
	private ExportRepository exportRepository;

	@Test
	public void importServiceTest() throws IOException {

		DBFile dbFile = DBFile.builder().build();
		when(exportRepository.findById(4L)).thenReturn(Optional.of(dbFile));
		DBFile dbFileResponse = exportService.getFile(4L);
		
		assertThat(dbFileResponse).isEqualTo(dbFile);
	}
	
	@Test
	public void storedFileList() throws IOException {

		List<File> dbFile = Collections.singletonList(File.builder().build());
		when(exportRepository.findAll()).thenReturn(Collections.singletonList(DBFile.builder().build()));
		List<File> dbFileResponse = exportService.listStoredFiles();
		assertThat(dbFileResponse).isEqualTo(dbFile);
	}

}
