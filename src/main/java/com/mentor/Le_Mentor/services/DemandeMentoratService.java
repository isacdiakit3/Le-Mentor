package com.mentor.Le_Mentor.services;
import java.util.List;
import org.springframework.stereotype.Service;

import com.mentor.Le_Mentor.models.DemandeMentorat;
import com.mentor.Le_Mentor.repository.DemandeMentoratRepository;

@Service
public class DemandeMentoratService {
    

    private final DemandeMentoratRepository demandeMentoratRepository;
    
    public DemandeMentoratService(DemandeMentoratRepository demandeMentoratRepository) {
        this.demandeMentoratRepository = demandeMentoratRepository;
    }


    public DemandeMentorat creer(DemandeMentorat demandeMentorat){
        return demandeMentoratRepository.save(demandeMentorat);

    }

    public List<DemandeMentorat> lire(){
        return demandeMentoratRepository.findAll();
    }

    public DemandeMentorat rechercher(Long id){
        return demandeMentoratRepository.findById(id).get();
    }

    public DemandeMentorat modifier(Long id , DemandeMentorat demandeMentorat){
        return demandeMentoratRepository.findById(id).map(d->{
            d.setStatus(demandeMentorat.getStatus());
            d.setDate(demandeMentorat.getDate());
            return demandeMentoratRepository.save(d);
        }).orElseThrow(()-> new RuntimeException ( "demande non trouvé"));
    }

    public String supprimer(Long id){
        demandeMentoratRepository.deleteById(id);
        return "Suppression effectuée";
    }
}
