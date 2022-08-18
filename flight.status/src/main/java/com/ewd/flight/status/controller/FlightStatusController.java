package com.ewd.flight.status.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

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

	private Logger logger = (Logger) LogManager.getLogger(this.getClass());

	@PostMapping(value = "/status/v1")
	public ResponseEntity<FlightStatusResponse> flightStatusController(
			@RequestBody FlightStatusRequest flightStatusReq) {
		try {
			System.out.println("API Inside");
			logger.info("FlightStatus Req Data" + flightStatusReq.getFlightNumber());
			FlightStatusResponse flightStatusResponse = flightService.retrieveFlightStatus(flightStatusReq);
			if (flightStatusResponse != null) {
				logger.info("Flight Status response");
				return new ResponseEntity<>(flightStatusResponse, HttpStatus.OK);
			} else {
				logger.info("No Flight status available for the specificed flight number");
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception ex) {
			System.out.println("Exception");
			logger.error("Exceptions");
			ex.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

}
