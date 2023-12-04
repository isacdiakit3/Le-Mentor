package com.mentor.Le_Mentor.services;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mentor.Le_Mentor.ApiResponse;
import com.mentor.Le_Mentor.models.Etudiant;
import com.mentor.Le_Mentor.repository.EtudiantRepository;


@Service
public class EtudiantService {
    @Autowired
  private  EtudiantRepository etudiantRepository;


  // public Etudiant inscrire(Etudiant etudiant){
  //   return etudiantRepository.save(etudiant);
  // }

  public Etudiant inscrire (Etudiant etudiant , MultipartFile multipartFile) throws Exception{
    if (etudiantRepository.findByEmail(etudiant.getEmail())==null) {
      if (multipartFile != null) {
        String location = "C:\\xampp\\htdocs\\le_mentor";
        try{
          Path rootlocation = Paths.get(location);
          if(!Files.exists(rootlocation)){
            Files.createDirectories(rootlocation);
            Files.copy(multipartFile.getInputStream(),rootlocation.resolve(multipartFile.getOriginalFilename()));
            etudiant.setPhoto("/le_mentor"+multipartFile.getOriginalFilename());
          }else{
            try {
              String nom = location+"\\"+multipartFile.getOriginalFilename();
              Path name = Paths.get(nom);
              if (!Files.exists(name)) {
                Files.copy(multipartFile.getInputStream(),rootlocation.resolve(multipartFile.getOriginalFilename()));
                etudiant.setPhoto("/le_mentor"+multipartFile.getOriginalFilename());
              }else{
                Files.delete(name);
                Files.copy(multipartFile.getInputStream(), rootlocation.resolve(multipartFile.getOriginalFilename()));
                etudiant.setPhoto("http://localhost/le_mentor"+multipartFile.getOriginalFilename());
              }
            }catch(Exception e){
              throw new Exception("error");
            }
          }
        }catch(Exception e){
          throw new Exception(e.getMessage());
        }
      }
      return etudiantRepository.save(etudiant);
      
    }else{
      throw new Exception("cette élève existe deja");
    }
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


  public Optional<Etudiant> connexion(String email, String password){
    return etudiantRepository.findByEmailAndPassword(email , password);
}
}
