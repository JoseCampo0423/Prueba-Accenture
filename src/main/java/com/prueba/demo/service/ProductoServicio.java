package com.prueba.demo.service;

import com.prueba.demo.models.ProductoModels;
import java.util.ArrayList;

import com.prueba.demo.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicio {

    @Autowired
    ProductoRepository productoRepository;

    public ArrayList<ProductoModels> obtenerProducto() {

        return (ArrayList<ProductoModels>) productoRepository.findAll();

    }

    public ProductoModels guardarProducto(ProductoModels Producto) {

        return productoRepository.save(Producto);
    }

    public boolean eliminarProducto(Long idProducto) {
        try {
            productoRepository.deleteById(idProducto);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}
