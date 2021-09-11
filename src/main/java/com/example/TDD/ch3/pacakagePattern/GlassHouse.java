package com.example.TDD.ch3.pacakagePattern;

public class GlassHouse extends HouseTemplate {

    @Override
    protected void buildWalls() {
        System.out.println("Building Glass Walls");
    }

    @Override
    protected void buildPattern() {
        System.out.println("Building Pillars with glass coating");
    }
}
