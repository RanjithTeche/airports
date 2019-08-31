package com.rzit.microservice.airports;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document
@Getter
@Setter
public class Airport {
	@Id
	private String code;
	private String name;
	
}
