package com.fh.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Flight {

    private Integer id;// 航班id

    private String name;// 航班名称

    private Integer typeTd;// 机型id

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date startTime;// 起飞时间

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date endTime;// 到大时间

    private Integer startTerminalId;// 出发机场航站楼id

    private Integer endTerminalId;// 到大机场航站楼id

    private String startDate;//

    private String endDate;//

    private Integer totalCount;//

    private Double price;// jiage





    private Integer ticketType;

    private Double ticketPrice;
    private Integer ticketPriceCount;

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public Integer getTicketPriceCount() {
        return ticketPriceCount;
    }

    public void setTicketPriceCount(Integer ticketPriceCount) {
        this.ticketPriceCount = ticketPriceCount;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Integer getTicketType() {
        return ticketType;
    }

    public void setTicketType(Integer ticketType) {
        this.ticketType = ticketType;
    }



    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeTd() {
        return typeTd;
    }

    public void setTypeTd(Integer typeTd) {
        this.typeTd = typeTd;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStartTerminalId() {
        return startTerminalId;
    }

    public void setStartTerminalId(Integer startTerminalId) {
        this.startTerminalId = startTerminalId;
    }

    public Integer getEndTerminalId() {
        return endTerminalId;
    }

    public void setEndTerminalId(Integer endTerminalId) {
        this.endTerminalId = endTerminalId;
    }
}
