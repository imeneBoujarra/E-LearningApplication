package com.example.test.repository;

import com.example.test.model.Cours;
import com.example.test.model.Etudiant;
import com.example.test.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository

public interface CoursRepository extends JpaRepository<Cours ,Long> {





}
