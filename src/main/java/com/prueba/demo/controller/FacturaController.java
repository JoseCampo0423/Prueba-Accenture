package com.prueba.demo.controller;

import com.prueba.demo.models.FacturaModels;
import com.prueba.demo.service.FacturaServicio;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
@RequestMapping("/factura")
public class FacturaController {

    @Autowired

    FacturaServicio facturaServicio;
    private Object borrarFactura;

    @GetMapping()
    public ArrayList<FacturaModels> obtenerFactura() {

        return facturaServicio.obtenerFactura();

    }

    @PostMapping()
    public FacturaModels guardarfactura(@RequestBody FacturaModels factura) {
        LocalDateTime horaFactura = LocalDateTime.now();
        long soloHora = horaFactura.getHour();
        Long Hora = factura.getHoraFactura();

        long unidadesProd = factura.getFacturaUnidades();
        long precioProd = factura.getProductoModels().getPrecioProducto();
        long subTotalProd = unidadesProd * precioProd;
        long domicilioProd = 0;
        long iva = 0;

        if (subTotalProd >= 70000) {
            iva = ((subTotalProd) * 19 / 100);
        }

        if (subTotalProd <= 70000) {
            domicilioProd = 3000;
        }

        if ((horaFactura.getHour() + 5) - 24 >= 0 && (horaFactura.getHour() + 5) - 24 <= 0) {
            System.out.println(" ###### Tiene 5 horas para actulizar su pedido ###### ");
        }

        long totalFactura = (subTotalProd + domicilioProd);

        factura.setValorEnvio(domicilioProd);
        factura.setFacturaTotal(subTotalProd);
        factura.setFacturaIva(iva);
        factura.setFacturaSubtotal(subTotalProd);
        factura.setHoraFactura(soloHora);

        return this.facturaServicio.guardarfactura(factura);

    }

    @PutMapping()
    public FacturaModels actualizarFactura(@RequestBody FacturaModels factura) {
        return this.facturaServicio.guardarfactura(factura);

    }

    @DeleteMapping(path = "/{idFactura}")
    public String eliminarId(@PathVariable("idFactura") Long idFactura) {

        LocalDateTime horaFactura = LocalDateTime.now();
        long horaDelete = horaFactura.getHour();
        FacturaModels facturaDelete = new FacturaModels();
        long horaFacturaPedido = (facturaDelete.getHoraFactura() + 12);

        if ((horaFacturaPedido <= horaDelete) && (horaDelete >= facturaDelete.getHoraFactura())) {
            boolean ok = this.facturaServicio.eliminarFactura(idFactura);

            if (ok) {
                return "Se Elimino factura con id: " + idFactura;
            } else {
                return "No se pudo eliminar la factura con id: " + idFactura;
            }

        }

        return "Error no se pudo determinar la hora valida para eliminar su pedido";

    }

}
