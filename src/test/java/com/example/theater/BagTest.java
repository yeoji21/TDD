package com.example.theater;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BagTest {

    @Test
    void test(){
        Invitation invitation = new Invitation();
        Ticket ticket = new Ticket();

        Bag fullBag = new Bag(ticket, invitation);
        Bag emptyBag = new Bag();

        assertTrue(fullBag.hasInvitation());
        assertFalse(emptyBag.hasInvitation());

    }
}
