package com.mentor.Newton_Universe.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.Newton_Universe.models.DemandeMentorat;
import com.mentor.Newton_Universe.repository.DemandeMentoratRepository;

@Service
public class DemandeMentoratService {
    

    @Autowired
    private DemandeMentoratRepository demandeMentoratRepository;


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
