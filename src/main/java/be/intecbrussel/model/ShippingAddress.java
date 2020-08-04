package be.intecbrussel.model;

public class ShippingAddress implements Serializable{

    private static final long serialVersionUID = 4045861295293075512L;

    @Id
    @GeneratedValue
    private int shipping_address_id;

    private String calle;
    private String fraccionamiento;
    private String numero_apartamento;
    private String ciudad;
    private String estado;
    private String pais;
    private String zip;

    @OneToOne
    @JsonBackReference
    private Customer customer;

    public String getFraccionamiento() {
        return fraccionamiento;
    }

    public void setFraccionamiento(String fraccionamiento) {
        this.fraccionamiento = fraccionamiento;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public int getShipping_address_id() {
        return shipping_address_id;
    }

    public void setShipping_address_id(int shipping_address_id) {
        this.shipping_address_id = shipping_address_id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero_apartamento() {
        return numero_apartamento;
    }

    public void setNumero_apartamento(String numero_apartamento) {
        this.numero_apartamento = numero_apartamento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    @Override
    public String toString() {
        return "ShippingAddress{" +
                "calle='" + calle + '\'' +
                ", numero_apartamento='" + numero_apartamento + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", estado='" + estado + '\'' +
                ", pais='" + pais + '\'' +
                ", zip='" + zip + '\'' +
                ", customer=" + customer +
                '}';
    }
}