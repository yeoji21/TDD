package jpabasic.atdd.todo.service;

import jpabasic.atdd.todo.dto.TodoRequest;
import jpabasic.atdd.todo.dto.TodoResponse;

import java.util.List;

public interface TodoService {
    List<TodoResponse> getTodos();

    TodoResponse saveTodo(TodoRequest request);

    void deleteTodo(Long id);
}
