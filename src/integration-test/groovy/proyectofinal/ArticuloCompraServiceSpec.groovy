package proyectofinal

import grails.test.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ArticuloCompraServiceSpec extends Specification {

    ArticuloCompraService articuloCompraService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ArticuloCompra(...).save(flush: true, failOnError: true)
        //new ArticuloCompra(...).save(flush: true, failOnError: true)
        //ArticuloCompra articuloCompra = new ArticuloCompra(...).save(flush: true, failOnError: true)
        //new ArticuloCompra(...).save(flush: true, failOnError: true)
        //new ArticuloCompra(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //articuloCompra.id
    }

    void "test get"() {
        setupData()

        expect:
        articuloCompraService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ArticuloCompra> articuloCompraList = articuloCompraService.list(max: 2, offset: 2)

        then:
        articuloCompraList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        articuloCompraService.count() == 5
    }

    void "test delete"() {
        Long articuloCompraId = setupData()

        expect:
        articuloCompraService.count() == 5

        when:
        articuloCompraService.delete(articuloCompraId)
        sessionFactory.currentSession.flush()

        then:
        articuloCompraService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ArticuloCompra articuloCompra = new ArticuloCompra()
        articuloCompraService.save(articuloCompra)

        then:
        articuloCompra.id != null
    }
}
