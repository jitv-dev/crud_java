# 📋 CRUD Java - Gestor de Empleados

Proyecto de aprendizaje orientado a entender las bases de un **CRUD completo en Java** usando el patrón **MVC**, JSP, Servlets y MySQL. No sigue los estándares REST ni rutas semánticas, ya que el foco es comprender el flujo de datos entre capas.

> 📝 *Este README fue generado con ayuda de [Claude](https://claude.ai) (Anthropic).*

---

## 🛠️ Tecnologías utilizadas

| Tecnología | Versión |
|---|---|
| Java | 21 |
| Jakarta Servlet API | 6.0.0 |
| Jakarta JSP API | 3.1.0 |
| JSTL (Jakarta) | 3.0.0 |
| MySQL Connector/J | 8.3.0 |
| Bootstrap | 5.3.8 |
| Font Awesome | 7.0.1 |
| Apache Tomcat | 10.1.x |

---

## 🏗️ Creación del proyecto

El proyecto fue creado en **IntelliJ IDEA** usando **Maven Archetype Webapp** con los siguientes datos:

```
GroupId:    org.apache.maven.archetypes
ArtifactId: maven-archetype-webapp
Version:    1.4
```

---

## 📁 Estructura del proyecto (MVC)

```
src/
└── main/
    ├── java/
    │   ├── config/
    │   │   └── Conexion.java          # Configuración de la BD
    │   ├── controllers/
    │   │   └── EmpleadoController.java # Servlet / Controlador
    │   └── models/
    │       ├── Empleado.java           # Modelo
    │       └── dao/
    │           └── EmpleadoDAO.java    # Acceso a datos
    └── webapp/
        ├── views/
        │   ├── listar.jsp             # Vista listado
        │   └── nuevo.jsp              # Vista formulario
        ├── WEB-INF/
        │   └── web.xml
        └── index.jsp                  # Redirección inicial
```

### Capas MVC

- **Model** → `Empleado.java` + `EmpleadoDAO.java` — lógica de negocio y acceso a la base de datos
- **View** → archivos `.jsp` — presentación al usuario
- **Controller** → `EmpleadoController.java` — recibe peticiones y coordina modelo y vista

---

## ⚙️ Configuración de la base de datos

Edita `src/main/java/config/Conexion.java` con tus datos:

```java
public static final String username = "root";
public static final String password = "tu_password";
public static final String database = "bdempleado";
public static final String url = "jdbc:mysql://localhost:3306/" + database;
```

Crea la base de datos y tabla en MySQL:

```sql
CREATE DATABASE bdempleado;

USE bdempleado;

CREATE TABLE empleado (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombres VARCHAR(50) NOT NULL,
    apellidos VARCHAR(50) NOT NULL,
    fecha_ingreso DATE NOT NULL,
    sueldo DOUBLE NOT NULL
);
```

---

## 🚀 Cómo correr el proyecto

1. Clona el repositorio
2. Abre el proyecto en **IntelliJ IDEA**
3. Configura un servidor **Tomcat 10.1.x** en Run → Edit Configurations
4. En la pestaña **Deployment** agrega el artifact `Crud_Java:war exploded` con context path `/`
5. Asegúrate de tener **XAMPP** (o MySQL) corriendo en el puerto `3306`
6. Ejecuta con **Shift + F10** o el botón Run

Accede en: `http://localhost:8080/EmpleadoController?accion=listar`

---

## 📌 Funcionalidades

- ✅ Listar empleados
- ✅ Registrar nuevo empleado
- ✅ Editar empleado (modal)
- ✅ Eliminar empleado (modal de confirmación)

---

## ⚠️ Notas

- Las rutas usan el parámetro `?accion=` en lugar de rutas REST semánticas, ya que el objetivo es aprender el flujo MVC básico.
- No se implementó validación de formularios del lado del servidor.
- Las credenciales de la BD están hardcodeadas en `Conexion.java`, lo cual no es recomendable en proyectos reales.