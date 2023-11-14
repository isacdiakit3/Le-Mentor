package com.mentor.Le_Mentor.services;
import java.util.List;
import org.springframework.stereotype.Service;

import com.mentor.Le_Mentor.models.Message;
import com.mentor.Le_Mentor.repository.MessageRepository;

@Service
public class MessageService {
    
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
