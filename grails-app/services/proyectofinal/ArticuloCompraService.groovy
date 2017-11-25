package proyectofinal

import grails.gorm.services.Service

@Service(ArticuloCompra)
interface ArticuloCompraService {

    ArticuloCompra get(Serializable id)

    List<ArticuloCompra> list(Map args)

    Long count()

    void delete(Serializable id)

    ArticuloCompra save(ArticuloCompra articuloCompra)

}