package com.example.TDD.ch1;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Money implements Expression{
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return amount == money.amount
                && currency().equals(money.currency());
    }

    static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    String currency() {
        return currency;
    }

    @Override
    public String toString() {
        return amount + " " + currency;

    }

    Expression plus(Money addend) {
        return new Money(amount + addend.amount, currency);
    }
}
