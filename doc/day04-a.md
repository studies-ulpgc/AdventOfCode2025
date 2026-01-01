Este ejercicio calcula los rollos de papel accesibles
para un montacargas. La clase ForkliftAccess encapsula
la lógica de determinación de accesibilidad, mientras 
PaperMap representa el mapa del almacén, cumpliendo SRP. 
La construcción del mapa desde los datos sigue un 
patrón de Factory Method implícito.
Se mantiene DRY al centralizar la verificación de rollos 
y la evaluación de accesibilidad.