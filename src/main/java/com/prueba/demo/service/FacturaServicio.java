package com.prueba.demo.service;

import java.util.ArrayList;

import com.prueba.demo.models.FacturaModels;
import com.prueba.demo.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaServicio {

    @Autowired
    FacturaRepository facturaRepository;

    public ArrayList<FacturaModels> obtenerFactura() {

        return (ArrayList<FacturaModels>) facturaRepository.findAll();

    }

    public FacturaModels guardarfactura(FacturaModels Factura) {

        return facturaRepository.save(Factura);
    }

    public boolean eliminarFactura(Long idFactura) {
        try {
            facturaRepository.deleteById(idFactura);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

}
