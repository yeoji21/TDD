package com.example.theater;

import java.util.ArrayList;
import java.util.List;

public class TicketOffice {

    private List<Ticket> tickets = new ArrayList<>();
    private long amount;

    public Ticket getTicket() {
        return tickets.get(0);
    }

    public void minusAmount(long amount) {
        this.amount -= amount;
    }

    public void plusAmount(long amount) {
        this.amount += amount;
    }
}
