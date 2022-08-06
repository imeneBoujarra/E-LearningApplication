package com.example.test.controller;

import com.example.test.model.Cours;
import com.example.test.repository.CoursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class CoursController {
    @Autowired
    private CoursRepository coursRepository;


    @GetMapping("/cours")
    public List<Cours> getAllCours ()
    {
        return coursRepository.findAll() ;
}


    @GetMapping("/cours/{id_cours}")
    public Cours getById(@PathVariable Long id_cours)
    {
        return coursRepository.findById(id_cours).orElse(null);
    }

    @PostMapping("/cours")
    public Cours save(@RequestBody Cours cours )
    {
        return coursRepository.save(cours);
    }

    @DeleteMapping("cours/{id_cours}")
    public void delete(@PathVariable long id_cours)
    {
        coursRepository.deleteById(id_cours);
    }

    @PutMapping("/cours/{id_cours}")
    public Cours updatecours (@PathVariable Long id_cours , @RequestBody Cours newCours)
    { newCours.setId(id_cours);

        Cours f = coursRepository.findById(id_cours).orElse(null);

        Cours oldcours = coursRepository.findById(id_cours).orElse(null);
        newCours.setTitre(newCours.getTitre() == null ? oldcours.getTitre() : newCours.getTitre() );
        newCours.setDescription(newCours.getDescription() == null ? oldcours.getDescription() : newCours.getDescription() );
        newCours.setDateAjout(newCours.getDateAjout() == null ? oldcours.getDateAjout() : newCours.getDateAjout() );



        return coursRepository.save(newCours);

    }

}
