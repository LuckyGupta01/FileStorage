package com.example.demo.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.domain.File;
import com.example.demo.entity.DBFile;
import com.example.demo.enums.Constant;
import com.example.demo.exception.FileStorageException;
import com.example.demo.repository.ImportRepository;

@Service
public class ImportService {

	@Autowired
	private ImportRepository importRepository;

	public File uploadFileService(MultipartFile file) throws IOException {

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		if (fileName.contains("..")) {
			throw new FileStorageException("Filename contains invalid path sequence " + fileName);
		}

		DBFile dbFile = DBFile.builder().fileName(file.getOriginalFilename()).fileType(file.getContentType())
				.data(file.getBytes()).build();
		importRepository.save(dbFile);

		return File.builder().fileName(fileName).fileType(file.getContentType())
				.message(Constant.FILE_UPLOADED_SUCESSFULLY.toString()).build();
	}
}
