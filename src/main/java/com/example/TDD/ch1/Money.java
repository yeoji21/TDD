package com.example.TDD.ch1;

public class Money implements Expression {
    protected int amount;
    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    Money times(int multiplier) {
        return new Money(amount*multiplier, currency);
    }

    @Override
    public String toString() {
        return amount + " " + currency;
    }

    @Override
    public boolean equals(Object obj) {
        Money money = (Money) obj;
        return this.amount == money.amount
                && currency().equals(money.currency());
    }

    public String currency() {
        return currency;
    }


    public Expression plus(Money addend) {
        return new Sum(this, addend);
    }

    @Override
    public Money reduce(String to){
        return this;
    }
}
