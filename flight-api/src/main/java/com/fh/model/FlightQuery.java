package com.fh.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class FlightQuery extends DataTablePageBean{

    private String flightName;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date beginTime;

    private Integer hasTicket;

    private Integer ticketType;

    private Integer planeSize;

    private Integer beginArea;

    private Integer endArea;

    public Integer getTicketType() {
        return ticketType;
    }

    public void setTicketType(Integer ticketType) {
        this.ticketType = ticketType;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Integer getHasTicket() {
        return hasTicket;
    }

    public void setHasTicket(Integer hasTicket) {
        this.hasTicket = hasTicket;
    }

    public Integer getPlaneSize() {
        return planeSize;
    }

    public void setPlaneSize(Integer planeSize) {
        this.planeSize = planeSize;
    }

    public Integer getBeginArea() {
        return beginArea;
    }

    public void setBeginArea(Integer beginArea) {
        this.beginArea = beginArea;
    }

    public Integer getEndArea() {
        return endArea;
    }

    public void setEndArea(Integer endArea) {
        this.endArea = endArea;
    }
}
