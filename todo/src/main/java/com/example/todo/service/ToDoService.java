package com.example.todo.service;

import com.example.todo.model.ToDo;
import com.example.todo.repository.ToDoRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;


import java.util.List;

@Service
public class ToDoService {
    private final ToDoRepository repo;

    public ToDoService(ToDoRepository repo) {
        this.repo = repo;
    }

    public List<ToDo> getAll() {
        return repo.findAll();
    }

    public ToDo save(ToDo todo) {
        return repo.save(todo);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public boolean existsById(Long id) {
        return repo.existsById(id);
    }

    public ToDo update(Long id, ToDo updatedToDo) {
        Optional<ToDo> optionalToDo = repo.findById(id);
        if (optionalToDo.isPresent()) {
            ToDo existing = optionalToDo.get();
            existing.setTitle(updatedToDo.getTitle());
            existing.setCompleted(updatedToDo.isCompleted());
            return repo.save(existing);
        }
        return null;
    }

}
