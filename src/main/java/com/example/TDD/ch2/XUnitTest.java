package com.example.TDD.ch2;

public class XUnitTest {
    public static void main(String[] args) {
        new TestCaseTest("testTemplateMethod").run();
        new TestCaseTest("testResult").run();
        new TestCaseTest("testFailedResultFormatting").run();
        new TestCaseTest("testFailedResult").run();
    }
}
