package jpabasic.atdd.todo.service;

import jpabasic.atdd.todo.domain.Todo;
import jpabasic.atdd.todo.domain.TodoRepository;
import jpabasic.atdd.todo.dto.TodoRequest;
import jpabasic.atdd.todo.dto.TodoResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TodoServiceImplTest {

//    private TodoService todoService;
//    private TodoRepository todoRepository;
//
//    @BeforeEach
//    void setUp() {
//        todoRepository = mock(TodoRepository.class);
//        todoService = new TodoServiceImpl(todoRepository);
//    }
//    @BeforeEach
//    void setUp() {
//        todoRepository = mock(TodoRepository.class);
//        todoService = new TodoServiceImpl(todoRepository);
//    }

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoServiceImpl todoService;


    @Test
    public void getTodos(){
        List<Todo> todos = List.of(Todo.of(1L, "할 일"));
        when(todoRepository.findAll()).thenReturn(todos);
        List<TodoResponse> todoResponses = todoService.getTodos();
        assertThat(todoResponses).hasSize(todos.size());
        verify(todoRepository).findAll();
    }

    @Test
    public void saveTodo(){
        TodoRequest request = TodoRequest.of("할일");
        when(todoRepository.save(Todo.of(request.getContent()))).thenReturn(Todo.of(1L, request.getContent()));
        TodoResponse response = todoService.saveTodo(request);
        assertThat(response).isNotNull();
    }
}