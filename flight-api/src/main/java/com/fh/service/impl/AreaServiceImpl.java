package com.fh.service.impl;

import com.fh.mapper.AreaMapper;
import com.fh.mapper.FlightMapper;
import com.fh.model.Area;
import com.fh.model.FlightTicket;
import com.fh.model.FlightTicketType;
import com.fh.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaMapper areaMapper;

    @Override
    public List<Area> selectAirPortByPid(Integer pid) {

        return areaMapper.selectAirPortByPid(pid);
    }

    @Override
    public List<FlightTicketType> selectFlightTicketType() {
        return areaMapper.selectFlightTicketType();
    }

    @Override
    public List<FlightTicket> selectFlightType(Integer id) {
        return areaMapper.selectFlightType(id);
    }
}
