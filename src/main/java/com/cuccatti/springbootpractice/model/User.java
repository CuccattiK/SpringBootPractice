package com.cuccatti.springbootpractice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Users")
public class User {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	
	public User(String firstName) {
		this.firstName = firstName;
	}
}