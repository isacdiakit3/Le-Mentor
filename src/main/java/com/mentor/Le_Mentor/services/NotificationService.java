package com.mentor.Le_Mentor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.Le_Mentor.models.Notification;
import com.mentor.Le_Mentor.repository.NotificationRepository;

import java.util.List;


@Service
public class NotificationService {
    

    @Autowired
    private NotificationRepository notificationRepository;

    public Notification creer(Notification notification){
        return notificationRepository.save(notification);
    }

    public List<Notification> lire(){
    return notificationRepository.findAll();
    }

    public Notification rechercher(Long id){
        return notificationRepository.findById(id).get();
    }

    public Notification modifier(Long id , Notification notification){
        return notificationRepository.findById(id).map(n->{
            n.setDestinateur(notification.getDestinateur());
            n.setContenu(notification.getContenu());
            n.setEtat(notification.isEtat());
            n.setDate(notification.getDate());
            return notificationRepository.save(n);
        }).orElseThrow(()-> new RuntimeException("non trouvée"));
    }

    public String supprimer(Long id){
        notificationRepository.deleteById(id);
        return "Suppression effectuée";
    }
}
