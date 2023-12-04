package com.mentor.Le_Mentor.services;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mentor.Le_Mentor.models.Devoir;
import com.mentor.Le_Mentor.models.Message;
import com.mentor.Le_Mentor.repository.MessageRepository;

@Service
public class MessageService {
    
    @Autowired
    private MessageRepository messageRepository;


    public Message creer(Message message, MultipartFile multipartFile) throws Exception {
        if (multipartFile != null) {
                String location = "C:\\xampp\\htdocs\\le_mentor";
                try {
                    Path rootlocation = Paths.get(location);
                    if (!Files.exists(rootlocation)) {
                        Files.createDirectories(rootlocation);
                        Files.copy(multipartFile.getInputStream(),
                                rootlocation.resolve(multipartFile.getOriginalFilename()));
                        message.setPieceJointe("/le_mentor" + multipartFile.getOriginalFilename());
                    } else {
                        try {
                            String nom = location + "\\" + multipartFile.getOriginalFilename();
                            Path name = Paths.get(nom);
                            if (!Files.exists(name)) {
                                Files.copy(multipartFile.getInputStream(),
                                        rootlocation.resolve(multipartFile.getOriginalFilename()));
                                message.setPieceJointe("/le_mentor" + multipartFile.getOriginalFilename());
                            } else {
                                Files.delete(name);
                                Files.copy(multipartFile.getInputStream(),
                                        rootlocation.resolve(multipartFile.getOriginalFilename()));
                                message.setPieceJointe(
                                        "http://localhost/le_mentor" + multipartFile.getOriginalFilename());
                            }
                        } catch (Exception e) {
                            throw new Exception("error");
                        }
                    }
                } catch (Exception e) {
                    throw new Exception(e.getMessage());
                }
            }
            return messageRepository.save(message);
    }

    public List<Message> lire(){
        return messageRepository.findAll();
    }

    public List<Message> getListByClasse(Long id){
        return messageRepository.findByClasseId(id);
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
