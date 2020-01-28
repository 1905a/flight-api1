package com.fh.mapper;


import com.fh.model.Area;
import com.fh.model.FlightTicket;
import com.fh.model.FlightTicketType;

import java.util.List;

public interface AreaMapper {


    List<Area> selectAirPortByPid(Integer pid);

    List<FlightTicketType> selectFlightTicketType();

    List<FlightTicket> selectFlightType(Integer id);
}
