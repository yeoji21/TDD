package com.example.TDD.ch2;

public class XUnitTest {
    public static void main(String[] args) {
        TestSuite suite = TestCaseTest.suite();
        TestResult result = new TestResult();
        suite.run(result);

        TestSuite suite2 = new TestSuite();
        suite2.add(new TestCaseTest("testTemplateMethod"));
        suite2.add(suite);
        TestResult result2 = new TestResult();
        suite2.run(result2);
        System.out.println(result2.getSummary());

    }
}
