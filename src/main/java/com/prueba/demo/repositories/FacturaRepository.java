package com.prueba.demo.repositories;

import com.prueba.demo.models.FacturaModels;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface FacturaRepository extends CrudRepository<FacturaModels, Long>{
    
}
