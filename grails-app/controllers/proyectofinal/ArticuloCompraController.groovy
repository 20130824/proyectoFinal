package proyectofinal

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ArticuloCompraController {

    ArticuloCompraService articuloCompraService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond articuloCompraService.list(params), model:[articuloCompraCount: articuloCompraService.count()]
    }

    def show(Long id) {
        respond articuloCompraService.get(id)
    }

    def create() {
        respond new ArticuloCompra(params)
    }

    def save(ArticuloCompra articuloCompra) {
        if (articuloCompra == null) {
            notFound()
            return
        }

        try {
            articuloCompraService.save(articuloCompra)
        } catch (ValidationException e) {
            respond articuloCompra.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'articuloCompra.label', default: 'ArticuloCompra'), articuloCompra.id])
                redirect articuloCompra
            }
            '*' { respond articuloCompra, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond articuloCompraService.get(id)
    }

    def update(ArticuloCompra articuloCompra) {
        if (articuloCompra == null) {
            notFound()
            return
        }

        try {
            articuloCompraService.save(articuloCompra)
        } catch (ValidationException e) {
            respond articuloCompra.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'articuloCompra.label', default: 'ArticuloCompra'), articuloCompra.id])
                redirect articuloCompra
            }
            '*'{ respond articuloCompra, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        articuloCompraService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'articuloCompra.label', default: 'ArticuloCompra'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'articuloCompra.label', default: 'ArticuloCompra'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
