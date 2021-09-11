package com.example.TDD.ch3.pacakagePattern;

public class WoodenHouse extends HouseTemplate {

    @Override
    protected void buildWalls() {
        System.out.println("Building Wooden walls");
    }

    @Override
    protected void buildPattern() {
        System.out.println("Building Pillars with Wood coating");
    }
}
