package com.example.it210dgnl005.service.impl;

import com.example.it210dgnl005.model.Spacecraft;
import com.example.it210dgnl005.repository.SpacecraftRepository;
import com.example.it210dgnl005.service.ISpacecraftService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpacecraftServiceImpl implements ISpacecraftService {
    private final SpacecraftRepository repo;

    @Override
    public org.springframework.data.domain.Page<Spacecraft> findAll(Pageable pageable) {
        return repo.findAll(pageable);
    }

    @Override
    public Page<Spacecraft> search(String keyword, Pageable pageable) {
        return repo.findByNameContainingIgnoreCaseOrSeriesContainingIgnoreCase(
                keyword, keyword, pageable
        );
    }

    @Override
    public Spacecraft save(Spacecraft s) {
        return repo.save(s);
    }

    @Override
    public Optional<Spacecraft> findById(Long id) {
        return repo.findById(id);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}

