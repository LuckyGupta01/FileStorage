package com.example.demo.exception;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Builder
@AllArgsConstructor
@Value
public class ApiError {

	private List<ErrorMessage> message;
}
