package com.pse.testserver.repository;

import com.pse.testserver.entities.Message;
import org.springframework.data.repository.CrudRepository;

/**
 * Simple interface which includes find methods related to message entity.
 * To perform these operations, methods of the spring framework are to be used.
 */

public interface MessageRepository extends CrudRepository<Message, Integer> {
    
    /**
     * Find message by id.
     *
     * @param id unique id of the searched message
     * @return message with the defined id
     */
    Message findById(long id);

}
