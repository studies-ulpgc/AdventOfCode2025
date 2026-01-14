# Day 9

## 1. Visión General
Este sistema busca calcular el área del rectángulo más grande formado por un conjunto de puntos. La solución evoluciona de un cálculo de fuerza bruta a una búsqueda restringida dentro de un área geométrica compleja (**Polygon**), aplicando una arquitectura basada en interfaces.

---

## 2. Arquitectura y Principios de Diseño

### Fundamentos Aplicados
* **Abstracción**: Uso de la interfaz `LargestRectangleFinder` para desacoplar el algoritmo de búsqueda de la clase que lo ejecuta (`Day09`).
* **Modularidad**: Separación clara entre modelos geométricos (`Point`, `Rectangle`, `Polygon`) y la lógica de cálculo (`Finder`).
* **Bajo Acoplamiento**: Los solvers dependen de la abstracción `LargestRectangleFinder`, no de implementaciones concretas.

### Principios de Diseño
* **Open/Closed Principle (OCP)**: El sistema está abierto a la extensión (podemos crear un `OptimizedRectangleFinder`) pero cerrado a la modificación. No hubo que cambiar la interfaz para añadir la lógica del Polígono.
* **Single Responsibility (SRP)**:
  * `Polygon`: Se encarga exclusivamente de la lógica espacial (algoritmo de Ray-casting para saber si un punto está dentro).
  * `Rectangle`: Centraliza el cálculo de dimensiones y área.
* **Composición sobre Herencia (COI)**: `PolygonConstrainedRectangleFinder` utiliza la agregación para incluir un objeto `Polygon`, en lugar de heredar de una clase base compleja.

---

## 3. Patrones y Técnicas

* **Strategy Pattern**: La interfaz `LargestRectangleFinder` actúa como una estrategia. Dependiendo de si estamos en la parte A o B, inyectamos una "estrategia" de búsqueda diferente.
* **Factory Method**: `PolygonFactory` encapsula la creación de polígonos, simplificando la instanciación desde listas de puntos.
* **Programación Funcional (Streams)**:
  * **Parsing**: `PointParser` utiliza Streams para transformar el CSV en una lista de objetos `Point` de forma declarativa.
  * **Validación**: En `Polygon.containsRectangle`, se usa `.stream().allMatch(...)` para verificar que todos los vértices del rectángulo cumplen la condición, mejorando la legibilidad.
* **Tell, Don't Ask**: El finder no calcula si el rectángulo es válido manualmente; le pregunta al polígono: `polygon.containsRectangle(rect)`.

---

## 4. Diagrama de Clases (UML)

![Diagrama UML de clases](uml/day9.png)

*El diagrama muestra el uso de la interfaz LargestRectangleFinder como eje central del diseño polimórfico.*
