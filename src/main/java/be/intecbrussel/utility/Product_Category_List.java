package be.intecbrussel.utility;

public class Product_Category_List {

    public Map< String, String > categorias = new LinkedHashMap<>();

    public Product_Category_List() {
        categorias.put("Otro", "Otro...");
        categorias.put("Utiles Escolares", "Utiles Escolares");
        categorias.put("Libros", "Libros");
        categorias.put("Accesorios", "Accesorios");
        categorias.put("Equipo de Audio", "Equipo de Audio");
        categorias.put("Instrumentos Musicales", "Instrumentos Musicales");
        categorias.put("Computacion/Electronica", "Computacion/Electronica");
        categorias.put("Celulares/tablets", "Celulares/tablets");
        categorias.put("Hogar", "Hogar");
        categorias.put("Muebles", "Muebles");
    }

    public Map<String, String> getLista_categoria() {
        return categorias;
    }

    public void addMapValue(String key, String value) {
        this.categorias.put(key, value);
    }
}
