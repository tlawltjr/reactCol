package com.fullstack.react.repository;

import com.fullstack.react.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<TodoEntity, String> {
}
