package com.example.test.controller;

import com.example.test.model.Etudiant;
import com.example.test.repository.EtudiantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {
    @Autowired
    private EtudiantRepository etudiantRepository;


    @GetMapping("")
    public List<Etudiant> getAllEtudiants ()
    {
        return etudiantRepository.findAll() ;
    }


    @GetMapping("/{id_etudiant}")
    public Etudiant getById(@PathVariable Long id_etudiant)
    {
        return etudiantRepository.findById(id_etudiant).orElse(null);
    }

    @PostMapping("")
    public Etudiant save(@RequestBody Etudiant etudiant )
    {
        return etudiantRepository.save(etudiant);
    }

    @DeleteMapping("/{id_etudiant}")
    public void delete(@PathVariable long id_etudiant)
    {
        etudiantRepository.deleteById(id_etudiant);
    }

    @PutMapping("/{id_etudiant}")
    public Etudiant updateetudiant (@PathVariable Long id_etudiant , @RequestBody Etudiant newEtudiant)
    { newEtudiant.setId(id_etudiant);

        Etudiant f = etudiantRepository.findById(id_etudiant).orElse(null);

        Etudiant oldEtudiant = etudiantRepository.findById(id_etudiant).orElse(null);
        newEtudiant.setNom(newEtudiant.getNom() == null ? oldEtudiant.getNom() : newEtudiant.getNom() );
        newEtudiant.setPrenom(newEtudiant.getPrenom()== null ? oldEtudiant.getPrenom() : newEtudiant.getPrenom() );
        newEtudiant.setAdresse(newEtudiant.getAdresse() == null ? oldEtudiant.getAdresse() : newEtudiant.getAdresse() );
        newEtudiant.setDateNaissance(newEtudiant.getDateNaissance() == null ? oldEtudiant.getDateNaissance() : newEtudiant.getDateNaissance() );
        newEtudiant.setEmail(newEtudiant.getEmail() == null ? oldEtudiant.getEmail() : newEtudiant.getEmail() );


        return etudiantRepository.save(newEtudiant);

    }


    @GetMapping("/findByName/{nom}")
    public List <Etudiant> searchStudentByName (@PathVariable String nom )
    {
        return etudiantRepository.findStudentByName(nom);
    }


    @GetMapping("/findByFirstName/{prenom}")
    public List <Etudiant> searchStudentByFirstName (@PathVariable String prenom )
    {
        return etudiantRepository.findStudentByFirstName(prenom);
    }





}
