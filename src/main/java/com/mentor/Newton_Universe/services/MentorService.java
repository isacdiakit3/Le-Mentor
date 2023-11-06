package com.mentor.Newton_Universe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.Newton_Universe.ApiResponse;
import com.mentor.Newton_Universe.models.Mentor;
import com.mentor.Newton_Universe.repository.MentorRepository;

import jakarta.persistence.OneToMany;

@Service
public class MentorService {
    

    @Autowired
    private MentorRepository mentorRepository;


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

    
}
