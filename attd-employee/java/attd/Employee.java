package jpabasic.attd;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name ="employees")
@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
