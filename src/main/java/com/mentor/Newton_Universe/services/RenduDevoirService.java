package com.mentor.Newton_Universe.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.mentor.Newton_Universe.models.RenduDevoir;
import com.mentor.Newton_Universe.repository.RenduDevoirRepository;

@Service
public class RenduDevoirService {
    
    @Autowired
    private RenduDevoirRepository renduDevoirRepository;


    public RenduDevoir creer(RenduDevoir renduDevoir){
        return renduDevoirRepository.save(renduDevoir);
    }

    public List<RenduDevoir> lire(){
        return renduDevoirRepository.findAll();
    }

    public RenduDevoir rechercher(Long id){
        return renduDevoirRepository.findById(id).get();
    }

    public RenduDevoir modifier(Long id , RenduDevoir renduDevoir){
        return renduDevoirRepository.findById(id).map(r->{
            r.setTitre(renduDevoir.getTitre());
            r.setPieceJointe(renduDevoir.getPieceJointe());
            r.setPoint(renduDevoir.getPoint());
            r.setDate(renduDevoir.getDate());
            return renduDevoirRepository.save(r);
        }).orElseThrow(()-> new RuntimeException("Non trouvé"));
    }

    public String supprimer(Long id){
        renduDevoirRepository.deleteById(id);
        return "Suppression effectuée";
    }
}
