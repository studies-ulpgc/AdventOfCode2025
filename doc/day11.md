# Day 11
## 1. Visión General
Este sistema calcula el número de rutas posibles en un grafo dirigido. La evolución del código (A a B) muestra cómo pasar de un conteo simple a uno restringido por estados específicos, manteniendo la **Modularidad** y el **Bajo Acoplamiento**.

---

## 2. Arquitectura y Principios de Diseño

### Fundamentos Aplicados
* **Abstracción**: El `DirectedGraph` (implementado como un `record`) oculta la complejidad del mapa de adyacencia tras el método `nextNode(node)`.
* **Alta Cohesión**:
  * `GraphParser`: Solo sabe convertir texto en estructura de datos.
  * `PathCounter`: Solo sabe recorrer el grafo.
  * `VisitState`: Encapsula la lógica de las condiciones de visita (inmutabilidad).
* **Código Expresivo**: El uso de nombres como `allRequiredNodesVisited` hace que la lógica de negocio sea legible sin comentarios.

### Principios de Diseño
* **Single Responsibility (SRP)**: Cada clase tiene una razón única para cambiar. Si cambia el formato del archivo, solo toco el `GraphParser`.
* **Inmutabilidad**: `VisitState` y `DirectedGraph` son inmutables. Cada movimiento genera un nuevo estado, evitando errores de concurrencia o de limpieza de rastro en la recursividad.
* **Don't Repeat Yourself (DRY)**: Ambos solvers (A y B) reutilizan el mismo `GraphParser` y el objeto de dominio `DirectedGraph`.

---

## 3. Patrones y Técnicas

* **Programación Funcional (Streams)**:
  * **Abstracción de Recorrido**: En `countPaths`, se utiliza `.stream().mapToLong(...).sum()`. Esto permite ver el flujo de datos de forma declarativa, abstrayendo el control de flujo manual y reduciendo la complejidad ciclomática.
  * **Parsing**: `GraphParser` utiliza `Collectors.toMap` y `Arrays.stream` para procesar la entrada en una sola expresión funcional.
* **Memoización (Dynamic Programming)**: Se utiliza un `Map<String, Long>` como caché de resultados. Esto es para evitar cálculos redundantes en grafos con múltiples caminos.
* **Encapsulamiento de Estado**: `VisitState` aplica el principio de **Tell, Don't Ask**. El contador le dice al estado que visite un nodo y luego le pregunta si ya lo ha visitado (`allRequiredNodesVisited`), sin conocer las reglas internas de qué nodos son obligatorios.

---

## 4. Diagrama de Clases (UML)

![Diagrama UML de clases](uml/day11.png)

*El diagrama muestra la separación entre la infraestructura de datos (model) y los motores de cálculo (A y B).*
