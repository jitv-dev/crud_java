<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Lista de empleados</title>
</head>
<body>
    <h1>Lista de empleados</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Fecha de Ingreso</th>
                <th>Sueldo</th>
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
                </tr>
            </c:forEach>
        <c:if test="${empleados.size() == 0}">
            <tr>
                <td colspan=5>No hay registros</td>
            </tr>
        </c:if>
        </tbody>
    </table>
</body>
</html>