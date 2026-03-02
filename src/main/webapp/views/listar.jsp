<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css">
    <title>Lista de empleados</title>
</head>
<body>
<div class="text-center my-3">
    <h3>Gestor de empleados</h3>
    <a href="EmpleadoController?accion=nuevo" class="btn btn-success btn-sm"><i class="fa fa-plus-circle"></i> Nuevo</a>
</div>
<div class="container text-center">
    <table class="table table-dark table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nombres</th>
            <th>Apellidos</th>
            <th>Fecha de Ingreso</th>
            <th>Sueldo</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${empleados}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.nombres}</td>
                <td>${item.apellidos}</td>
                <td>${item.fechaIngreso}</td>
                <td>${item.sueldo}</td>
                <td>
                    <button class="btn btn-warning btn-sm"
                            data-bs-toggle="modal"
                            data-bs-target="#modalEditar"
                            data-id="${item.id}"
                            data-nombres="${item.nombres}"
                            data-apellidos="${item.apellidos}"
                            data-fecha="${item.fechaIngreso}"
                            data-sueldo="${item.sueldo}">
                        <i class="fa fa-edit"></i>
                    </button>
                </td>
            </tr>
        </c:forEach>
        <c:if test="${empleados.size() == 0}">
            <tr>
                <td colspan=5>No hay registros</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</div>

<%--Modal--%>
<div class="modal fade" id="modalEditar" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title fw-bold">Editar Empleado</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">
                <form action="EmpleadoController" method="post">
                    <input type="hidden" name="accion" value="actualizar">
                    <input type="hidden" name="id" id="editId">
                    <div class="row">
                        <div class="mb-3 col-6">
                            <label for="editNombres" class="form-label fw-bold">Nombres:</label>
                            <input type="text" class="form-control" id="editNombres" name="nombres" maxlength="50">
                        </div>
                        <div class="mb-3 col-6">
                            <label for="editApellidos" class="form-label fw-bold">Apellidos:</label>
                            <input type="text" class="form-control" id="editApellidos" name="apellidos" maxlength="50">
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="editFecha" class="form-label fw-bold">Fecha de ingreso:</label>
                        <input type="date" class="form-control" id="editFecha" name="fechaIngreso">
                    </div>
                    <div class="mb-3">
                        <label for="editSueldo" class="form-label fw-bold">Sueldo:</label>
                        <input type="number" class="form-control" id="editSueldo" name="sueldo">
                    </div>
                    <div class="text-center">
                        <button type="submit" class="btn btn-warning"><i class="fa fa-save"></i> Actualizar</button>
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"><i class="fa fa-arrow-left"></i> Cancelar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%--Js para el llenado del modal--%>
<script>
    document.getElementById('modalEditar').addEventListener('show.bs.modal', function(e) {
        let btn = e.relatedTarget;
        document.getElementById('editId').value        = btn.dataset.id;
        document.getElementById('editNombres').value   = btn.dataset.nombres;
        document.getElementById('editApellidos').value = btn.dataset.apellidos;
        document.getElementById('editFecha').value     = btn.dataset.fecha;
        document.getElementById('editSueldo').value    = btn.dataset.sueldo;
    });
</script>

<%--Js de bootstrap--%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous"></script>
</body>
</html>