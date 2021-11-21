package jpabasic.attd;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GreetingService {

    private final EmployeeRepository repository;

    public String greet(String lastName) {
        return repository.findByLastName(lastName)
                .map(e -> String.format("Hello %s %s!", e.getFirstName(), e.getLastName()))
                .orElse("Who is this " + lastName + " you're talking about?");
    }
}
