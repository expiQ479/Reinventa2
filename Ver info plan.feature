Feature: Ver info sobre un plan
  Como un usuario
  Quiero ver la informacion de un plan
  Porque quiero ver en detalle en que consiste mi plan

  Scenario: Ver info sobre los planes
    Given Hay planes hechos
    When Presiono el boton de ver la informacion del plan
    Then Se me muestran la informacion del plan que quiero ver