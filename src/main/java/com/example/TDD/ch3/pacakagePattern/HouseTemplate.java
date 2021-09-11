package com.example.TDD.ch3.pacakagePattern;

public abstract class HouseTemplate {

    public final void buildHouse(){
        buildFoundation();
        buildPattern();
        buildWalls();
        buildWindows();
        System.out.println("House is built");
    }

    private void buildFoundation() {
        System.out.println("Building foundation with cement, iron and sand");
    }

    protected abstract void buildWalls();

    protected abstract void buildPattern();

    private void buildWindows(){
        System.out.println("Building Class Windows");
    }



}
