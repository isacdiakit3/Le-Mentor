package com.mentor.Le_Mentor.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.Le_Mentor.ApiResponse;
import com.mentor.Le_Mentor.models.Classe;
import com.mentor.Le_Mentor.models.DemandeMentorat;
import com.mentor.Le_Mentor.models.Mentor;
import com.mentor.Le_Mentor.repository.ClasseRepository;
import com.mentor.Le_Mentor.repository.DemandeMentoratRepository;
import com.mentor.Le_Mentor.repository.MentorRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MentorService {
    

    @Autowired
    private MentorRepository mentorRepository;
    @Autowired
    private DemandeMentoratRepository demandeMentoratRepository;
    @Autowired
    private ClasseRepository classeRepository;


    public Mentor inscrire(Mentor mentor){
        return mentorRepository.save(mentor);
    }

    public List<Mentor> Lire(){
        return mentorRepository.findAll();
    }

    public Mentor rechercher(Long id){
        return mentorRepository.findById(id).get();
    }

    public Mentor modifier(Long id , Mentor mentor){
        return mentorRepository.findById(id).map(m->{
            m.setPrenom(mentor.getPrenom());
            m.setNom(mentor.getNom());
            m.setEmail(mentor.getEmail());
            m.setPassword(mentor.getPassword());
            m.setQualification(mentor.getQualification());
            m.setCertificat(mentor.getCertificat());
            m.setPhoto(mentor.getPhoto());
            m.setDiplome(mentor.getDiplome());
            m.setApprouvee(mentor.isApprouvee());
            m.setVille(mentor.getVille());
            return mentorRepository.save(m);
        }).orElseThrow(()-> new RuntimeException("Mentor Non trouvé"));
    }

    public String supprimer(Long id){
        mentorRepository.deleteById(id);
        return "Suppression effectuée";
    }

    public ApiResponse login(String email , String password ){
        Mentor mentor = mentorRepository.findByEmail(email);
        if(mentor==null){
            return new ApiResponse(200, "email incorrect", null);
        }
        if (!mentor.getPassword().equals(password) || mentor.isApprouvee() != true) {
            return new ApiResponse(200, "mot de passe incorrect", null);
        }
            return new ApiResponse(200, "login succes", mentor);
    }
    // methode pour recuperer la liste des demandes acceptées
    public List<DemandeMentorat> getDemandeMentoratAcceptee(Long mentorId){
        String statusAcceptee = "acceptee";
        return demandeMentoratRepository.findByMentorIdAndStatusEquals(mentorId, statusAcceptee);
    }

    // methode pour recuperer la liste des demandes en attentes
    public List<DemandeMentorat> getDemandeMentoratAttente(Long mentorId){
        String statusAcceptee = "attente";
        return demandeMentoratRepository.findByMentorIdAndStatusEquals(mentorId, statusAcceptee);
    }

    // methode pour recuperer la liste des classes
    public List<Classe> getClasse(Long mentorId){
        return classeRepository.findByMentorId(mentorId);
    }

    //methode pour modifier le status de la demande a Accepter
    public String accepterDemande(Long demandeId){
        String status = "attente";
        DemandeMentorat demandeMentorat = demandeMentoratRepository.findByStatusAndId(status, demandeId);

        if(demandeMentorat != null){
            demandeMentorat.setStatus("acceptee");
            demandeMentoratRepository.save(demandeMentorat);
            return "succes";

        }else{
            throw new EntityNotFoundException("non trouvé");
        }
    }

    //methode pour modifier le status de la demande a Refuser
    public String refuserDemande(Long demandeId){
        String status = "attente";
        DemandeMentorat demandeMentorat = demandeMentoratRepository.findByStatusAndId(status, demandeId);

        if (demandeMentorat != null) {
            demandeMentorat.setStatus("refusee");
            demandeMentoratRepository.save(demandeMentorat);
            return "succes";
        }else{
            throw new EntityNotFoundException("invalid");
        }
    }

    public String accepterDemandeInscription(Long id){
        boolean approuvee = false;
        Mentor demandeInscription = mentorRepository.findByApprouveeAndId(approuvee, id);

        if(demandeInscription != null){
            demandeInscription.setApprouvee(true);
            mentorRepository.save(demandeInscription);
            return "succes";
        }else{
            throw new EntityNotFoundException("non trouvé");
        }
    }
}
