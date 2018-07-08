package com.pse.testserver.repository;

import com.pse.testserver.entities.Message;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Simple interface which includes find methods related to message entity.
 * To perform these operations, methods of the spring framework are to be used.
 */

public interface MessageRepository extends CrudRepository<Message, Integer> {
    
    /**
     * Find message by id from the database.
     *
     * @param id unique id of the searched message
     * @return message with the defined id
     */
    @Query("Select * from messages m where m.id like id")
    Message findById(@Param("id") long id);

}
