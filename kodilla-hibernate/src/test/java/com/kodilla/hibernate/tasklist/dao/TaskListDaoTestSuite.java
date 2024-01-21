package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Transactional
    @Test
    void testFindByListName() {
        // Given
        String listName = "Test List Name";
        String description = "Test Description";
        TaskList taskList = new TaskList();
        taskList.setListName(listName);
        taskList.setDescription(description);
        taskListDao.save(taskList);

        // When
        List<TaskList> readTaskLists = taskListDao.findByListName(listName);

        // Then
        assertEquals(1, readTaskLists.size());
        assertEquals(listName, readTaskLists.get(0).getListName());
        assertEquals(description, readTaskLists.get(0).getDescription());

        // CleanUp
        taskListDao.deleteAll();
    }
}