package com.example.test.repository;

import com.example.test.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {



    @Query("SELECT f FROM Utilisateur f WHERE f.email = ?1 AND f.password = ?2")
    Utilisateur login(String email , String password);
}
