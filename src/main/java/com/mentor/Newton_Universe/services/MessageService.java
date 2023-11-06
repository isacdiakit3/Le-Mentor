package com.mentor.Newton_Universe.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.Newton_Universe.models.Message;
import com.mentor.Newton_Universe.repository.MessageRepository;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;


    public Message creer(Message message){
        return messageRepository.save(message);
    }

    public List<Message> lire(){
        return messageRepository.findAll();
    }

    public Message rechercher(Long id){
        return messageRepository.findById(id).get();
    }

    public Message modifier(Long id , Message message){
        return messageRepository.findById(id).map(m->{
            m.setContenu((message.getContenu()));
            m.setPieceJointe((message.getPieceJointe()));
            m.setDate(message.getDate());
            return messageRepository.save(m);
        }).orElseThrow(()-> new RuntimeException("message non trouvé"));
    }

    public String supprimer(Long id){
        messageRepository.deleteById(id);
        return "Suppression effectuée";
    }
}
