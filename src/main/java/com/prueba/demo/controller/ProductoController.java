package com.prueba.demo.controller;

import com.prueba.demo.models.ProductoModels;
import java.util.ArrayList;

import com.prueba.demo.service.ProductoServicio;
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
@RequestMapping("/producto")
public class ProductoController {

    @Autowired

    ProductoServicio productoServicio;

    @GetMapping()
    public ArrayList<ProductoModels> obtenerProducto() {

        return productoServicio.obtenerProducto();

    }

    @PostMapping()
    public ProductoModels guardaProducto(@RequestBody ProductoModels producto) {

        return this.productoServicio.guardarProducto(producto);

    }

    @PutMapping()
    public ProductoModels actualizarProducto(@RequestBody ProductoModels producto) {

        return this.productoServicio.guardarProducto(producto);

    }

    @DeleteMapping(path = "/{idProducto}")
    public String eliminarId(@PathVariable("idProducto") Long idProducto) {
        boolean ok = this.productoServicio.eliminarProducto(idProducto);
        if (ok) {
            return "Eliminar producto con id: " + idProducto;
        } else {
            return "No elimino el producto con id:" + idProducto;
        }
    }

}
