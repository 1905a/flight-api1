package com.fh.service;

import com.fh.model.*;

import java.util.List;

public interface FlightService {
    DataTableResult selectFlightList(FlightQuery flightQuery);
    

    List<PlaneType> selectFlightType();

    List<Area> selectBeginArea();

    void addFlight(Flight flight);

    Flight selectFlightById(Integer id);
}
