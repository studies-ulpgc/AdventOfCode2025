Esta variante calcula el máximo joltage considerando
un número fijo de celdas seleccionadas (selectCount).
Se reutilizan las mismas clases (BatteryBank, 
BatteryCells, BankParser) respetando OCP, agregando 
nueva funcionalidad sin modificar la estructura existente.

Se sigue aplicando SRP y DRY, centralizando la lógica 
de selección de subsecuencias y la construcción de números.