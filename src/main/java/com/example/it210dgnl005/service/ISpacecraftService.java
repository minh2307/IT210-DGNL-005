package com.example.it210dgnl005.service;

import com.example.it210dgnl005.model.Spacecraft;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.Optional;

public interface ISpacecraftService {
    Page<Spacecraft> findAll(Pageable pageable);
    Page<Spacecraft> search(String keyword, Pageable pageable );
    Spacecraft save(Spacecraft s);
    Optional<Spacecraft> findById(Long id);
    void delete(Long id);
}
