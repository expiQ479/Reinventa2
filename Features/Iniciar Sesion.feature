Feature: Iniciar sesion en el sistema
  Como un usuario
  Quiero acceder a la aplicación
  porque quiero usar las funcionalidades de la aplicacion

  Scenario: Acceder a las funcionalidades de la app
    Given Datos del usuario que quiere iniciar
    When Presiono el boton de iniciar sesion
    Then Se accede a la app si el usuario existe