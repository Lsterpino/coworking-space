# coworking-space

## Descripción del Proyecto 📋

Coworking Space es un sistema de reservas diseñado para gestionar las salas de trabajo en un espacio de coworking. La API permitirá a los usuarios realizar y consultar reservas en tiempo real, facilitando la administración de los espacios disponibles.

## Metodología de Trabajo 🛠️

Este proyecto sigue la metodología ágil **Scrum** para la gestión y desarrollo de las tareas. Utilizamos **Trello** para organizar y hacer seguimiento de las tareas, asegurando una colaboración eficiente y una entrega continua de valor.

## Equipo de Desarrollo 👥

@karlosvas  
@puriihuaman  
@Lsterpino  
@Rs-845  
Creadores de Bytes Colaborativos: @devch-tech y @Jorexbp  
Canal de Twitch: [Bytes Colaborativos](https://www.twitch.tv/api/bytescolaborativos)

## Funcionalidades Principales ✨

- **CRUD de Servicios**: Gestión de los diferentes servicios que ofrece el coworking.
- **CRUD de Reservas**: Creación, consulta, modificación y eliminación de reservas.
- **Autenticación de Usuarios**: Registro e inicio de sesión mediante email y contraseña.
- **Uso de Tokens con Spring Security** (sin encriptación por el momento).
- **Notificaciones por correo electrónico** a los usuarios incluidos en una reserva.

## Tecnologías Utilizadas ✨

- **Backend**: Java con Spring Boot
- **Seguridad**: Spring Security (uso de tokens JWT)
- **Base de Datos**: PostgreSQL / MySQL
- **Correo Electrónico**: JavaMailSender
- **API Docs**: Swagger / OpenAPI

## Instalación y Configuración 🐧

```bash
# Clona el repositorio
git clone https://github.com/karlosvas/coworking-space.git
cd coworking-space

# Configura la base de datos en application.properties o application.yml, y crea la base de datos en tu servidor local o hazlo con h2 en memoria.
# Crea el .env con las variables de entorno necesarias para la configuración del correo electrónico.

# Ejecuta la aplicación
mvn spring-boot:run
```

## Contribución 🟢

Este es un proyecto colaborativo de la comunidad **Bytes Colaborativos**. Si deseas contribuir, abre un issue o realiza un pull request con tus mejoras.

## Documentación

Encontrarás toda la documentación generada por Swagger en la siguiente URL: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### Endpoints 🔗

- `/api/users`
- `/api/reservations`
- `/api/rooms`

### Tablas y Estructura 📊

#### Tabla `user`

| Campo    | Tipo   | Descripción            |
| -------- | ------ | ---------------------- |
| user_id  | UUID   | Identificador único    |
| name     | String | Nombre del usuario     |
| email    | String | Correo electrónico     |
| password | String | Contraseña del usuario |

#### Tabla `reservation`

| Campo          | Tipo                    | Descripción                                |
| -------------- | ----------------------- | ------------------------------------------ |
| reservation_id | UUID (PK)               | Identificador único de la reserva          |
| user_id        | UUID (FK)               | Identificador del usuario que reserva      |
| room_id        | UUID (FK)               | Identificador de la sala reservada         |
| start_date     | Timestamp               | Fecha y hora de inicio de la reserva       |
| end_date       | Timestamp               | Fecha y hora de finalización de la reserva |
| reserve_status | Enum(ReservationStatus) | Estado de la reserva                       |
| description    | String                  | Descripción de la reserva                  |

#### Tabla `room`

| Campo      | Tipo             | Descripción                    |
| ---------- | ---------------- | ------------------------------ |
| room_id    | UUID (PK)        | Identificador único de la sala |
| name       | String           | Nombre de la sala              |
| num_status | Enum(RoomStatus) | Estado de la sala              |
| capacity   | int              | Capacidad de la sala           |
