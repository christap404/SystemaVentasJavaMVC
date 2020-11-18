<%-- 
    Document   : Empleado
    Created on : 15/11/2020, 12:05:21 PM
    Author     : chris
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EMPLEADOS</title>
    </head>
    <body>
        <div class="d-flex">
            <div class="card col-sm-4" >
                <div class="card-body " s>
                    <form  action="Controlador?menu=Empleado" method="POST">
                        <div class="form-group">
                            <label>Dni</label>
                            <input type="text" name="txtDni" value="${empleado.getDni()}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Nombres</label>
                            <input type="text" name="txtNom" value="${empleado.getNom()}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Telefono</label>
                            <input type="text" name="txtTel" value="${empleado.getTel()}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Estado</label>
                            <input type="text" name="txtEst" value="${empleado.getEstado()}" class="form-control">
                        </div>
                        <div class="form-group">
                            <label>Usuario</label>
                            <input type="text" name="txtUsu" value="${empleado.getUser()}" class="form-control">
                        </div>
                        <input type="submit" name="accion" value="Agregar" class="btn-info">
                        <input type="submit" name="accion" value="Actualizar" class="btn-success">
                    </form>

                </div>

            </div>
            <div class="col-sm-8">
                <table style="text-align: center" class="table table-hover" border="1">
                    <thead>
                        <tr style="background-color: orange">
                            <th>ID</th>
                            <th>DNI</th>
                            <th>NOMBRES</th>
                            <th>TELEFONO</th>
                            <th>ESTADOS</th>
                            <th>USUARIO</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="em" items="${empleados}">
                            <tr>
                                <td>${em.getId()}</td>
                                <td>${em.getDni()}</td>
                                <td>${em.getNom()}</td>
                                <td>${em.getEstado()}</td>
                                <td>${em.getTel()}</td>  
                                

                                <td>${em.getUser()}</td>
                                <td>
                                    <a style="size: auto" class="btn btn-warning" href="Controlador?menu=Empleado&accion=Editar&id=${em.getId()}">Editar</a>
                                    <a style="size: auto" class="btn btn-danger" href="Controlador?menu=Empleado&accion=Eliminar&id=${em.getId()}">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>

        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
    </body>
</html>
