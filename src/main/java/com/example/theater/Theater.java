package com.example.theater;

import lombok.Setter;

@Setter
public class Theater {

    private TicketSeller ticketSeller;

    public void enter(Audience audience) {
        ticketSeller.sellTo(audience);
    }
}
