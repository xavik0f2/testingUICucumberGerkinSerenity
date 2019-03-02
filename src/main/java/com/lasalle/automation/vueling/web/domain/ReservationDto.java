package com.lasalle.automation.vueling.web.domain;

public class ReservationDto {

    private String origin;
    private String destination;
    private String outbound;
    private String _return;
    private int passengers;

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

    public String getReturn() {
        return _return;
    }

    public void setReturn(String _return) {
        this._return = _return;
    }

    public int getPassengers() { return passengers;}

    public void setPassengers(int passengers){ this.passengers = passengers;}


}
