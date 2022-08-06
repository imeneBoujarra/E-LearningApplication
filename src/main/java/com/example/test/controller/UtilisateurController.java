package com.example.test.controller;

import com.example.test.model.Utilisateur;
import com.example.test.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UtilisateurController {


    @Autowired
    private UtilisateurRepository utilisateurRepository ;


    @PostMapping("")
    public Utilisateur login(@RequestBody Utilisateur u )
    {
       return utilisateurRepository.login(u.getEmail(),u.getPassword());

    }
}
