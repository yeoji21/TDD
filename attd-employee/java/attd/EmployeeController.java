package jpabasic.attd;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final GreetingService greetingService;

    @GetMapping("/hello/{lastName}")
    public String greeting(@PathVariable String lastName) {
        return greetingService.greet(lastName);
    }

}
