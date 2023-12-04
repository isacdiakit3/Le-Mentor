package com.mentor.Le_Mentor.services;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.nio.file.Path;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.mentor.Le_Mentor.models.Devoir;
import com.mentor.Le_Mentor.repository.DevoirRepository;

@Service
public class DevoirService {

    @Autowired
    private DevoirRepository devoirRepository;

    public Devoir creer(Devoir devoir, MultipartFile multipartFile) throws Exception {
        if (devoirRepository.findByTitre(devoir.getTitre()) == null) {
            if (multipartFile != null) {
                String location = "C:\\xampp\\htdocs\\le_mentor";
                try {
                    Path rootlocation = Paths.get(location);
                    if (!Files.exists(rootlocation)) {
                        Files.createDirectories(rootlocation);
                        Files.copy(multipartFile.getInputStream(),
                                rootlocation.resolve(multipartFile.getOriginalFilename()));
                        devoir.setPieceJointe("/le_mentor" + multipartFile.getOriginalFilename());
                    } else {
                        try {
                            String nom = location + "\\" + multipartFile.getOriginalFilename();
                            Path name = Paths.get(nom);
                            if (!Files.exists(name)) {
                                Files.copy(multipartFile.getInputStream(),
                                        rootlocation.resolve(multipartFile.getOriginalFilename()));
                                devoir.setPieceJointe("/le_mentor" + multipartFile.getOriginalFilename());
                            } else {
                                Files.delete(name);
                                Files.copy(multipartFile.getInputStream(),
                                        rootlocation.resolve(multipartFile.getOriginalFilename()));
                                devoir.setPieceJointe(
                                        "http://localhost/le_mentor" + multipartFile.getOriginalFilename());
                            }
                        } catch (Exception e) {
                            throw new Exception("error");
                        }
                    }
                } catch (Exception e) {
                    throw new Exception(e.getMessage());
                }
            }
            devoir.setDate(LocalDate.now());
            return devoirRepository.save(devoir);

        } else {
            throw new Exception("ce devoir existe deja");
        }
    }

    public List<Devoir> lire() {
        return devoirRepository.findAll();
    }

    public Devoir rechercher(Long id) {
        return devoirRepository.findById(id).get();
    }

    public Devoir modifier(Long id, Devoir devoir) {
        return devoirRepository.findById(id).map(d -> {
            d.setTitre(devoir.getTitre());
            d.setDescription(devoir.getDescription());
            d.setPieceJointe(devoir.getPieceJointe());
            d.setDateLimite(devoir.getDateLimite());
            d.setPoint(devoir.getPoint());
            d.setDate(devoir.getDate());
            return devoirRepository.save(d);
        }).orElseThrow(() -> new RuntimeException("Devoir non trouvé"));
    }

    public String supprimer(Long id) {
        devoirRepository.deleteById(id);
        return "Suppression effectuée";
    }
}
