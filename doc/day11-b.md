Aquí se cuentan rutas en un grafo dirigido, 
pero con restricciones: ciertas rutas solo son 
válidas si se visitan nodos específicos (como “dac” y “fft”).

La clase ConstrainedPathCounter encapsula la lógica 
de restricciones, separando claramente estado de visita 
(VisitState) de la estructura del grafo (DirectedGraph).

Se aplica SRP, ya que el seguimiento de estados, conteo 
de rutas y parseo de grafo son responsabilidades separadas.