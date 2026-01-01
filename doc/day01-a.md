Este ejercicio modela un dial circular 
aplicando órdenes left pointing. 
La clase Dial es inmutable, 
encapsula su estado (position, zeroCount) y 
cumple SRP al solo manejar el dial, 
mientras Order representa la orden y OrdersParser 
se encarga del parseo. Se respeta OCP porque se 
pueden añadir nuevos métodos sin modificar los 
existentes y se usan principios DRY y Tell, Don’t Ask. 
Se implementa un Factory Method (Dial.create). 
El valor 0 funciona como centinela para detectar eventos.