@Feature1
Feature: FUNCIONALIDAD - Validación simulador de ahorro de carro o moto de Bancolombia 
COMO un usuario web
QUIERO validar el simulador de ahorro de carro o moto de Bancolombia
PARA cumplir con el reto de Serenity con ScreenPlay.

  Background: Abrir la pagina de Bancolombia solicitada
    Given que carlos ingresa a la pagina de Bancolombia
      And ingresa en el simulador de ahorro e inversion
  
  @tag1    
  Scenario: Validacion de formulario vacio
     When carlos no ingresa ningun valor en los campos del formulario
     Then carlos espera ver los mensajes de alerta Este campo es obligatorio. en cada uno de los campos
     
  @tag2    
  Scenario: Validacion de los campos en el edit text de ahorro
     When carlos ingresa al campo de ahorro
     Then carlos espera encontrar 8 opciones diferentes
     
  @tag3    
  Scenario: Validacion de la ausencia del warning al ingresar valor en el campo de los meses
     When carlos digita el numero 33 en el edit text de los meses
     Then carlos espera que el mensaje de warning no este presente
     
  @tag4    
  Scenario: Validacion de la ausencia de los items en el campo de los productos
     When carlos ingresa un valor del archivo de excel en el campo del ahorro y 33 en el campo de los meses
     Then carlos espera que en el campo de los productos hayan 3 opciones
     
  @tag5    
  Scenario: Validacion de los mensajes de warning del campo de dinero
     When carlos escribe el texto 300000 en el edit text del dinero
     Then carlos espera el mensaje El campo no cumple con el valor minimo en el primer texto y El campo no cumple con el valor maximo en el segundo texto 
     
  
  
