package org.generation.Repositories;

import java.util.List;

import org.generation.Models.brands;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface brandsRepository extends JpaRepository <brands, Long> {
    public List<brands> findAllByBrandNameContainingIgnoreCase (String brandName);
}