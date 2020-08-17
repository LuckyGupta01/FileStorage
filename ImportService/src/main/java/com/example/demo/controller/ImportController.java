package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.File;
import com.example.demo.service.ImportService;

import io.swagger.annotations.ApiOperation;

@RestController
public class ImportController {

	@Autowired
	private ImportService importService;

	@ApiOperation(value = "Import files to the persistence storage")
	@PostMapping("/importFile")
	public File importFile(@RequestParam("file") MultipartFile file) throws IOException {

		File fileResponse = importService.uploadFileService(file);

		return fileResponse;

	}

}
