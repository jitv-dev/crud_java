<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css">
    <title>Nuevo Empleado</title>
</head>
<body>
<div class="container mt-3">
    <div class="card">
        <h3 class="text-center card-title mt-3">Nuevo Empleado</h3>
        <div class="card-body">
            <form action="EmpleadoController" method="post">
                <div class="row">
                    <div class="mb-3 col-6">
                        <label for="nombres" class="form-label fw-bold">Nombres:</label>
                        <input type="text" class="form-control" id="nombres" maxlength="50" name="nombres" value="${empleado.nombres}">
                    </div>
                    <div class="mb-3 col-6">
                        <label for="apellidos" class="form-label fw-bold">Apellidos:</label>
                        <input type="text" class="form-control" id="apellidos" maxlength="50" name="apellidos" value="${empleado.apellidos}">
                    </div>
                </div>
                <div class="mb-3">
                    <label for="fechaIngreso" class="form-label fw-bold">Fecha de ingreso:</label>
                    <input type="date" class="form-control" id="fechaIngreso" name="fechaIngreso" value="${empleado.fechaIngreso}">
                </div>
                <div class="mb-3">
                    <label for="sueldo" class="form-label fw-bold">Sueldo:</label>
                    <input type="number" class="form-control" id="sueldo" name="sueldo" value="${empleado.sueldo}">
                </div>
                <div class="text-center">
                    <input type="hidden" name="accion" value="guardar">
                    <button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Registrar</button>
                    <a href="EmpleadoController?accion=listar" class="btn btn-secondary">
                        <i class="fa fa-arrow-left"></i> Volver
                    </a>
                </div>
            </form>
        </div>
    </div>

</div>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>
</body>
</html>