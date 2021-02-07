package com.processdev.controller;

import com.processdev.entity.Otvet;
import com.processdev.repository.OtvetRepositoryJpa;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("otvet")
public class OtvetController {

   private final OtvetRepositoryJpa otvetService;

    @Autowired
    public OtvetController(OtvetRepositoryJpa otvetService) {
        this.otvetService = otvetService;
    }

    @GetMapping
    public List<Otvet> list() {
        return otvetService.findAll();
    }

    @GetMapping("{id}")
    public Otvet getOne(@PathVariable("id") Otvet otvet) {
        return otvet;
    }

    @PostMapping
    public Otvet create(@RequestBody Otvet otvet) {
        return otvetService.save(otvet);
    }

    @PutMapping("{id}")
    public Otvet update(@PathVariable("id") Otvet otvetFrobDb,
                        @RequestBody Otvet otvet) {
        BeanUtils.copyProperties(otvet, otvetFrobDb, "id");
        return otvetService.save(otvet);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Otvet otvet) {
        otvetService.delete(otvet);
    }
}