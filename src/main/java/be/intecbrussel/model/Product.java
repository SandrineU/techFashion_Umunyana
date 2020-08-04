package be.intecbrussel.model;

public class Product implements Serializable {

        private static final long serialVersionUID = -5275312162791227880L;

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int producto_id;

        @NotEmpty(message = "El nombre del producto es obligatorio")
        private String nombre;

        private String descripcion;
        private String categoria;
        private String condicion;
        private String manufacturante;

        @Min(value = 0, message = "Las unidades en existencia no pueden ser menores a cero")
        private int unidades_en_existencia;

        @Min(value = 0, message = "El precio del producto no pueden ser menor a cero")
        private double precio;

        @Transient
        private MultipartFile imagen;

        @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
        @JsonIgnore
        private List<CartItem> cartItemList;

        public int getProducto_id() {
            return producto_id;
        }

        public void setProducto_id(int producto_id) {
            this.producto_id = producto_id;
        }

        public List<CartItem> getCartItemList() {
            return cartItemList;
        }

        public void setCartItemList(List<CartItem> cartItemList) {
            this.cartItemList = cartItemList;
        }

        public MultipartFile getImagen() {
            return imagen;
        }

        public void setImagen(MultipartFile imagen) {
            this.imagen = imagen;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDescripcion() {
            return descripcion;
        }

        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getCategoria() {
            return categoria;
        }

        public void setCategoria(String categoria) {
            this.categoria = categoria;
        }

        public String getCondicion() {
            return condicion;
        }

        public void setCondicion(String condicion) {
            this.condicion = condicion;
        }

        public String getManufacturante() {
            return manufacturante;
        }

        public void setManufacturante(String manufacturante) {
            this.manufacturante = manufacturante;
        }

        public int getUnidades_en_existencia() {
            return unidades_en_existencia;
        }

        public void setUnidades_en_existencia(int unidades_en_existencia) {
            this.unidades_en_existencia = unidades_en_existencia;
        }

        public double getPrecio() {
            return precio;
        }

        public void setPrecio(double precio) {
            this.precio = precio;
        }

    }
}
