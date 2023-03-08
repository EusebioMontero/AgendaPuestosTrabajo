## Servicio REST Contactos

Realiza operaciones CRUD sobre una base de datos H2, en memoria y ofrece los objetos
solicitados en formato JSON.

1. Dependencias Spring.

   * Spring Web.
     * Construye la web o servicios REST
   * Lombok. 
     * Facilita la creacion de las clases de entidad.
   * Spring Data JPA.
       * Permite la persistencia.
   * H2 Database.
       * Base de datos inicial para realizar las primeras pruebas.


2. Controladores.
 
   * ContactosController.
   * PuestosController.


3. Entidades.
   Anotadas con:


   @Data
   @AllArgsConstructor
   @NoArgsConstructor
   @ToString
   @EqualsAndHashCode(onlyExplicitlyIncluded = true)

    * Contactos. 
    * Puestos.
    * AuxDeptSecc.
    * Departamentos.
    * Secciones.
    * Zonas.
    * Sedes.

4. Repositorios.
5. Servicios.