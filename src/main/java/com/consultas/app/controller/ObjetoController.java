package com.consultas.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consultas.app.model.Tarea;
import com.consultas.app.repository.ObjetoRepository;
import com.consultas.app.repository.TaskDetailRepository;

@RestController
@RequestMapping("/objetos")
public class ObjetoController {
    @Autowired
    private ObjetoRepository repository;

    @Autowired
    private TaskDetailRepository taskDetailRepository;

    @PostMapping
    public Tarea insertar(@RequestBody Tarea tarea) {
        return repository.save(tarea);
    }

    @GetMapping
    public List<Tarea> obtenerTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Tarea obtenerPorId(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping("/taskDetail/{id}")
    public String[] getTaskDetail(@PathVariable String id) {
        return taskDetailRepository.findById(id)
                .map(taskDetail -> taskDetail.getComents() != null ? taskDetail.getComents().toArray(new String[0])
                        : new String[0])
                .orElse(new String[0]);
    }

}
