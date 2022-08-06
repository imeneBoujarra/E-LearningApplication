package com.example.test.repository;


import com.example.test.model.Formation;
import com.example.test.model.Formatteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormationRepository extends JpaRepository<Formation ,Long>{

    @Query("SELECT f FROM Formation f WHERE f.nom = ?1")
    List<Formation> findFormationByName(String name );



    List<Formation> findFormationsByNiveau(String niveau);

    List<Formation> findFormationsByType(String type);
}
