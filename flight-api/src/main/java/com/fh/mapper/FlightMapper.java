package com.fh.mapper;

import com.fh.model.*;

import java.util.List;

public interface FlightMapper {

    Long selectCount(FlightQuery flightQuery);

    List<Flight> selectFlightList(FlightQuery flightQuery);
    

    List<PlaneType> selectFlightType();

    List<Area> selectBeginArea();



    void addFlightTicket(FlightTicket flightTicket);

    void addFlight(Flight flight);

    Flight selectFlightById(Integer id);
}
