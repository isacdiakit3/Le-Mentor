package com.mentor.Newton_Universe.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.mentor.Newton_Universe.ApiResponse;
import com.mentor.Newton_Universe.models.Etudiant;
import com.mentor.Newton_Universe.repository.EtudiantRepository;
import org.springframework.stereotype.Service;


@Service
public class EtudiantService {
    @Autowired
  private  EtudiantRepository etudiantRepository;


  public Etudiant inscrire(Etudiant etudiant){
    return etudiantRepository.save(etudiant);
  }

  public List<Etudiant> lire(){
    return etudiantRepository.findAll();
  }

  public Etudiant rechercher(Long id){
    return etudiantRepository.findById(id).get();
  }

  public Etudiant modifier(Long id, Etudiant etudiant){
    
    return etudiantRepository.findById(id).map(e -> {
        e.setPrenom(etudiant.getPrenom());
        e.setNom(etudiant.getNom());
        e.setEmail(etudiant.getEmail());
        e.setVille(etudiant.getVille());
        e.setPhoto(etudiant.getPhoto());
        e.setPassword(etudiant.getPassword());
        return etudiantRepository.save(e);
    }).orElseThrow(()-> new RuntimeException("Eleve non trouvé"));
  }

  public String supprimer(Long id){
    etudiantRepository.deleteById(id);
    return "suppression effetuée";
  }


  public ApiResponse login(String email, String password){
    Etudiant etudiant =etudiantRepository.findByEmail(email);
    if(etudiant ==null){
        return new ApiResponse(200, "email incorrect !!!", null);
    }
    if(!etudiant.getPassword().equals(password)){
        return new ApiResponse(200, "mot de passe incorrect", null);
    }
    return new ApiResponse(200, "login succès", etudiant);
  }
}
