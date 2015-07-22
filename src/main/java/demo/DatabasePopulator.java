/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

/**
 *
 * @author nat
 */
import demo.entities.Todo;
import demo.repos.TodoRepository;
import java.util.Arrays;
import java.util.Date;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabasePopulator {

    @Autowired
    private TodoRepository todoRepository;

    @PostConstruct
    void init() {
        try {
            Todo t1 = new Todo("Task 1", new Date());
            Todo t2 = new Todo("Task 2", new Date());
            Todo t3 = new Todo("Task 3", new Date());
            this.todoRepository.save(Arrays.asList(t1, t2, t3));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
