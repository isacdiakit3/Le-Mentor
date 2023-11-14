package com.mentor.Le_Mentor.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.Le_Mentor.models.AssociationClasseEtudiant;
import com.mentor.Le_Mentor.models.Classe;
import com.mentor.Le_Mentor.models.Etudiant;
import com.mentor.Le_Mentor.repository.AssociationClasseEtudiantRepository;
import com.mentor.Le_Mentor.repository.ClasseRepository;
import com.mentor.Le_Mentor.repository.EtudiantRepository;

import jakarta.persistence.EntityNotFoundException;

import java.util.*;

@Service
public class AssociationClasseEtudiantService {
    
    @Autowired
    private AssociationClasseEtudiantRepository associationClasseEtudiantRepository;
    @Autowired
    private ClasseRepository classeRepository;
    @Autowired
    private EtudiantRepository etudiantRepository;

public String ajouterEtudiant(Long idClasse , List<Etudiant> etudiants) throws Exception{
    try{
        Classe classe = classeRepository.findClasseById(idClasse);
        etudiants.forEach((element) ->{
            AssociationClasseEtudiant association = new AssociationClasseEtudiant(null , classe , element);
            associationClasseEtudiantRepository.save(association);
        });
        return "succès";
    }catch(Exception e){
        throw new Exception(e.getMessage());
    }
}

public List<Etudiant> getEtudiants(Long idClasse){
    List<AssociationClasseEtudiant> list = associationClasseEtudiantRepository.findByClasseId(idClasse);
    List<Etudiant> etudiants = new ArrayList();
    if(!list.isEmpty()){
        list.forEach(element -> {
            etudiants.add(element.getEtudiant());
        });
        return etudiants;
    }else{
        throw new EntityNotFoundException("aucun etudiant trouvé");
    }
}

}
