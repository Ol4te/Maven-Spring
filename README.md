# Control de Préstamos de Equipos

API REST para gestionar un inventario de equipos y los préstamos que se hacen de ellos. Proyecto de práctica con Spring Boot y MySQL.

## Tecnologías

- Java 21
- Spring Boot 3.5 (Spring Web, Spring Data JPA)
- MySQL 8
- Maven
- Docker y Docker Compose

## Arquitectura

El proyecto sigue una arquitectura por capas:

```
Controller → Service → Repository → MySQL
```

| Capa | Responsabilidad |
|---|---|
| `controller` | Expone los endpoints REST y devuelve los códigos HTTP. |
| `service` | Lógica de negocio. |
| `repository` | Acceso a datos con Spring Data JPA. |
| `model` | Entidades que se mapean a tablas. |

## Cómo ejecutarlo

### Con Docker (recomendado)

Solo necesitas tener Docker instalado:

```
docker compose up --build
```

La API queda disponible en `http://localhost:8080`.

### En local

Requisitos: Java 21, Maven y un MySQL en marcha en el puerto 3306.

```
mvn spring-boot:run
```

La conexión se configura con las variables de entorno `DB_URL`, `DB_USER` y `DB_PASSWORD`. Si no se definen, usa `localhost:3306` con el usuario `root` y sin contraseña. La base de datos y las tablas se crean automáticamente.

## Endpoints

### Equipos: `/api/equipamentos`

| Método | Ruta | Descripción |
|---|---|---|
| GET | `/api/equipamentos` | Lista todos los equipos |
| GET | `/api/equipamentos/{id}` | Busca un equipo por id (404 si no existe) |
| GET | `/api/equipamentos/estado/{estado}` | Lista los equipos por estado |
| POST | `/api/equipamentos` | Crea un equipo (201) |
| PUT | `/api/equipamentos/{id}` | Actualiza un equipo |
| DELETE | `/api/equipamentos/{id}` | Elimina un equipo (204) |

Estados posibles: `DISPONIBEL`, `EMPRESTADO`, `MANUTENCION`, `BAIXA`.

### Préstamos: `/api/emprestimos`

| Método | Ruta | Descripción |
|---|---|---|
| GET | `/api/emprestimos` | Lista todos los préstamos |
| GET | `/api/emprestimos/{id}` | Busca un préstamo por id (404 si no existe) |
| GET | `/api/emprestimos/retrasados` | Lista los préstamos retrasados (`?retrasado=false` para los no retrasados) |
| POST | `/api/emprestimos` | Crea un préstamo (201) |
| PUT | `/api/emprestimos/{id}` | Actualiza un préstamo |
| DELETE | `/api/emprestimos/{id}` | Elimina un préstamo (204) |

## Ejemplos

Crear un equipo (`POST /api/equipamentos`):

```json
{
  "nome": "Portatil Dell",
  "tipo": "Portatil",
  "modelo": "Latitude 5420",
  "numeroSerie": "SN-0001",
  "dataCompra": "2026-01-15",
  "observacions": "Nuevo",
  "estado": "DISPONIBEL"
}
```

Crear un préstamo (`POST /api/emprestimos`):

```json
{
  "equipamento": { "id": 1 },
  "solicitante": "Ana",
  "email": "ana@mail.com",
  "dataLimiteDevolucion": "2026-11-01",
  "retardado": false
}
```

El equipo debe existir antes de crear el préstamo. Las fechas usan el formato `AAAA-MM-DD`.

## Notas

- El `PUT` reemplaza el objeto completo, así que hay que enviar todos los campos.
- `numeroSerie` es único por equipo.

## Autor

Tu nombre: [github.com/Ol4te](https://github.com/Ol4te)
