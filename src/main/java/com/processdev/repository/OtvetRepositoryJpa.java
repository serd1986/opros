package com.processdev.repository;

import com.processdev.entity.Otvet;
import com.processdev.model.Rayon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OtvetRepositoryJpa extends JpaRepository<Otvet, Integer> {

    List<Otvet> findAll();
    Otvet getById(Integer id);
    List<Otvet> getByRayon(Rayon rayon);
}