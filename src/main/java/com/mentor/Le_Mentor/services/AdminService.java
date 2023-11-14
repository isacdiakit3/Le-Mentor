package com.mentor.Le_Mentor.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mentor.Le_Mentor.ApiResponse;
import com.mentor.Le_Mentor.models.Admin;
import com.mentor.Le_Mentor.models.DemandeMentorat;
import com.mentor.Le_Mentor.models.Mentor;
import com.mentor.Le_Mentor.repository.AdminRepository;
import com.mentor.Le_Mentor.repository.MentorRepository;

import jakarta.persistence.EntityNotFoundException;



@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
    private MentorRepository mentorRepository;


    public Admin inscrire(Admin admin){
        return adminRepository.save(admin);
    }

    public List<Admin> lire(){
    return adminRepository.findAll();
    }

    public Admin rechercher(Long id){
        return adminRepository.findById(id).get();
    }

    public Admin modifier(Long id , Admin admin){
        return adminRepository.findById(id).map(a -> {
            a.setPrenom(admin.getPrenom());
            a.setNom(admin.getNom());
            a.setPseudo(admin.getPseudo());
            a.setEmail(admin.getEmail());
            a.setPassword(admin.getPassword());
            return adminRepository.save(a);
        }).orElseThrow(() -> new RuntimeException("Admin non trouvé"));
    }

    public String supprimer(Long id){
        adminRepository.deleteById(id);
        return "Suppression effectuée";
    }

    public ApiResponse login(String email , String password){
        Admin admin = adminRepository.findByEmail(email);
        if (admin==null) {
            return new ApiResponse(200 , "email incorrect !!!", null);
            
        }
        if (!admin.getPassword().equals(password)) {
            return new ApiResponse(200, "mot de passe incorrect !!!", null);
        }
        return new ApiResponse(200 , "login succès", admin);
    }

    
    
    
}
