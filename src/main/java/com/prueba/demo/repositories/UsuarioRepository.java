package com.prueba.demo.repositories;

import com.prueba.demo.models.UsuarioModels;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository <UsuarioModels, Long>{
    
}
