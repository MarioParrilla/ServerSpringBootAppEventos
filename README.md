#### CICLO FORMATIVO DE GRADO SUPERIOR

### DESARROLLO DE APLICACIONES MULTIPLATAFORMA

##### ACCESO A DATOS - 2º CURSO

![logo-IESGP-FP](./readmeAssets/logo-IESGP-FP.png)



# AppEventos

###### Curso: 2021/22

###### AUTOR: Mario Parrilla Maroto

------

# Introducción

## Motivación y objetivos

He decidido realizar una aplicacion de eventos para dar solucion a las personas que quieres quedar o pedir cita para un evento o situacion, como por ejemplo realizar una reunión, quedar alguien para contratarle...

## Descripción de la aplicación

Esta aplicacion, te permitirá controlar los usuarios de la aplicacion movil y poder ver los eventos y sus detalles

# Especificación de requisitos

## Requisitos funcionales CMS

RQ1 - Login: El administrador se deberá logear antes de poder entrar a las funcionalidades. Según quiera, el adminitrador podrá administrar usuarios o eventos

RQ2 - Gestión Usuarios: Se podrá administrar usuarios, donde podras ver su información, editar su información, añadir usuarios y eliminar usuarios

RQ3 - Gestión Eventos: Se podrá administrar citas o eventos, podras ver su información, editar su información, añadir usuarios y eliminar eventos

Diagrama Casos de Uso:

![casosUsoAdmin](./readmeAssets/Diagramas/casosUsoAdmin.png)

## Wireframe

Página Inicio Sin Logearse:
En esta pagina se podrá ver el inicio y ir a la pagina de login.

![inicioNoLogin](./readmeAssets/wireframe/inicioNoLogin.png)

Página Login:
En esta pagina podremos logearnos con nuestro usuario admin y guardar sesion.

![login](./readmeAssets/wireframe/login.png)

Página Inicio Con Login:
Una vez logeados, podremos ver más opciones como usuarios, eventos y cerrar sesion.

![inicioLogin](./readmeAssets/wireframe/inicioLogin.png)

Página Usuarios:
No mostrará una tabla donde podremos ver la información de los usuarios y las acciones como añadir, editar y eliminar usuarios.

![usuarios](./readmeAssets/wireframe/usuarios.png)

Página Agregar Usuario:
En esta página podremos agregar un nuevo usuario incluyendo su información.

![agregarUsuario](./readmeAssets/wireframe/agregarUsuario.png)

Página Modificar Usuario:
En esta página, podremos editar la información del usuario.

![editarUsuario](./readmeAssets/wireframe/editarUsuario.png)

Página Eventos:
No mostrará una tabla donde podremos ver la información de los eventos y las acciones como añadir, editar y eliminar eventos.

![eventos](./readmeAssets/wireframe/eventos.png)

Página Agregar Evento:
En esta página podremos agregar un nuevo evento incluyendo su información.

![agregarEvento](./readmeAssets/wireframe/agregarEvento.png)

Página Modificar Evento:
En esta página, podremos editar la información del evento.

![editarEvento](./readmeAssets/wireframe/editarEvento.png)

Página Errores:
Esta página se mostrará cuando ocurra cualquier error con la página.

![error](./readmeAssets/wireframe/error.png)

## API REST

### API REST -- USUARIOS

Obtener todos los usuarios: Usando el metodo GET, podremos obtener todos los datos de los usuarios desde la ruta /api/usuario

![GetTodosUsuarios](./readmeAssets/ApiRest/GetTodosUsuarios.png)

Obtener un usuario: Usando el metodo GET, podremos obtener todos los datos de un usuario desde la ruta /api/usuario/{userID}

![GetUsuarioID](./readmeAssets/ApiRest/GetUsuarioID.png)

Crear un usuario: Usando el metodo POST, podremos crear un usuario desde la ruta /api/usuario con el body que se ve en la imagen. (Todos los valores del body son obligatorios NotNull)

![PostCrearUsuario](./readmeAssets/ApiRest/PostCrearUsuario.png)

Modificar un usuario: Usando el metodo PUT, podremos modificar a un usuario desde la ruta /api/usuario/{userID} con el body indicado en la imagen. (Todos los valores del body son obligatorios NotNull)

![PutModificarUsuario](./readmeAssets/ApiRest/PutModificarUsuario.png)

Eliminar un usuario: Usando el metodo DELETE, podremos eliminar a un usuario desde la ruta /api/usuario/{userID}

![DeleteBorrarUsuario](./readmeAssets/ApiRest/DeleteBorrarUsuario.png)

### API REST -- EVENTOS

Obtener todos los eventos: Usando el metodo GET, podremos obtener todos datos de los eventos desde la ruta /api/evento

![GetTodosEventos](./readmeAssets/ApiRest/GetTodosEventos.png)

Obtener un evento: Usando el metodo GET, podremos obtener todos los datos de un evento desde la ruta /api/evento/{eventID}

![GetEventoID](./readmeAssets/ApiRest/GetEventoID.png)

Crear un evento: Usando el metodo POST, podremos crear un evento desde la ruta /api/evento con el body que se ve en la imagen. (Todos los valores del body son obligatorios NotNull)

![PostCrearEvento](./readmeAssets/ApiRest/PostCrearEvento.png)

Modificar un evento: Usando el metodo PUT, podremos modificar un evento desde la ruta /api/evento/{userID} con el body indicado en la imagen. (Todos los valores del body son obligatorios NotNull)

![PutModificarEvento](./readmeAssets/ApiRest/PutModificarEvento.png)

Eliminar un evento: Usando el metodo DELETE, podremos eliminar un evento desde la ruta /api/evento/{eventID}

![DeleteBorrarEvento](./readmeAssets/ApiRest/DeleteBorrarEvento.png)


## Requisitos no funcionales

Seguridad: se necesitará un token para acceder a la api

Conectividad: se necesitará conexión wifi para poder funcionar, con http

Dispositivos: se podrá usar desde cualquier dispositivo con un navegador web

# Análisis Funcional

## Interfaz gráfico

Página Inicio Sin Logearse:
En esta pagina se podrá ver el inicio y ir a la pagina de login.

![inicioNoLogin](./readmeAssets/DisennoGrafico/inicioNoLogin.png)

Página Login:
En esta pagina podremos logearnos con nuestro usuario admin y guardar sesion.

![login](./readmeAssets/DisennoGrafico/login.png)

Página Inicio Con Login:
Una vez logeados, podremos ver más opciones como usuarios, eventos y cerrar sesion.

![inicioLogin](./readmeAssets/DisennoGrafico/inicioLogin.png)

Página Usuarios:
No mostrará una tabla donde podremos ver la información de los usuarios y las acciones como añadir, editar y eliminar usuarios.

![usuarios](./readmeAssets/DisennoGrafico/usuarios.png)

Página Agregar Usuario:
En esta página podremos agregar un nuevo usuario incluyendo su información.

![agregarUsuario](./readmeAssets/DisennoGrafico/agregarUsuario.png)

Página Modificar Usuario:
En esta página, podremos editar la información del usuario.

![editarUsuario](./readmeAssets/DisennoGrafico/editarUsuario.png)

Página Eventos:
No mostrará una tabla donde podremos ver la información de los eventos y las acciones como añadir, editar y eliminar eventos.

![eventos](./readmeAssets/DisennoGrafico/eventos.png)

Página Agregar Evento:
En esta página podremos agregar un nuevo evento incluyendo su información.

![agregarEvento](./readmeAssets/DisennoGrafico/agregarEvento.png)

Página Modificar Evento:
En esta página, podremos editar la información del evento.

![editarEvento](./readmeAssets/DisennoGrafico/editarEvento.png)

Página Errores:
Esta página se mostrará cuando ocurra cualquier error con la página.

![error](./readmeAssets/DisennoGrafico/error.png)

## Diagrama de clases

Se debe incluir un diagrama de clases, la descripción de las mismas.

## Diagrama E/R

### TABLA -- USUARIO

Todos los datos de esta tabla son Not Null, no pueden ser nulos

userID: Es la clave principal de la tabla, que será el identificador del usuario, que es de tipo bigint.

username: Es el nombre de usuario, que es de tipo varchar.

email: Es el correo electronico del usuario, que es de tipo varchar.

password: Es la contraseña del usuario, que es de tipo varchar.

phonenumber: Es el numero de telefono del usuario, que es de tipo varchar.

enabled: Nos servirá para saber si el usuario puede utilizarse o no, que es de tipo bit que en verdad es un boolean.

### TABLA -- EVENTO

eventID: Es la clave principal de la tabla, que será el identificador del evento, que es de tipo bigint. NotNull.

username: Es el nombre de evento, que es de tipo varchar. NotNull.

start_time: Es la fecha y hora del inicio del evento, que es de tipo Datetime. NotNull.

end_time: Es la fecha y hora de final del evento, que es de tipo Datetime. NotNull.

event_preference: Con este dato, segun su valor, si es 0 será un evento presencial y si no, será un evento meeting y con esto trabajaremos con diferentes datos según este valor, es de tipo bit, que en realidad es un boolean. NotNull.

coordinates: Son las coordenadas de la localizacion del lugar de quedada del evento, es de tipo varchar.

videomeeting: Es el enlace de la videoconferencia del evento, es de tipo varchar.

available: Con este dato sabremos si el evento esta activado o no según su valor (0 = desahabilitado / 1 = habilitado), es de tipo bit, pero en realidad es de tipo boolean. NotNull.

user_owner_id_user: es la id del usuario que ha creado el evento, es de tipo bigint. NotNull.

user_summoner_id_user: es la id del usuario que ha citado al creador el evento, es de tipo bigint.

![entidadRealacion](./readmeAssets/Diagramas/entidadRelacion.png)

## Plan de pruebas

Define los casos de prueba que se deben realizar para comprobar el correcto funcionamiento de la aplicación web.



# Diseño Técnico

## Diagrama de paquetes y de componentes

Se debe incluir un diagrama de paquetes, de componentes, etc.

También se puede incluir la estructura y descripción de los ficheros que forman parte del proyecto. Descripción 

de algoritmos, etc.

## Arquitectura del sistema

Describir la arquitectura del sistema (diagrama de despliegue).

## Entorno de desarrollo, librerías y servicios

En este punto se explicarán las diferentes tecnologías utilizadas para la realización del proyecto, así como los elementos más importantes que permitan entender el funcionamiento del sistema.

## Instrucciones para la compilación, ejecución y despliegue de la aplicación

Describe los pasos a seguir para poder compilar el proyecto y ejecutarlo.



# Informe de pruebas

Describe el resultado de ejecutar los casos de prueba sobre la aplicación web y del API REST.



# Conclusiones

## Conocimientos adquiridos

Reflexiona sobre el trabajo realizado durante el desarrollo de la aplicación web y sobre los conocimientos adquiridos, problemas encontrados, etc.

## Mejoras futuras

Incluye aspectos y nueva funcionalidad que incluirías en el CMS en un futuro próximo. 