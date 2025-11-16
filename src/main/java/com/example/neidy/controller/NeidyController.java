package com.example.neidy.controller;

import com.example.neidy.model.Neidy;
import com.example.neidy.repository.NeidyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/neidy")
@CrossOrigin(origins = "*")
public class NeidyController {

    private final NeidyRepository repo;

    public NeidyController(NeidyRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Neidy> getAll() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Neidy> getOne(@PathVariable Long id) {
        return repo.findById(id);
    }

    @PostMapping
    public Neidy create(@RequestBody Neidy n) {
        return repo.save(n);
    }

    @PutMapping("/{id}")
    public Neidy update(@PathVariable Long id, @RequestBody Neidy n) {
        n.setId(id);
        return repo.save(n);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
