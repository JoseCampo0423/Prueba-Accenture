package com.prueba.demo.controller;

import java.util.ArrayList;

import com.prueba.demo.models.UsuarioModels;
import com.prueba.demo.service.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")

public class UsuarioController {

    @Autowired

    UsuarioServicio usuarioServicio;

    @GetMapping()
    public ArrayList<UsuarioModels> obtenerUsuarios() {

        return usuarioServicio.obtenerUsuarios();

    }

    @PostMapping()
    public UsuarioModels guardarUsuario(@RequestBody UsuarioModels usuario) {

        return this.usuarioServicio.guardarUsuario(usuario);

    }

    @PutMapping()
    public UsuarioModels actualizarUsuario(@RequestBody UsuarioModels usuario) {

        return this.usuarioServicio.guardarUsuario(usuario);

    }

    @DeleteMapping(path = "/{idUsuario}")
    public String eliminarId(@PathVariable("idUsuario") Long idUsuario) {
        boolean ok = this.usuarioServicio.eliminarUsuario(idUsuario);
        if (ok) {
            return "Eliminar usuario con id " + idUsuario;
        } else {
            return "No elimino el usuario con id" + idUsuario;
        }
    }
}
