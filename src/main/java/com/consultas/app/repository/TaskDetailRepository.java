package com.consultas.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.consultas.app.model.TaskDetail;

@Repository
public interface TaskDetailRepository extends MongoRepository<TaskDetail, String> {
}
