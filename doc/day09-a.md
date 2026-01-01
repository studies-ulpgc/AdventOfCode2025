El objetivo es encontrar el rectángulo más grande 
posible entre un conjunto de puntos (Point). La 
clase LargestRectangleFinderPart1 implementa la 
interfaz LargestRectangleFinder, siguiendo el 
principio de programación por interfaces. Cada 
clase tiene una única responsabilidad: parsear los 
puntos (PointParser) o calcular el área 
(LargestRectangleFinderPart1), aplicando así el 
principio Single Responsibility (SRP). Se emplean 
records para datos inmutables (Point, Rectangle) y 
se evita acoplamiento innecesario entre la lógica de 
lectura de datos y cálculo geométrico.