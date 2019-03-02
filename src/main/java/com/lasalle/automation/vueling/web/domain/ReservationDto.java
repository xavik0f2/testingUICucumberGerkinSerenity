package com.lasalle.automation.vueling.web.domain;

public class ReservationDto {

    private String origin;
    private String destination;
    private String outbound;
    private int passengers;

    public ReservationDto(){

    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOutbound() {
        return outbound;
    }

    public void setOutbound(String outbound) {
        this.outbound = outbound;
    }

    public int getPassengers() { return passengers;}

    public void setPassengers(int passengers){ this.passengers = passengers;}


}
