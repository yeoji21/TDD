package jpabasic.atdd.todo.api;

import jpabasic.atdd.todo.service.TodoService;
import jpabasic.atdd.todo.dto.TodoRequest;
import jpabasic.atdd.todo.dto.TodoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RequestMapping("/todos")
@RestController
public class TodoController {

    private final TodoService todoService;

    @GetMapping
    public ResponseEntity<List<TodoResponse>> getTodo() {
        List<TodoResponse> todoResponses = todoService.getTodos();
        return ResponseEntity.ok(todoResponses);
    }

    @PostMapping
    public ResponseEntity<TodoResponse> saveTodo(@RequestBody TodoRequest request){
        TodoResponse response = todoService.saveTodo(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return ResponseEntity.noContent().build();
    }
}
