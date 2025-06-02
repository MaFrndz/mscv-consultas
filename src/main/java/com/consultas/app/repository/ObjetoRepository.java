package com.consultas.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.consultas.app.model.Tarea;

public interface ObjetoRepository extends MongoRepository<Tarea, String> {
}
