package com.rzit.microservice.airports;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.client.response.MockRestResponseCreators;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@RestClientTest(ErrorHandlerClient.class)
public class ErrorHandlerClientTest {

	@Autowired
	private ErrorHandlerClient client;

	@Autowired
	private MockRestServiceServer server;

	@Autowired
	private ObjectMapper objectMapper;

	@Before
	public void setUp() throws Exception {
		String detailsString = objectMapper.writeValueAsString(new ErrorMessageVO("4000", "Test Error Message"));

		this.server.expect(MockRestRequestMatchers.requestTo("/4000/details"))
				.andRespond(MockRestResponseCreators.withSuccess(detailsString, MediaType.APPLICATION_JSON));
	}

	@Test
	public void whenCallingGetUserDetails_thenClientMakesCorrectCall() throws Exception {

		ErrorMessageVO details = this.client.getErrorMessage("4000");

		Assertions.assertThat(details.getCode()).isEqualTo("4000");
		Assertions.assertThat(details.getMessage()).isEqualTo("Test Error Message");
	}
}
