package com.example.test.repository;

import com.example.test.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface EtudiantRepository extends JpaRepository<Etudiant ,Long> {


    //chercher list etudiant par nom
    @Query("SELECT e FROM Etudiant e WHERE e.nom = ?1")
    List<Etudiant> findStudentByName(String name );

    @Query("SELECT e FROM Etudiant e WHERE e.prenom = ?1")
    List<Etudiant> findStudentByFirstName(String firstname );


}
