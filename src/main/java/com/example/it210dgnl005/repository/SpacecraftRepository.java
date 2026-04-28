package com.example.it210dgnl005.repository;

import com.example.it210dgnl005.model.Spacecraft;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpacecraftRepository extends JpaRepository<Spacecraft, Long>{
    Page<Spacecraft> findByNameContainingIgnoreCaseOrSeriesContainingIgnoreCase(String name, String series, Pageable pageable);
}
