package com.example.theater;

import lombok.Setter;

@Setter
public class Bag {
    private Ticket ticket;
    private Invitation invitation;
    private long amount;

    public Bag(Ticket ticket, Invitation invitation) {
        this.ticket = ticket;
        this.invitation = invitation;
    }

    public Bag() {
    }

    public boolean hasInvitation() {
        return invitation != null;
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    public void minusAmount(long amount) {
        this.amount -= amount;
    }

    public void plusAmount(long amount) {
        this.amount += amount;
    }

    public long hold(Ticket ticket) {
        if (hasInvitation())

    }
}
