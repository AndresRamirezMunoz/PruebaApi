#Gustavo Andres Ramirez Muñoz
#language: es

Característica: Como usuario nuevo quiero hacer el ciclo de vida en el sistema

  @Post
  Esquema del escenario: Se quiere registrar en el sistema
    Dado que es un usuario nuevo
      | name   | job   |
      | <name> | <job> |
    #  | name   | salary   | age   |
    #  | <name> | <salary> | <age> |
    Cuando se da inicio al proceso de registro
    #Entonces el usuario validara que su registro es exitoso <status> y <message>
    Entonces el usuario validara que su registro con statusCode <statusCode>
    Ejemplos:
      | name     | salary | age | status  | message                              | job     | statusCode |
      | Jhon Doe | 1300   | 23  | success | Successfully! Record has been added. | jobTest | 201        |

  @Get
  Esquema del escenario: Se quiere validar los datos en el sistema
    Dado que es un usuario registrado <id>
    Cuando se da inicio al proceso de solicitud de datos
    Entonces el usuario validara que sus datos estan en el sistema
      | id   | email   | firstName   | lastName   |
      | <id> | <email> | <firstName> | <lastName> |
    Ejemplos:
     # | name     | salary                 | age       | status         | message                              | job     | statusCode |
     # | Jhon Doe | 1300                   | 23        | success        | Successfully! Record has been added. | jobTest | 201        |

      | id | email                  | firstName | lastName |
      | 1  | george.bluth@reqres.in | George    | Bluth    |


  @Put
  Esquema del escenario: Se quiere actualizar los datos en el sistema
    Dado que es un usuario registrado
      | id   | name   | job   |
      | <id> | <name> | <job> |
    Cuando se da inicio al proceso de actualizacion de datos usuario con id <id>
    Entonces el usuario validara sus datos en el sistema
      | id   | name   | job   |
      | <id> | <name> | <job> |
    Ejemplos:
      | id | name    | job    |
      | 1  | George1 | Bluth1 |

  @Delete
  Esquema del escenario: Se quiere eliminar el usuario del sistema
    Cuando se da inicio al proceso de eliminacion del usuario con id <id>
    Entonces se validara el statuscode <statusCode>
    Ejemplos:
      | id | statusCode |
      | 1  | 204        |