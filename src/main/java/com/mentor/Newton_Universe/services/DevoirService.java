package com.mentor.Newton_Universe.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.Newton_Universe.models.Devoir;
import com.mentor.Newton_Universe.repository.DevoirRepository;

@Service
public class DevoirService {
    

    @Autowired
    private DevoirRepository devoirRepository;

    public Devoir creer(Devoir devoir){
        return devoirRepository.save(devoir);
    }

    public List<Devoir> lire(){
        return devoirRepository.findAll();
    }

    public Devoir rechercher(Long id){
        return devoirRepository.findById(id).get();
    }

    public Devoir modifier(Long id , Devoir devoir){
        return devoirRepository.findById(id).map(d->{
            d.setTitre(devoir.getTitre());
            d.setDescription(devoir.getDescription());
            d.setPieceJointe(devoir.getPieceJointe());
            d.setDateLimite(devoir.getDateLimite());
            d.setPoint(devoir.getPoint());
            d.setDate(devoir.getDate());
            return devoirRepository.save(d);
        }).orElseThrow(()->new RuntimeException("Devoir non trouvé"));
    }

    public String supprimer(Long id){
        devoirRepository.deleteById(id);
        return "Suppression effectuée";
    }
}
