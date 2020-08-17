package com.poc.export.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.poc.export.domain.File;
import com.poc.export.domain.FileResponse;
import com.poc.export.entity.DBFile;
import com.poc.export.service.ExportService;

import io.swagger.annotations.ApiOperation;

@RestController
public class ExportController {

	@Autowired
	private ExportService exportService;

	@ApiOperation(value = "Download files from the persistence storage")
	@GetMapping("/exportFile/{fileId}")
	public ResponseEntity<Resource> importFile(@PathVariable Long fileId) {

		DBFile dbFile = exportService.getFile(fileId);

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(dbFile.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
				.body(new ByteArrayResource(dbFile.getData()));

	}

	@GetMapping("/listStoredFiles")
	public FileResponse listImportedFiles() {
		List<File> fileList = exportService.listStoredFiles();

		return FileResponse.builder().storedFileList(fileList).build();
	}

}
