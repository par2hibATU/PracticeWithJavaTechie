package ie.atu.week3.mongodbt.repository;

import ie.atu.week3.mongodbt.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import javax.print.attribute.standard.Severity;
import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findBySeverity(int severity);

    @Query("{assignee:  ?0 }")
    List<Task> getTasksByAssignee(String assignee);
}
