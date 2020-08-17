package com.poc.export.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Value
@Data
@Builder
@AllArgsConstructor
public class File {

	private Long id;
	private String fileName;
	private String fileType;
}
