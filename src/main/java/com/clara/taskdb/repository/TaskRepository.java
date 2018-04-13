package com.clara.taskdb.repository;

import com.clara.taskdb.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ce6915gp on 4/12/2018.
 */
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByOrderByUrgentDesc();

    /*Custom query for updating a Task object, setting the completed value
    * returns the number of rows modified,
    * so if the Task is found and updated, returns 1
    * If the Task with this id is not in the DB, no rows are updated, so returns 0 */
    @Transactional
    @Modifying
    @Query("Update Task t set t.completed = ?1 where t.id = ?2")
    int setTaskCompleted(boolean completed, long id);
}
