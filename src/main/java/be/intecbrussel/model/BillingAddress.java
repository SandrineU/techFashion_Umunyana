package be.intecbrussel.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BillingAddress implements Serializable {

    private static final long serialVersionUID = 4335766282473181233L; ///why this version?

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billing_address_id;

    private String titular_tarjeta;
    private String numero_tarjeta;
    private String fecha_expiracion;
    private String codigo_seguridad;

    @OneToOne   // why???
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getBilling_address_id() {
        return billing_address_id;
    }

    public void setBilling_address_id(int billing_address_id) {
        this.billing_address_id = billing_address_id;
    }

    public String getTitular_tarjeta() {
        return titular_tarjeta;
    }

    public void setTitular_tarjeta(String titular_tarjeta) {
        this.titular_tarjeta = titular_tarjeta;
    }

    public String getNumero_tarjeta() {
        return numero_tarjeta;
    }

    public void setNumero_tarjeta(String numero_tarjeta) {
        this.numero_tarjeta = numero_tarjeta;
    }

    public String getFecha_expiracion() {
        return fecha_expiracion;
    }

    public void setFecha_expiracion(String fecha_expiracion) {
        this.fecha_expiracion = fecha_expiracion;
    }

    public String getCodigo_seguridad() {
        return codigo_seguridad;
    }

    public void setCodigo_seguridad(String codigo_seguridad) {
        this.codigo_seguridad = codigo_seguridad;
    }

    @Override
    public String toString() {
        return "BillingAddress{" +
                "titular_tarjeta='" + titular_tarjeta + '\'' +
                ", numero_tarjeta='" + numero_tarjeta + '\'' +
                ", fecha_expiracion='" + fecha_expiracion + '\'' +
                ", codigo_seguridad='" + codigo_seguridad + '\'' +
                ", customer=" + customer +
                '}';
    }
}
