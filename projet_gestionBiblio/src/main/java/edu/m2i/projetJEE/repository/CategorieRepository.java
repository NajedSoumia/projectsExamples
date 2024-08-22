package edu.m2i.projetJEE.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.m2i.projetJEE.entity.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Integer> {

}
