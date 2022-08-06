package com.example.test.repository;

import com.example.test.model.Formatteur;
import com.example.test.model.Formatteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface FormateurRepository extends JpaRepository<Formatteur ,Long> {




    //chercher list Formatteurs par nom
    @Query("SELECT f FROM Formatteur f WHERE f.nom = ?1")
    List<Formatteur> findFormateurByName(String name );

    //chercher list Formatteurs par prenom
    @Query("SELECT f FROM Formatteur f WHERE f.prenom = ?1")
    List<Formatteur> findFroamteurByFirstName(String firstname );





}
