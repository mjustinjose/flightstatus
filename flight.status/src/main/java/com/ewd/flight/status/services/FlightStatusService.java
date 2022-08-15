package com.ewd.flight.status.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ewd.flight.status.model.FlightStatusRequest;
import com.ewd.flight.status.model.FlightStatusResponse;

@Service
public class FlightStatusService {

	public FlightStatusResponse retrieveFlightStatus(FlightStatusRequest flightStatusReq) {

		try {
			for (int i = 0; i < defaultItems().size(); i++) {
				if (defaultItems().get(i).getFlightNumber().equals(flightStatusReq.getFlightNumber())
						&& defaultItems().get(i).getDepartureDate().equals(flightStatusReq.getTravelDate())) {
					return defaultItems().get(i);
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}

	private static List<FlightStatusResponse> defaultItems() {
		return List.of(
				new FlightStatusResponse("300", "12 Sep 2022", "11:00 AM", "12 Sep 2022 ", "11:00 AM", "HKG", "SIN",
						"ON TIME", "Airbus 350-900"),
				new FlightStatusResponse("500", "12 Sep 2022", "11:00 AM", "12 Sep 2022 ", "11:00 AM", "HKG", "LAX",
						"ON TIME", "Airbus 350-900"),
				new FlightStatusResponse("650", "12 Sep 2022", "11:00 AM", "12 Sep 2022 ", "11:00 AM", "LHR", "SIN",
						"ON TIME", "Airbus 350-900"));
	}

}
