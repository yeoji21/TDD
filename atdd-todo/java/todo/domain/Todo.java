package jpabasic.atdd.todo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@EqualsAndHashCode
@Getter
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @EqualsAndHashCode.Exclude
    private String content;

    public static Todo of(String content) {
        Todo todo = new Todo();
        todo.content = content;
        return todo;
    }

    public static Todo of(long l, String content) {
        Todo todo = new Todo();
        todo.id = l;
        todo.content = content;
        return todo;
    }

    protected Todo() {
    }
}
