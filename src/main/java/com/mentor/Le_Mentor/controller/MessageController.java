package com.mentor.Le_Mentor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.mentor.Le_Mentor.models.Classe;
import com.mentor.Le_Mentor.models.Etudiant;
import com.mentor.Le_Mentor.models.Message;
import com.mentor.Le_Mentor.services.ClasseService;
import com.mentor.Le_Mentor.services.MentorService;
import com.mentor.Le_Mentor.services.MessageService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("message")
public class MessageController {
    
    @Autowired
    private MessageService messageService;
    @Autowired
    private ClasseService classeService;
    @Autowired
    private MentorService mentorService;

    @PostMapping("/creerMessage")
    public ResponseEntity<Message> creerMessage(
            @Valid @RequestParam("message") String mString,
            @RequestParam(value ="pieceJointe") MultipartFile multipartFile) throws Exception {

        Message message = new Message();
        try{
            message = new JsonMapper().readValue(mString, Message.class);
        }catch(JsonProcessingException e){
            throw new Exception(e.getMessage());
        }
        Message savedMessage = messageService.creer(message,multipartFile);

        return new ResponseEntity<>(savedMessage, HttpStatus.CREATED);
    }

    @GetMapping("/messageClasse/{id}")
    public List<Message> getListByClasse(@PathVariable Long id){
        return messageService.getListByClasse(id);
    }
    
    // @PostMapping("/{mentorId}/{classeId}")
    // public Message creerMessage(@Valid @RequestBody Message message, @PathVariable Long mentorId ,@PathVariable Long classeId, @RequestParam(value = "pieceJointe") MultipartFile multipartFile) throws Exception{
    //     message.setMentor(mentorService.rechercher(mentorId));
    //     message.setClasse(classeService.rechercher(classeId));
    //     return messageService.creer(message,multipartFile);
    // }

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
