package com.mentor.Le_Mentor.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentor.Le_Mentor.models.Message;
import com.mentor.Le_Mentor.services.MessageService;

@RestController
@RequestMapping("message")
public class MessageController {
    
    private MessageService messageService;

    @PostMapping("/creer")
    public Message creer(@RequestBody Message message){
        return messageService.creer(message);
    }

    @GetMapping("")
    public List<Message> lire(){
        return messageService.lire();
    }

    @GetMapping("/{id}")
    public Message rechercher(@PathVariable Long id){
        return messageService.rechercher(id);
    }

    @PutMapping("/modifier/{id}")
    public Message modifier(@PathVariable Long id , @RequestBody Message message){
        return messageService.modifier(id, message);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return messageService.supprimer(id);
    }
}
