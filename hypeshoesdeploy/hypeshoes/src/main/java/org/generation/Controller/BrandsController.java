package org.generation.Controller;

import java.util.List;

import org.generation.Models.brands;
import org.generation.Repositories.brandsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/brands")
@CrossOrigin (origins = "*", allowedHeaders = "*")
public class BrandsController {

    @Autowired
    private brandsRepository repository;

    @GetMapping
    public ResponseEntity <List<brands>> getAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<brands> getById(@PathVariable long id){
        return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/brand/{brand}")
    public ResponseEntity<List<brands>> getByName(@PathVariable String brandName){
        return ResponseEntity.ok(repository.findAllByBrandNameContainingIgnoreCase(brandName));
    }

    @PostMapping
    public ResponseEntity<brands> postBrand(@RequestBody brands Brand){
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(Brand));
    }

    @PutMapping
    public ResponseEntity<brands> editBrand(@RequestBody brands Brand){
        return ResponseEntity.status(HttpStatus.OK).body(repository.save(Brand));
    }

    @DeleteMapping ("/{id}")
    public void deleteById(@PathVariable long id){
        repository.deleteById(id);
    }
    
}
