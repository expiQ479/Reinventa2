Given('Hay un {string} creado') do |string|
 @string=string
end

When('Presiono el boton de hecho al lado del plan') do
 @salida= eval(@string).to_s
end

Then('Obtengo la experiencia del plan y actualizo el estado del plan a finalizado') do |salida_esperada|
 @salida.should == salida_esperada
end