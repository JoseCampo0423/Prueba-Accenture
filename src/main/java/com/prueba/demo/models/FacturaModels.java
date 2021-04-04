package com.prueba.demo.models;

// import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
// import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "factura")
public class FacturaModels {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "factura_id", unique = true, nullable = false)
    private Long idFactura;

    @Column(name = "hora_factura", nullable = false, unique = false)
    private Long horaFactura;

    @Column(name = "valor_envio", nullable = false, unique = false)
    private Long valorEnvio;

    @Column(name = "subtotalFactura", nullable = false, unique = false)
    private Long facturaSubtotal;

    @Column(name = "ivaFactura", nullable = false, unique = false)
    private Long facturaIva;

    @Column(name = "totalFactura", nullable = false, unique = false)
    private Long facturaTotal;

    @Column(name = "unidades_producto", nullable = false, unique = false)
    private Long facturaUnidades;

    @ManyToOne
    private UsuarioModels usuarioModels;

    @ManyToOne
    private ProductoModels productoModels;

    public FacturaModels() {
    }

    public Long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Long idFactura) {
        this.idFactura = idFactura;
    }

    public Long getHoraFactura() {
        return horaFactura;
    }

    public void setHoraFactura(Long horaFactura) {
        this.horaFactura = horaFactura;
    }

    public Long getValorEnvio() {
        return valorEnvio;
    }

    public void setValorEnvio(Long valorEnvio) {
        this.valorEnvio = valorEnvio;
    }

    public Long getFacturaSubtotal() {
        return facturaSubtotal;
    }

    public void setFacturaSubtotal(Long facturaSubtotal) {
        this.facturaSubtotal = facturaSubtotal;
    }

    public Long getFacturaIva() {
        return facturaIva;
    }

    public void setFacturaIva(Long facturaIva) {
        this.facturaIva = facturaIva;
    }

    public Long getFacturaTotal() {
        return facturaTotal;
    }

    public void setFacturaTotal(Long facturaTotal) {
        this.facturaTotal = facturaTotal;
    }

    public Long getFacturaUnidades() {
        return facturaUnidades;
    }

    public void setFacturaUnidades(Long facturaUnidades) {
        this.facturaUnidades = facturaUnidades;
    }

    public UsuarioModels getUsuarioModels() {
        return usuarioModels;
    }

    public void setUsuarioModels(UsuarioModels usuarioModels) {
        this.usuarioModels = usuarioModels;
    }

    public ProductoModels getProductoModels() {
        return productoModels;
    }

    public void setProductoModels(ProductoModels productoModels) {
        this.productoModels = productoModels;
    }


    


}   
