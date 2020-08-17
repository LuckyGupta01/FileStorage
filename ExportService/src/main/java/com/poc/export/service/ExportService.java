package com.poc.export.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.export.domain.File;
import com.poc.export.entity.DBFile;
import com.poc.export.enums.Constant;
import com.poc.export.exception.MyFileNotFoundException;
import com.poc.export.repository.ExportRepository;

@Service
public class ExportService {

	@Autowired
	private ExportRepository exportRepository;

	public DBFile getFile(Long fileId) {

		return exportRepository.findById(fileId)
				.orElseThrow(() -> new MyFileNotFoundException(Constant.FILE_NOT_FOUND.toString(), fileId));

	}

	public List<File> listStoredFiles() {

		List<DBFile> listDbFile = exportRepository.findAll();

		List<File> file = listDbFile.stream()
				.map(dbFile -> new File(dbFile.getId(), dbFile.getFileName(), dbFile.getFileType()))
				.collect(Collectors.toList());

		return file;
	}
}
