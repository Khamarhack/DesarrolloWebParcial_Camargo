# Backend - Gestión de Bibliotecas y Libros

API REST desarrollada con Spring Boot para la gestión de bibliotecas y libros.
Relación uno a muchos: una **Biblioteca** (padre) puede tener muchos **Libros** (hija).

## Tecnologías

- Java 21
- Spring Boot 3.2.0
- Spring Data JPA
- H2 Database (en memoria)
- Lombok
- ModelMapper

## Ejecutar

```bash
cd backend
.\mvnw spring-boot:run
```

La API estará disponible en `http://localhost:8080`.

## Endpoints (CRUD solo para la entidad padre Biblioteca)

- `GET    /api/bibliotecas`      - Listar todas las bibliotecas
- `GET    /api/bibliotecas/{id}` - Consultar biblioteca por ID
- `POST   /api/bibliotecas`      - Crear nueva biblioteca
- `PUT    /api/bibliotecas/{id}` - Actualizar biblioteca
- `DELETE /api/bibliotecas/{id}` - Eliminar biblioteca

> La entidad hija **Libro** solo tiene entidad y repositorio (sin servicio ni
> controlador CRUD), tal como exige el enunciado.

## Base de datos

- Consola H2: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:bibliotecadb`  (usuario `sa`, sin contraseña)
- Se cargan datos de ejemplo desde `src/main/resources/data.sql` para
  evidenciar la relación uno a muchos.
