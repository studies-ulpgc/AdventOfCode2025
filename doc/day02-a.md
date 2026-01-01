La clase GiftShopChecker encapsula la lógica
de chequeo, mientras InvalidIDRule permite 
extender reglas sin modificar la clase (OCP). 
RepeatedTwiceRule implementa la regla concreta, 
cumpliendo SRP: cada clase tiene una sola responsabilidad.

Se aplica DRY al centralizar el parseo de rangos en 
GiftShopFactory y la expansión de rangos en GiftShopChecker. 
La interfaz InvalidIDRule y la inyección de dependencia en 
el constructor cumplen DIP, desacoplando la regla de la 
lógica de chequeo.

Se usa la técnica de diseño Factory (GiftShopFactory) 
para construir objetos desde strings.