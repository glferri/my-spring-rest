/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.repos;

import demo.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author nat
 */
public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
