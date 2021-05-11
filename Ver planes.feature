Feature: Aceptar los planes, es decir, hacer un check de los planes hechos
  Como un usuario
  Quiere poder checkear los planes
  Porque quiero obtener experiencia de los mismos y quiero actualizar mi lista de planes
	
  Scenario: Checkear los planes
	Given Hay planes creados
	When Presiono el boton de hecho al lado del plan
	Then Obtengo la experiencia del plan y actualizo el estado del plan a finalizado