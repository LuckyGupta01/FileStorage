package com.poc.export.domain;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

@Builder
@Getter
@Setter
@Value
public class FileResponse {
	
	private List<File> storedFileList;

}
