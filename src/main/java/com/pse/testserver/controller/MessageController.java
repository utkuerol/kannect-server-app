package com.pse.testserver.controller;

import com.pse.testserver.entities.Message;
import com.pse.testserver.entities.User;
import com.pse.testserver.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan(basePackages = "com.pse.testserver.service")
@RequestMapping
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping("/receivedMessages")
    @ResponseBody
    public List<Message> getReceivedMessages(@RequestBody User user) {
        //messageService.getMessagesByReceiver(user);
        return null;
    }

    @GetMapping("/sentMessages")
    @ResponseBody
    public List<Message> getSentMessages(@RequestBody User user) {
        //messageService.getMessagesBySender(user);
        return null;
    }

    @PostMapping("/sendMessage")
    public void sendMessage(@RequestBody User sender, @RequestBody User receiver) {
        //messageService.sendMessage(sender, receiver)
    }
}
