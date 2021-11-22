package jpabasic.atdd.todo.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void save_and_get_and_delete(){
        Todo todoToSave = Todo.of(1L, "할 일");
        Todo savedTodo = todoRepository.save(todoToSave);
        assertThat(todoToSave).isEqualTo(savedTodo);

        assertThat(todoRepository.existsById(savedTodo.getId())).isTrue();

        todoRepository.deleteById(savedTodo.getId());
        assertThat(todoRepository.existsById(savedTodo.getId())).isFalse();
    }
}