package com.fh.service;

import com.fh.model.Area;
import com.fh.model.FlightTicket;
import com.fh.model.FlightTicketType;

import java.util.List;

public interface AreaService {
    List<Area> selectAirPortByPid(Integer pid);

    List<FlightTicketType> selectFlightTicketType();

    List<FlightTicket> selectFlightType(Integer id);
}
