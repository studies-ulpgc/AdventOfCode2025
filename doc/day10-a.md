El objetivo es determinar el número mínimo de 
pulsaciones necesarias para alcanzar un estado de 
luces objetivo en varias máquinas (Machine). Cada
máquina contiene botones (Button) que afectan un 
conjunto de luces.

Se utiliza programación por interfaces y separación
de responsabilidades: MachineFactory se encarga solo 
de parsear los datos de entrada, LightSolver solo de 
calcular la solución, y Machine y Button son records 
inmutables que representan datos.

Se aplica principio SRP (Single Responsibility) en todas 
las clases y Open/Closed, ya que se podrían cambiar 
las reglas de resolución sin alterar 
la estructura de clases base.