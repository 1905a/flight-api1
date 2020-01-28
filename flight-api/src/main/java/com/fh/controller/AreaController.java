package com.fh.controller;

import com.fh.model.Area;
import com.fh.model.FlightTicket;
import com.fh.model.FlightTicketType;
import com.fh.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("AreaController")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @RequestMapping("selectAirPortByPid")
    public List<Area> selectAirPortByPid(Integer pid){
        List<Area> areaList = areaService.selectAirPortByPid(pid);
        return areaList;
    }

    @RequestMapping("selectFlightTicketType")
    public List<FlightTicketType> selectFlightTicketType(){
        List<FlightTicketType> flightTickets = areaService.selectFlightTicketType();
        return flightTickets;
    }

    @RequestMapping("selectFlightType")
    public List<FlightTicket> selectFlightType(Integer id){
        List<FlightTicket> flightTickets = areaService.selectFlightType(id);
        return flightTickets;
    }

}
