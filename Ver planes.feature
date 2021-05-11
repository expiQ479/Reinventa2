Feature: Ver todos los planes
  Como un usuario
  Quiero ver todos los planes
  porque quiero ver que he estado haciendo

  Scenario: Ver todos los planes
    Given Hay planes hechos
    When Presiono el boton de ver los planes
    Then Se me muestran todos los planes