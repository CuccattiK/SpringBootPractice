package com.cuccatti.springbootpractice.exception.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"message", "error"})
public class ErrorHandlerResponse {

	private String message;
	boolean isError;
}
