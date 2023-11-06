package com.mentor.Newton_Universe.controller;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mentor.Newton_Universe.ApiResponse;
import com.mentor.Newton_Universe.models.Admin;
import com.mentor.Newton_Universe.services.AdminService;

/**
 * AdminController
 */
@RestController
@RequestMapping("admin")
public class AdminController {

    private AdminService adminService;

    @PostMapping("/inscrire")
    public Admin inscrire(@RequestBody Admin admin){
        return adminService.inscrire(admin);
    }

    @GetMapping("")
    public List<Admin> lire(){
        return adminService.lire();
    }

    @GetMapping("/{id}")
    public Admin rechercher(@PathVariable Long id){
        return adminService.rechercher(id);
    }

    @PutMapping("/modifier/{id}")
    public Admin modifier(@PathVariable Long id , @RequestBody Admin admin){
        return adminService.modifier(id, admin);
    }

    @DeleteMapping("/supprimer/{id}")
    public String supprimer(@PathVariable Long id){
        return adminService.supprimer(id);
    }

    @PostMapping("/connexion")
    public ApiResponse connexion(@RequestParam String email , String password){
        return adminService.login(email, password);
    }
}