package com.mentor.Newton_Universe.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.Newton_Universe.models.DemandeInscription;
import com.mentor.Newton_Universe.repository.DemandeInscriptionRepository;

@Service
public class DemandeInscriptionService {
    

    @Autowired
    private DemandeInscriptionRepository demandeInscriptionRepository;


    public DemandeInscription creer(DemandeInscription demandeInscription){
        return demandeInscriptionRepository.save(demandeInscription);
    }

    public List<DemandeInscription> lire(){
        return demandeInscriptionRepository.findAll();
    }

    public DemandeInscription rechercher(Long id){
        return demandeInscriptionRepository.findById(id).get();
    }

    public DemandeInscription modifier(Long id, DemandeInscription demandeInscription){
        return demandeInscriptionRepository.findById(id).map(d->{
            d.setStatus(demandeInscription.getStatus());
            d.setDate(demandeInscription.getDate());
            return demandeInscriptionRepository.save(d);
        }).orElseThrow(()-> new RuntimeException ("Demande non trouvée"));
    }

    public String supprimer(Long id){
        demandeInscriptionRepository.deleteById(id);
        return "Suppression effectuée";
    }

    

    
}
