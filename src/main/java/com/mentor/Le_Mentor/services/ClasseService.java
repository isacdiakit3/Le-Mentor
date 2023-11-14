package com.mentor.Le_Mentor.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentor.Le_Mentor.models.Classe;
import com.mentor.Le_Mentor.repository.ClasseRepository;

@Service
public class ClasseService {
    

    @Autowired
    private ClasseRepository classeRepository ;


    public Classe creer(Classe classe){
        return classeRepository.save(classe);
    }

    public List<Classe> lire(){
        return classeRepository.findAll();
    }

    public Classe rechercher(Long id){
        return classeRepository.findById(id).get();
    }

    public Classe modifier(Long id , Classe classe){
        return classeRepository.findById(id).map(c ->{
            c.setFiliere(classe.getFiliere());
            c.setSalle(classe.getSalle());
            c.setEffectif(classe.getEffectif());
            c.setImage(classe.getImage());
            return classeRepository.save(c);
        }).orElseThrow(()-> new RuntimeException("classe non trouvée"));
    }

    public String supprimer(Long id){
        classeRepository.findById(id);
        return "Suppression effectuée";
    }

}
