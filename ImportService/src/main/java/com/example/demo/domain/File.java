package com.example.demo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Value
@Data
@Builder
public class File {

	private String fileName;
	private String fileType;
	private String message;

}
