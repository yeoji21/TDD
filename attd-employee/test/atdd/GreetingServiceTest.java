package jpabasic.atdd;

import jpabasic.attd.Employee;
import jpabasic.attd.EmployeeRepository;
import jpabasic.attd.GreetingService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.*;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(MockitoExtension.class)
class GreetingServiceTest {
    private GreetingService greetingService;
    @Mock private EmployeeRepository repository;
    private String nonExistingLastName = "nonExistingLastName";
    private String existingLastName = "existingLastName";
    private String firstName = "firstName";
    private String lastName = "lastName";

    @BeforeEach
    public void setUp() throws Exception{
        greetingService = new GreetingService(repository);
    }

    @Test
    public void greet_with_nonExisting_last_name_should_return_default_message(){
        given(repository.findByLastName(nonExistingLastName))
                    .willReturn(Optional.empty());
        String msg = greetingService.greet(nonExistingLastName);
        assertThat(msg, is("Who is this " + this.nonExistingLastName + " you're talking about?"));

    }

    @Test
    public void greet_with_existing_last_name_should_return_hello_message_with_appropriate_names(){
        given(repository.findByLastName(existingLastName))
                .willReturn(Optional.of(new Employee(firstName, lastName)));
        String msg1 = greetingService.greet(existingLastName);
        assertThat(msg1, is(String.format("Hello %s %s!", firstName, this.lastName)));
    }

}