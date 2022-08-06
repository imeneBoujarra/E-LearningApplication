package com.example.test.controller;


import com.example.test.model.Formation;
import com.example.test.model.Formatteur;
import com.example.test.repository.FormationRepository;
import com.example.test.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/formation")
public class FromationController {


    @Autowired
    private FormationRepository formationRepository ;
    @Autowired
    private StorageService storageService ;

    @GetMapping("")
    public List<Formation> getAllFormation ()
    {
        return formationRepository.findAll() ;
    }


    @GetMapping("/{id_formation}")
    public Formation getById(@PathVariable Long id_formation)
    {
        return formationRepository.findById(id_formation).orElse(null);
    }

    @PostMapping("")
    public Formation save(@RequestBody  Formation formation )
    {
        return formationRepository.save(formation);
    }


    @PostMapping("/img")
    public Formation saveImg(@RequestParam ("file")MultipartFile file , Formation f)
    {
        String newFileName  = storageService.CreateNameImage(file);
        f.setImage(newFileName);
        storageService.store(file,newFileName);
        return formationRepository.save(f);
    }


    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.loadFile(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }

    @DeleteMapping("/{id_formation}")
    public void delete(@PathVariable long id_formation)
    {
        formationRepository.deleteById(id_formation);
    }

    @PutMapping("/{id_formation}")
    public Formation updateFormation (@PathVariable Long id_formation , @RequestBody Formation newFormation)
    { newFormation.setId(id_formation);


        Formation oldFormation = formationRepository.findById(id_formation).orElse(null);
        newFormation.setNom(newFormation.getNom() == null ? oldFormation.getNom() : newFormation.getNom() );
        newFormation.setDate_end(newFormation.getDate_end()== null ? oldFormation.getDate_end() : newFormation.getDate_end() );
        newFormation.setDate_debut(newFormation.getDate_debut() == null ? oldFormation.getDate_debut() : newFormation.getDate_debut() );
        newFormation.setDescription(newFormation.getDescription() == null ? oldFormation.getDescription() : newFormation.getDescription() );
        newFormation.setPrice(newFormation.getPrice() == null ? oldFormation.getPrice() : newFormation.getPrice() );
        newFormation.setNiveau(newFormation.getNiveau() == null ? oldFormation.getNiveau() : newFormation.getNiveau() );
        newFormation.setType(newFormation.getType() == null ? oldFormation.getType() : newFormation.getType() );


        return formationRepository.save(newFormation);

    }

    @GetMapping("/findByName/{name}")
    public List <Formation> findFomationByName (@PathVariable String name)
    {
        return formationRepository.findFormationByName(name);
    }

    @GetMapping("/findByNiveau/{niveau}")
    public List <Formation> findFomationByNiveau (@PathVariable String niveau)
    {
        return formationRepository.findFormationsByNiveau(niveau);
    }

    @GetMapping("/findByType/{type}")
    public List <Formation> findFomationByType (@PathVariable String type)
    {
        return formationRepository.findFormationsByType(type);
    }




}
