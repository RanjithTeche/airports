package com.rzit.microservice.airports;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/airports")
public class AirportController {

	@Autowired
	AirportRepository airportRepository;

	@GetMapping("/all")
	public List<Airport> getAllAirports() {
		return airportRepository.findAll();
	}

	@GetMapping("/{code}")
	public Optional<Airport> getAirportByCode(@PathVariable String code) {
		return airportRepository.findById(code);
	}

	@RequestMapping(value = "/test", method = { RequestMethod.DELETE, RequestMethod.GET, RequestMethod.HEAD,
			 RequestMethod.PATCH, RequestMethod.POST, RequestMethod.PUT, RequestMethod.TRACE })
	public ResponseEntity<String> test() {
		return ResponseEntity.ok("test DONE");
	}
	
	@RequestMapping(value = "/testDefaultRequestMapping")
	public ResponseEntity<String> testDefaultRequestMapping() {
		return ResponseEntity.ok("testDefaultRequestMapping DONE");
	}

	@PostMapping()
	public Airport getAllAirports(@RequestBody Airport airport) {
		return airportRepository.save(airport);
	}
}
