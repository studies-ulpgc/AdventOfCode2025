El objetivo es contar todas las rutas posibles en 
un grafo dirigido desde un nodo de inicio hasta un 
nodo de destino.

Se aplica programación modular y separación de 
responsabilidades: GraphParser se encarga de parsear
la entrada, DirectedGraph representa la estructura del 
grafo, y PathCounter realiza la lógica de conteo de rutas.

El diseño permite extender la lógica del grafo o cambiar 
el algoritmo de recorrido sin modificar las clases de 
entrada o de representación de datos (Open/Closed).