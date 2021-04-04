package com.prueba.demo.service;

import com.prueba.demo.models.UsuarioModels;
import com.prueba.demo.repositories.UsuarioRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServicio {

    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList<UsuarioModels> obtenerUsuarios() {

        return (ArrayList<UsuarioModels>) usuarioRepository.findAll();

    }

    public UsuarioModels guardarUsuario(UsuarioModels usuario) {

        return usuarioRepository.save(usuario);
    }

    public boolean eliminarUsuario(Long idUsuario) {
        try {
            usuarioRepository.deleteById(idUsuario);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}
