package com.example.test.controller;

import com.example.test.model.Formatteur;
import com.example.test.repository.FormateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formateur")
public class FormateurController {

    @Autowired

    private FormateurRepository formateurRepository;


    @GetMapping("")
    public List<Formatteur> getAllFormatteurs ()
    {
        return formateurRepository.findAll() ;
    }


    @GetMapping("/{id_formateur}")
    public Formatteur getById(@PathVariable Long id_formateur)
    {
        return formateurRepository.findById(id_formateur).orElse(null);
    }

    @PostMapping("")
    public Formatteur save(@RequestBody Formatteur formateur )
    {
        return formateurRepository.save(formateur);
    }

    @DeleteMapping("/{id_formateur}")
    public void delete(@PathVariable long id_formateur)
    {
        formateurRepository.deleteById(id_formateur);
    }

    @PutMapping("/{id_formateur}")
    public Formatteur updateformateur (@PathVariable Long id_formateur , @RequestBody Formatteur newFormateur)
    { newFormateur.setId(id_formateur);


        Formatteur oldFormateur = formateurRepository.findById(id_formateur).orElse(null);
        newFormateur.setNom(newFormateur.getNom() == null ? oldFormateur.getNom() : newFormateur.getNom());
        newFormateur.setPrenom(newFormateur.getPrenom()== null ? oldFormateur.getPrenom() : newFormateur.getPrenom());
        newFormateur.setAdresse(newFormateur.getAdresse() == null ? oldFormateur.getAdresse() : newFormateur.getAdresse() );
        newFormateur.setDateNaissance(newFormateur.getDateNaissance() == null ? oldFormateur.getDateNaissance() : newFormateur.getDateNaissance() );
        newFormateur.setEmail(newFormateur.getEmail() == null ? oldFormateur.getEmail() : newFormateur.getEmail() );


        return formateurRepository.save(newFormateur);

    }

    @GetMapping("/findByFirstName")
    public List <Formatteur> searchStudentByFirstName (@PathVariable String prenom )
    {
        return formateurRepository.findFroamteurByFirstName(prenom);
    }

    @GetMapping("/findByName")
    public List <Formatteur> findFomateurByName (@PathVariable String name)
    {
        return formateurRepository.findFormateurByName(name);
    }



}
