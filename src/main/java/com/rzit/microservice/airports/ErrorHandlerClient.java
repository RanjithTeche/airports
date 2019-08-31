package com.rzit.microservice.airports;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ErrorHandlerClient {
	private final RestTemplate restTemplate;

	public ErrorHandlerClient(RestTemplateBuilder restTemplateBuilder) {
		restTemplate = restTemplateBuilder.build();
	}

	public ErrorMessageVO getErrorMessage(String code) {
		return restTemplate.getForObject("/{code}/details", ErrorMessageVO.class, code);
	}
}
