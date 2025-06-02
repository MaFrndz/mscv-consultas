package com.consultas.app.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "taskdetail")
public class TaskDetail {
    @Id
    private String idTask;
    private List<String> coments;

    public TaskDetail() {}

    public TaskDetail(String idTask, List<String> coments) {
        this.idTask = idTask;
        this.coments = coments;
    }

    public String getIdTask() { return idTask; }
    public void setIdTask(String idTask) { this.idTask = idTask; }
    public List<String> getComents() { return coments; }
    public void setComents(List<String> coments) { this.coments = coments; }
}
