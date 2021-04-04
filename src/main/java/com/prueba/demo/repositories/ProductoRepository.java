package com.prueba.demo.repositories;

import com.prueba.demo.models.ProductoModels;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductoRepository extends CrudRepository <ProductoModels, Long>{
    
}
