Se busca calcular el número mínimo de operaciones 
necesarias para alcanzar un objetivo de voltajes 
en máquinas más complejas, donde cada botón afecta 
contadores y se aplican reglas de paridad.

Se reutiliza la estructura de parte A: Machine y Button 
siguen siendo records, y MachineFactory parsea datos de 
entrada.

La clase VoltageSolver encapsula toda la lógica de cálculo 
de paridad, usando memoización para evitar recomputaciones. 
Esto sigue los principios SRP y Encapsulación, manteniendo
el algoritmo separado de los datos y de la entrada/salida.