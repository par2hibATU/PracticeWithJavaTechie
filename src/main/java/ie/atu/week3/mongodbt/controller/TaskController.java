package ie.atu.week3.mongodbt.controller;


import ie.atu.week3.mongodbt.model.Task;
import ie.atu.week3.mongodbt.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @Autowired
    private TaskService taskService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task){
       return taskService.addTask(task);
    }

    @GetMapping
    public List<Task> getTasks(){
        return taskService.findAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable String taskId){
        return taskService.getTaskByTaskId(taskId);
    }

    @GetMapping("/severity/{severity}")
    public List<Task> findTaskUsingSeverity(@PathVariable int severity){
        return taskService.getTaskBySeverity(severity);
    }

    @GetMapping("/assignee/{assignee}")
    public List<Task> getTaskbyAssignee(@PathVariable String assignee){
        return taskService.getTaskByAssignee(assignee);
    }

    @PutMapping
    public Task modifyTask(@RequestBody Task task){
        return taskService.updateTask(task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable String taskId){
        return taskService.deleteTask(taskId);
    }
}
