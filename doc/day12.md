El objetivo es determinar cuántos "regiones" pueden
completarse con un conjunto de formas, considerando
rotaciones y reflejos de cada forma.
Se utiliza SRP (Single Responsibility Principle) en: 
Worksheet, que maneja la lógica de colocación y validación 
de piezas. Shape genera variantes de cada pieza 
(rotaciones y reflejos).  Region almacena información 
de cada región. WorksheetParser y WorksheetParserFactory
se encargan de parsear la entrada y crear objetos Worksheet.

Shape y Region son inmutables, asegurando que sus
propiedades no cambien después de la creación.

Worksheet mantiene las piezas y regiones internamente,
evitando que la lógica de colocación dependa de estructuras
externas.