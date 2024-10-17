package ie.atu.week3.mongodbt.service;

import ie.atu.week3.mongodbt.model.Task;
import ie.atu.week3.mongodbt.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.attribute.standard.Severity;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task addTask(Task task){
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return taskRepository.save(task);
    }

    public List<Task> findAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskByTaskId(String taskId){
        return taskRepository.findById(taskId).get();
    }

    public List<Task> getTaskBySeverity(int severity){
        return taskRepository.findBySeverity(severity);
    }

    public List<Task> getTaskByAssignee(String assignee){
        return taskRepository.getTasksByAssignee(assignee);
    }

    public Task updateTask(Task task){
        Task existingTask =  taskRepository.findById(task.getTaskId()).get();
        existingTask.setDescription(task.getDescription());
        existingTask.setAssignee(task.getAssignee());
        existingTask.setAssignee(task.getAssignee());
        existingTask.setStoryPoint(task.getStoryPoint());
        return taskRepository.save(existingTask);
    }

    public String deleteTask(String taskId){
        taskRepository.deleteById(taskId);
         return taskId + "has been deleted";
    }
}
