<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registro de artículos</title>

    <asset:stylesheet src="application.css"/>


    <style>
    .btn-file {
        position: relative;
        overflow: hidden;
    }
    .btn-file input[type=file] {
        position: absolute;
        top: 0;
        right: 0;
        min-width: 100%;
        min-height: 100%;
        font-size: 100px;
        text-align: right;
        filter: alpha(opacity=0);
        opacity: 0;
        outline: none;
        background: white;
        cursor: inherit;
        display: block;
    }

    #img-upload{
        width: 100%;
    }
    </style>
</head>
<body style="background-color: #1abc9c">

<div class="container">
    <div class="row">
        <div class="col-sm-8 col-sm-offset-2">
            <div class="panel panel-default" style="margin-top: 40px">
                <div class="panel-heading">Nuevo Artículo</div>
                <div class="panel-body">
                    <form action="/articulo/save" method="post" >
                        <fieldset class="form">
                            <div class="col-sm-12">
                                <div class="row">
                                    <div class="col-sm-12 form-group">
                                        <label>Código</label>
                                        <input id="codigoArticulo" name="codigoArticulo" type="text" placeholder="Escriba el código aquí.." class="form-control">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12 form-group">
                                        <label>Nombre</label>
                                        <input id="tituloArticulo" name="tituloArticulo" type="text" placeholder="Escriba el nombre aquí.." class="form-control">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12 form-group">
                                        <label>Precio</label>
                                        <input id="precio" name="precio" type="number"  placeholder="1200.89" class="form-control">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12 form-group">
                                        <label>Cantidad</label>
                                        <input id="cantidad" name="cantidad" type="number" placeholder="300" class="form-control">
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12 form-group">
                                        <label>Descripción</label>
                                        <textarea id="descripcion" name="descripcion" placeholder="Escriba la descripción aquí.." rows="2" class="form-control"></textarea>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-12 form-group">
                                        <label>Imagen</label>
                                        <div class="input-group">
                                            <span class="input-group-btn">
                                                <span class="btn btn-default btn-file">
                                                    Browse… <input type="file" id="imgInp">
                                                </span>
                                            </span>
                                            <input type="text" class="form-control" readonly>
                                        </div>
                                        <img id='img-upload'/></textarea>
                                    </div>
                                </div>
                            </div>

                            <div class=form-group>
                                <fieldset class="buttons">
                                    <input type="submit" name="create" class="form-control" value="Create" id="create" />
                                </fieldset>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<asset:javascript src="application.js"/>
</body>

<g:javascript>
    $(document).ready( function() {
        $(document).on('change', '.btn-file :file', function() {
            var input = $(this),
                label = input.val().replace(/\\/g, '/').replace(/.*\//, '');
            input.trigger('fileselect', [label]);
        });

        $('.btn-file :file').on('fileselect', function(event, label) {

            var input = $(this).parents('.input-group').find(':text'),
                log = label;

            if( input.length ) {
                input.val(log);
            } else {
                if( log ) alert(log);
            }

        });
        function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $('#img-upload').attr('src', e.target.result);
                }

                reader.readAsDataURL(input.files[0]);
            }
        }

        $("#imgInp").change(function(){
            readURL(this);
        });
    });
</g:javascript>
</html>