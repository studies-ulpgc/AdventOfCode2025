Esta variante extiende la validación de IDs 
usando la regla RepeatedAtLeastTwiceRule, que 
detecta repeticiones consecutivas de dígitos. 
La clase GiftShopChecker sigue cumpliendo SRP, 
mientras la regla concreta implementa la interfaz 
InvalidIDRule, respetando OCP al permitir nuevas 
reglas sin modificar la lógica principal.

Se mantiene DRY al reutilizar GiftShopFactory 
para parsear rangos y la expansión de IDs en 
GiftShopChecker. La interfaz y la inyección 
de dependencia cumplen DIP, desacoplando la 
regla de la comprobación.