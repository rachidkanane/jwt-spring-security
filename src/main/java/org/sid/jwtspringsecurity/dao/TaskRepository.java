package org.sid.jwtspringsecurity.dao;

import org.sid.jwtspringsecurity.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository  extends JpaRepository<Task,Long> {

}
