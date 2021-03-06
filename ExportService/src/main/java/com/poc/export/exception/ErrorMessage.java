package com.poc.export.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class ErrorMessage {
	
	private String type;
	private String message;

}
