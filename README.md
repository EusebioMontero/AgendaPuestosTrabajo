## Servicio REST Contactos

Realiza operaciones CRUD sobre una base de datos H2, en memoria y ofrece los objetos
solicitados en formato JSON. Se aplica seguridad a traves de Java Web Token.

1. Dependencias Spring.

    * Spring Starter Web.
        * Construye la web o servicios REST
    * Spring Data Starter JPA.
        * Permite la persistencia.
    * Spring Starter Security.
        * Capa de seguridad, he implementado JWT.
    * Spring Starter Webfux
        * Crea flujos a la hora de entregar el Json. (no lo he implementado aún).
    * Spring DevTools
        * Permite reiniciar el proyecto mas rapidamente.
    * H2 Database.
        * Base de datos inicial para realizar las primeras pruebas.
    * Lombok.
        * Facilita la creacion de las clases de entidad.


2. Paquetes.
   1. controllers. Objetos @Contoller que "escuchan" las distintas URLs.   
   2. entities. Objetos @Entity que persistirán en la BBDD
   3. models. Objetos que se entregarán al cliente.Pendiente implementar.
   4. repositories. Objetos @Repository que implementan las tareas CRUD
   5. security. Clases relacionadas con la seguridad (JWT)
   6. services. Objetos @Services que manejan lo devuelto por la BBDD y lo entregan a los controladores.
   7. util. Clases de utilidad.
