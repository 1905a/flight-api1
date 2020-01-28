package com.fh.service.impl;

import com.fh.mapper.FlightMapper;
import com.fh.model.*;
import com.fh.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightMapper flightMapper;


    @Override
    public DataTableResult selectFlightList(FlightQuery flightQuery) {
        Long count = flightMapper.selectCount(flightQuery);

        List<Flight> flightList = flightMapper.selectFlightList(flightQuery);

        DataTableResult dataTableResult = new DataTableResult(flightQuery.getDraw(),count,count,flightList);

        return dataTableResult;
    }


    @Override
    public List<PlaneType> selectFlightType() {
        return flightMapper.selectFlightType();
    }

    @Override
    public List<Area> selectBeginArea() {
        return flightMapper.selectBeginArea();
    }

    @Override
    public void addFlight(Flight flight) {

        flightMapper.addFlight(flight);


        FlightTicket flightTicket = new FlightTicket();
        flightTicket.setFlightId(flight.getId());
        flightTicket.setType(flight.getTicketType());
        flightTicket.setTotalCount(flight.getTicketPriceCount());
        flightTicket.setTotalPrice(flight.getTicketPrice());

        flightMapper.addFlightTicket(flightTicket);

    }

    @Override
    public Flight selectFlightById(Integer id) {

        return flightMapper.selectFlightById(id);
    }
}
