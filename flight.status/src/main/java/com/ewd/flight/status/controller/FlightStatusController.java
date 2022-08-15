package com.ewd.flight.status.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ewd.flight.status.model.FlightStatusRequest;
import com.ewd.flight.status.model.FlightStatusResponse;
import com.ewd.flight.status.services.FlightStatusService;
@RestController
@RequestMapping(value = "/ewd/flight")
public class FlightStatusController {

	@Autowired
	private FlightStatusService flightService;

	@PostMapping(value = "/status/v1")
	public ResponseEntity<FlightStatusResponse> flightStatusController(
			@RequestBody FlightStatusRequest flightStatusReq) {
		try {
			System.out.println("flightStatusReq"+flightStatusReq.getFlightNumber());
			FlightStatusResponse flightStatusResponse = flightService.retrieveFlightStatus(flightStatusReq);
			if(flightStatusResponse!=null) {
				System.out.println("NOT NULL");
				return new ResponseEntity<>(flightStatusResponse, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			System.out.println("Exceptions");
			ex.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

}
