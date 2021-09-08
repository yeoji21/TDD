package com.example.TDD.ch2;

public class WasRun extends TestCase {
    public String log;

    public WasRun(String name) {
        super(name);
    }

    @Override
    public void setUp() {
        log = "setUp";
    }

    public void testMethod() {
        log += " testMethod";
    }

    public void testBrokenMethod(){
        throw new AssertionError();
    }

    @Override
    public void tearDown() {
        log += " tearDown";
    }
}
