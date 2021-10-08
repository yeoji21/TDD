package com.example.theater;

import org.junit.jupiter.api.Test;

public class TicketSellerTest {

    @Test
    void test(){
        //given
        Theater theater = new Theater();
        theater.setTicketSeller(new TicketSeller());


        Audience audience = new Audience();
        theater.enter(audience);


        //when

        //then
    }
}
