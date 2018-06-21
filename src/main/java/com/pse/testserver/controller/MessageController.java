package com.pse.testserver.controller;

import com.pse.testserver.entities.Message;
import com.pse.testserver.entities.User;
import com.pse.testserver.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for the network communications regarding RESTful Http Requests mainly about the Message entity.
 * To perform these requests coming from the client, methods of the injected service class(es) are to be used.
 */
@RestController
@ComponentScan(basePackages = "com.pse.testserver.service")
@RequestMapping
public class MessageController {

    /**
     * Injected MessageService class dependency.
     */
    @Autowired
    private MessageService messageService;

    /**
     * Get requests with the "/receivedMessages" suffix are mapped to this method.
     * Gets all messages, which are received by the given user.
     *
     * @param receiver user, whose received messages are to be fetched.
     * @return list of messages.
     */
    @GetMapping("/receivedMessages")
    @ResponseBody
    public List<Message> getReceivedMessages(@RequestBody User receiver) {

        return messageService.getAllByReceiverSortedByDate(receiver);
    }

    /**
     * Get requests with the "/sentMessages" suffix are mapped to this method.
     * Gets all messages, which are sent by the given user.
     *
     * @param sender user, whose sent messages are to be fetched.
     * @return list of messages.
     */
    @GetMapping("/sentMessages")
    @ResponseBody
    public List<Message> getSentMessages(@RequestBody User sender) {
        return messageService.findAllBySenderSortedByDate(sender);

    }

    /**
     * Post requests with the "/sendMessage" suffix are mapped to this method.
     * Saves the given message to the system.
     * @param message to be saved, received from the client
     */
    @PostMapping("/sendMessage")
    public void sendMessage(@RequestBody Message message) {
        messageService.sendMessage(message);
    }
}
