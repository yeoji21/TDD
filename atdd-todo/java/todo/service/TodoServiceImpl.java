package jpabasic.atdd.todo.service;

import jpabasic.atdd.todo.domain.Todo;
import jpabasic.atdd.todo.domain.TodoRepository;
import jpabasic.atdd.todo.dto.TodoRequest;
import jpabasic.atdd.todo.dto.TodoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Override
    public List<TodoResponse> getTodos() {
        return todoRepository.findAll().stream()
                .map(t -> TodoResponse.of(t.getId(), t.getContent()))
                .collect(Collectors.toList());
    }

    @Override
    public TodoResponse saveTodo(TodoRequest request) {
        Todo savedTodo = todoRepository.save(Todo.of(request.getContent()));
        return TodoResponse.of(savedTodo.getId(), savedTodo.getContent());
    }

    @Override
    public void deleteTodo(Long id) {

    }
}
