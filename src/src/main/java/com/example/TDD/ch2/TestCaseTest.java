package com.example.TDD.ch2;

import com.example.TDD.ch2.annotation.Test;

public class TestCaseTest extends TestCase{
    public TestCaseTest(String name) {
        super(name);
    }

    TestResult result;

    public static TestSuite suite() {
        return new TestSuite(TestCaseTest.class);
    }

    @Override
    public void setUp() {
        result = new TestResult();
    }

    @Test
    public void testTemplateMethod(){
        WasRun wasRun = new WasRun("testMethod");
        wasRun.run(result);
        Assert.assertEquals("setUp testMethod tearDown",wasRun.log);
    }

    @Test
    public void testResult(){
        WasRun wasRun = new WasRun("testMethod");
        wasRun.run(result);
        Assert.assertEquals("1 run, 0 failed", result.getSummary());
    }

    @Test
    public void testFailedResultFormatting(){
        result.testStarted();
        result.testFailed();
        Assert.assertEquals("1 run, 1 failed", result.getSummary());
    }

    @Test
    public void testFailedResult(){
        WasRun wasRun = new WasRun("testBrokenMethod");
        wasRun.run(result);
        Assert.assertEquals("1 run, 1 failed", result.getSummary());
    }

    @Test
    public void testSuite(){
        TestSuite suite = new TestSuite();
        suite.add(new WasRun("testMethod"));
        suite.add(new WasRun("testBrokenMethod"));
        suite.run(result);
        Assert.assertEquals("2 run, 1 failed", result.getSummary());
    }
}
