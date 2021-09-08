package com.example.TDD.ch2;

import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.annotation.AnnotationUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
public class TestSuite implements Test{

    List<Test> tests = new ArrayList<>();

    @SneakyThrows
    public TestSuite(Class<? extends TestCase> testClass) {
        Arrays.stream(testClass.getMethods())
                .filter(m -> AnnotationUtils.findAnnotation(m, com.example.TDD.ch2.annotation.Test.class) != null)
                .forEach(m ->
                        {
                            try {
                                add(testClass.getConstructor(String.class).newInstance(m.getName()));
                            } catch (Exception e) {  throw new RuntimeException(e);}
                        }
                );
    }


    public void add(Test test) {
        tests.add(test);
    }

    public void run(TestResult result) {
        tests.forEach(t -> {
            t.run(result);
        });
    }
}
