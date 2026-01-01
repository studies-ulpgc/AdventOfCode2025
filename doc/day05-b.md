Esta variante calcula la cantidad de IDs frescos
considerando rangos solapados. La clase 
FreshRangeCalculator encapsula la lógica de cálculo,
respetando SRP y OCP, reutilizando IngredientDatabase
como fuente de datos.

Se mantiene DRY al centralizar la ordenación y el 
conteo incremental de IDs frescos. El algoritmo 
con currentEnd actúa como centinela para manejar 
solapamientos de rangos de forma eficiente.