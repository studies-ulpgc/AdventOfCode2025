Se construye un grafo a partir de puntos 3D (Point) 
y aristas (Edge) para calcular el producto de los 
tamaños de los tres componentes más grandes. Se aplica
el patrón Factory (PointFactory) para la creación de 
puntos y un enfoque tipo Builder (CircuitBuilder) para
construir y analizar el grafo. Cada clase cumple una 
única responsabilidad: lectura de datos, construcción 
del grafo o cálculo de resultados, respetando principios
SOLID como Single Responsibility y Open/Closed. Además, 
se utilizan records para datos inmutables y UnionFind para
manejar eficientemente los componentes.