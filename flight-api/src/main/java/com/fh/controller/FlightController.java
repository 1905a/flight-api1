package com.fh.controller;

import com.fh.code.ServerResponse;
import com.fh.model.*;
import com.fh.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("FlightController")
public class FlightController {


    @Autowired
    private FlightService flightService;


    @RequestMapping("selectFlightList")
    public ServerResponse selectFlightList(FlightQuery flightQuery){
        DataTableResult dataTableResult = flightService.selectFlightList(flightQuery);
        return ServerResponse.success(dataTableResult);
    }

    @RequestMapping("selectFlightType")
    public ServerResponse selectFlightType(){
        List<PlaneType> planeTypeList = flightService.selectFlightType();
        return ServerResponse.success(planeTypeList);
    }


    @RequestMapping("selectBeginArea")
    public ServerResponse selectBeginArea(){
        List<Area> areaList = flightService.selectBeginArea();
        return ServerResponse.success(areaList);
    }

    //新增  addFlight
    @RequestMapping("addFlight")
    public ServerResponse addFlight(Flight flight){
        flightService.addFlight(flight);
        return ServerResponse.success();
    }


}
