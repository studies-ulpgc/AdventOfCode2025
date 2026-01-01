Este ejercicio calcula el máximo joltage de cada
banco de baterías. La clase BatteryBank encapsula 
la lista de BatteryCells, mientras BankParser se 
encarga de parsear cada línea, cumpliendo SRP. 
La construcción de BatteryBank desde los datos 
sigue un patrón de Factory Method implícito.

Se mantiene DRY al centralizar la extracción de 
dígitos y la lógica de subsecuencia máxima en 
métodos privados.