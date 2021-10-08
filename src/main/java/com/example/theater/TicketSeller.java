package com.example.theater;

public class TicketSeller {

    private TicketOffice ticketOffice;

    public void sellTo(Audience audience) {
        Ticket ticket = ticketOffice.getTicket();
        audience.buy(ticket);
    }
}
