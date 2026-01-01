Se busca el rectángulo más grande que además 
esté contenido dentro de un polígono (Polygon).
Aquí se reutiliza la estructura de la parte A, 
aplicando polimorfismo a través de la misma interfaz
LargestRectangleFinder. La clase Polygon encapsula la
lógica compleja de contención de puntos y verificación
de intersecciones, siguiendo principio de responsabilidad
única y favoreciendo Open/Closed, ya que nuevas reglas
geométricas podrían añadirse sin modificar las clases 
existentes. Además, se utiliza un Factory (PolygonFactory)
para la creación de polígonos desde listas de puntos.