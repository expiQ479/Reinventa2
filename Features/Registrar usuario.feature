Feature: Registrarse en el sistema
  Como un usuario
  Quiero acceder a la aplicación
  porque quiero usar las funcionalidades de la aplicacion

  Scenario: Registrarse en la app
    Given Datos del usuario que quiere registrarse
    When Presiono el boton de registrarse
    Then Se añade el usuario a la base de datos