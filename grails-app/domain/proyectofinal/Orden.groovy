package proyectofinal

class Orden {

    List<ArticuloCompra> articuloCompras
    String fecha
    Usuario usuario
    double montoTotal
    Boolean despachada
    Boolean entregada

    static constraints = {
    }
}
