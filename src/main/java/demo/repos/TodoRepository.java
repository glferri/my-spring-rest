/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.repos;

import demo.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 *
 * @author nat
 */
@PreAuthorize("hasRole('ROLE_USER')")
public interface TodoRepository extends JpaRepository<Todo, Integer> {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Override
    Todo save(Todo s);
}