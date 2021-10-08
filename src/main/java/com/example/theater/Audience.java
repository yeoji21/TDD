package com.example.theater;

public class Audience {

    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Audience() {
    }

    public long buy(Ticket ticket) {
         return bag.hold(ticket);
    }
}
