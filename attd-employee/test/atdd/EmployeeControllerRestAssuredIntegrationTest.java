package jpabasic.atdd;


import io.restassured.specification.RequestSpecification;
import jpabasic.attd.Employee;
import jpabasic.attd.EmployeeApplication;
import jpabasic.attd.EmployeeRepository;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT,
        classes = EmployeeApplication.class
)
public class EmployeeControllerRestAssuredIntegrationTest {
    @Autowired
    private EmployeeRepository repository;

    private RequestSpecification basicRequest;

    @BeforeEach
    public void setUp() {
        basicRequest = given().baseUri("http://localhost").port(8080);
        repository.deleteAll();
        repository.save(new Employee("Yeo", "Jiwon"));
    }

    @Test
    public void should_return_default_message_when_last_name_not_found() {
        String nonExistingLastName = "nonExistingLastName";
        String expectedMessage = "Who is this " + nonExistingLastName + " you're talking about?";
        given().spec(basicRequest).basePath("/api/hello/" + nonExistingLastName)
                .when().get()
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .body(is(expectedMessage));
    }

    @Test
    public void should_return_greeting_message_when_las_name_found(){
        String existingLastName = "Jiwon";
        String expectedMessage = "Hello Yeo Jiwon!";

        given().spec(basicRequest).basePath("/api/hello/" + existingLastName)
                .when().get()
                .then().log().body()
                .statusCode(HttpStatus.SC_OK)
                .body(is(expectedMessage));
    }
}
